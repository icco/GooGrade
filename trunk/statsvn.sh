#!/bin/bash

cd /var/www/html/svn/trunk/; 
rm -rf /var/html/www/statsvn;
svn log -v --xml logfile.log;
java -jar ../../statsvn.jar -trac http://wiki.csc.calpoly.edu/blugoo -output-dir /var/html/www/statsvn logfile.log . 

