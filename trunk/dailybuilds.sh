#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Build Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="/var/www/html/logs/output.`date +%F`.log"

/var/www/html/svn/trunk/noemail-dailybuilds.sh $MESSAGE_FILE

cd /var/www/html/svn/trunk/goograde/; 
ant -f dailybuild.xml test &> /var/www/html/test/test.`date +%F`.log 

# Mail it!!!
/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

