#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Build Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="output.`date +%F`"

make -C /var/www/html/svn/trunk/ publish &> $MESSAGE_FILE

/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

