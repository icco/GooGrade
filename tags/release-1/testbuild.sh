#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Test Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="/var/www/html/test/test.`date +%F`.log"

cd /var/www/html/svn/trunk/goograde/; 
ant test &> $MESSAGE_FILE

# Mail it!!!
/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

