#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Build Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="output"

cd /var/www/html/svn/repo/trunk/
make publish &> $MESSAGE_FILE

/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

