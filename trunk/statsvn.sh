#!/bin/bash

cd /var/www/html/svn/trunk/; 
rm -rvf /var/www/html/statsvn > /tmp/statsvn.log;
svn log -v --xml > logfile.log;
java -jar ../../statsvn.jar -trac http://wiki.csc.calpoly.edu/blugoo -output-dir /var/www/html/statsvn logfile.log . &> /tmp/statsvn.log

