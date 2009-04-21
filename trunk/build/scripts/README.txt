== Author ==
Erik Carpenter escarpen@calpoly.edu
Email me to file bug reports or give me input.

== Version ==
1.0 - This is a complete rewrite now with documentation. There might be issues.
Readme Version 1.0

== License ==
BSD? GPL? who cares just give me credit.

== General Info ==
I use tabs. They save bytes as well as make it easier to change the tab stops.
You can use expand or just your editor's tab settings.

The Ant script isn't set up to use packages currently.

If you set everything up correctly the script only runs when changes are made
to the trunk folder.

== File Hierarchy ==
trunk/
|-- build              <-- has checkstyle-all-4.4.jar and 308checks.jar
|   `-- scripts               <-- This folder is where all these files go
|       |-- built             <-- This is auto-generated
|       `-- dist              <-- Also auto-generated
|-- src
|   `-- resources
`-- test

== Set Up ==
1. Run setup.sh. `sh setup.sh`
2. You will have to manually edit dailybuild.xml and daily.sh so that the
	various variables (like executable name and main class) match those of
	your project. If you are using packages you will need to tweak the
	paths and dailybuild.xml see Files section for more information.
To run manually use the daily.sh. `sh daily.sh`
To Automate the script follow the next two steps.
3. To have the script run automatically you need to edit your crontab.
	`crontab -e` and add the line
	"0   4   *   *   * /home/user/path/to/trunk/build/scripts/daily.sh"
	The previous line runs the script at 4am every day.
	As a side note as of April 2009 this can't be done on the wiki server
	because it doesn't have javac.
4. If you want to use vogon/whatever school server is the www server (ie use
	the machine where you have the crontab running) you can skip this step, but
	will need to change the line in the daily.sh where the rsync is done to a
	cp to the correct directory. I liked to keep everything on the wiki server.
	Assuming you are transferring to the wiki server you also need to set up
	passwordless ssh from the machine you set up the crontab on to the wiki
	server so the new files can rsync with the server you are hosting them on.
	I recommend googling for "keyless ssh"
	An example link to the htdocs on the wiki server is
	http://wiki.csc.calpoly.edu/PolyCron/chrome/site/daily/index.html
	for the file located in the ~/trac-NAMEOFGROUP/htdocs/daily/index.html

== Files ==
../daily/ - Is a folder that contains all the files to be made public.
setup.sh - Makes sure you have some basic files.
daily.sh - A simple shell script for running the daily build and doing some
	menial tasks.
buildresults.html - The history for all the builds.
dailybuild.xml - The actualy ant script originally supplied by Mr. Dalbey.
	This version has been altered to add a "change log" like functionality and
	has been horribly hacked together after my team kept switching between 
	using packages and not using packages. If you are using packages you are 
	going to need to change a few of the lines. Especially those involving the
	lists of files.
	I recommend visiting http://ant.apache.org/manual/coretasklist.html for
	help with the commands.
dailybuild.log - The result of the last daily build when the cron job ran.
indexEnd.html - The end of index.html to create
indexHead.html - The beginning of index.html to create. You want to customize
	this for your team.

== Hidden Files ==
.lastVersion - The last revision that was built
.lastTime - The last time the script was run all the way to the end with
   a new build being created.
.temp.html - A temporary file for saving the old build results. Auto erased.
