#!/bin/bash

cd /var/www/html/svn/trunk/; 
rm -rvf /var/www/html/statsvn > /tmp/statsvn.log;
svn log -v --xml > logfile.log;
java -jar ../../statsvn.jar -trac http://wiki.csc.calpoly.edu/blugoo -no-developer bot -output-dir /var/www/html/statsvn -exclude "goograde/nbproject/;goograde/lib/;goograde/WEB-INF/web/styles/" logfile.log . 

