#!/bin/sh
# Happy magic script to run a daily build.
# @author Erik Carpenter
# @version 1.0
# TO DO: CONVERT THIS TO PERL
# License: BSD? GPL? Who cares this is extremely simple. Just give me credit.

### Variables
# Location of scripts
SCRIPTS=../../../../svn/trunk/build/scripts
# Location of the checked out svn repository relative to the scripts
SVN=../../../../svn
# Output of build results
BUILD=../daily
# output file
html=dailyresults.html
# A log of the last run of this script
log=dailybuild.log
# Email to notify when the build is broken
email=blugoo@lists.csc.calpoly.edu
# The name of the .jar ex HappyFun for HappyFun_r42.jar
execname=ExecutableName
# group name
group=Blugoo
# Where to rysnc to on remote server
rsyncdir=~/trac-${group}/htdocs/
# server to rsync to
rsyncserv=wiki

cd $SCRIPTS

### Set up
# Update the svn repository
svn up $SVN >> /dev/null
# Tracks the version so we know the "Change Log" length
VER=`svnversion -n $SVN`
LASTVER=`cat .lastVersion`

# Used to determine whether the build needs to run again
TIME=`ls -l ${SVN}/trunk | grep "src" | awk '{printf "%s", $6 $7 $8}'`
LASTTIME=`cat .lastTime`

### Do the check
# Check to see if the daily build needs to run again
if [ $LASTTIME = $TIME ]
then
	 echo `date` "Already up to date. Exiting." > $log
	 exit 0
fi

### Prepare the build results file
# New builds at top of the build results
cat $html > .temp.html
rm $html
touch $html

### Run the build script
# Run the real build script creates a new buildresults.html
ant -f dailybuild.xml > $log 2>&1

### Purge
# Remove local machine information.
# Replaces /home/$USER/project with the text "buildZone"
#sed -i s-/home/$USER/project-buildZone-g ../daily/*.log

### Auto Analysis
# build is broken. the .jar doesn't exist
if [ ! -e ../daily/${execname}_r${VER}.jar ]
then
	sed -i s-\?\?\?-\<b\>Broken\</b\>-g $html
	(date; cat $log) | mail -s "Broken Build" "$email"
fi

# build has errors
grep -E "error" $log
if [ $? -eq 0 ]
then
	# If there are errors, but do not have the word "tests" in them
	grep -E "error" $log | grep -E -v "tests"
	if [ $? -eq 0 ]
	then
		sed -i s-\?\?\?-\<b\>Errors\</b\>-g $html
	else
		sed -i s-\?\?\?-\<b\>Test\ Errors\</b\>-g $html
	fi
fi

# build has warnings, but not checksytle or javadoc
grep -E "warning" $log | grep -E -v "checkstyle" | grep -E -v "javadoc"
if [ $? -eq 0 ]
then
	 sed -i s-\?\?\?-Warnings-g $html
fi

# checkstyle warnings
grep -E "checkstyle" $log | grep -E "java"
if [ $? -eq 0 ]
then
	 sed -i s-\?\?\?-Checkstyle\ Warnings-g $html
fi

# Javadoc warnings
grep -E "warning" $log | grep -E "javadoc"
if [ $? -eq 0 ]
then
	 sed -i s-\?\?\?-Javadoc\ Warnings-g $html
fi

# build is clean. this is very unlikely.
sed -i s-\?\?\?-OK-g $html

###
# Create the first part of index.html file <head> etc.
cat indexHead.html > ${BUILD}/index.html

# Insert all build results after the newest build results
cat .temp.html >> $html
rm .temp.html

# Finish the index.html to use for publicizing build results
cat $html >> ${BUILD}/index.html
cat indexEnd.html >> ${BUILD}/index.html

###
# Transfer files to wiki server (or other server)
rsync -r ${BUILD} ${USER}@${rsyncserv}:${rsyncdir}

# Make sure the permissions are correct
ssh ${USER}@wiki "/tracconfig/fixperm ${group}"

###
# Save this build's information
`svnversion -n ${SVN} > .lastVersion`
`echo ${TIME} > .lastTime`
