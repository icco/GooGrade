#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Build Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="/var/www/html/logs/output.`date +%F`.log"

#make -C /var/www/html/svn/trunk/ publish &> $MESSAGE_FILE

cd /var/www/html/svn/trunk/goograde/;
ant clean &> /dev/null
ant -logfile $MESSAGE_FILE &> /dev/null

#Mail it!!!
/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

