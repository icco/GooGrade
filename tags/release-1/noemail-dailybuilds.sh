#!/bin/bash
# A daily Build Script for blugoo
# Usage ./noemail-dailybuild.sh logfile

# Log info to the specified file or /tmp/build.datetime.log
if [ $# -lt 1 ]; then
	MESSAGE_FILE="/tmp/build.`date +%s`.log";
else
	MESSAGE_FILE=$1;
fi;

# Do the building
echo "Running Ant"
cd /var/www/html/svn/trunk/goograde/;
ant clean &> /dev/null
ant -f dailybuild.xml -logfile $MESSAGE_FILE &> /dev/null

# Deploy that which you built to the web
echo "Deploying build"
cp /var/www/html/wars/GooGrade.`date +%F`.war /usr/share/tomcat5/webapps/GooGrade.war
rm -rf /user/share/tomcat5/webapps/GooGrade/
/sbin/service tomcat5 restart

