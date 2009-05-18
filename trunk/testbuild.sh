#!/bin/bash
# A daily test script for blugoo

# Variables
SUBJECT="Daily Test Report for `date +%D`"
EMAIL="blugoo@lists.csc.calpoly.edu"
MESSAGE_FILE="/var/www/html/test/test.`date +%F`.log"

cd /var/www/html/svn/trunk/goograde/; 
#ant clean &> /dev/null
#ant &> /dev/null # This should be enabled if not being run after the daily build script
#java -cp lib/emma.jar:. emma instr -ip . -m overwrite
ant test &> $MESSAGE_FILE
#java -cp lib/emma.jar emma report -r html -sp . -in coverage.em -in coverage.ec

# cp up.
#rm -rf /var/www/html/coverage/
#cp -r /var/www/html/svn/trunk/goograde/coverage/ /var/www/html/

#echo "AddType 'text/html; charset=ISO-8859-1' html" > /var/www/html/coverage/.htaccess

# Mail it!!!
/bin/mail -s "$SUBJECT" "$EMAIL" < $MESSAGE_FILE

