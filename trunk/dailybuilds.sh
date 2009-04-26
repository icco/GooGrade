#!/bin/bash
# A daily Build Script for blugoo

# Variables
SUBJECT="Daily Build Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="/var/www/html/logs/output.`date +%F`.log"

./noemail-dailybuild.sh $MESSAGE_FILE

# Mail it!!!
/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

