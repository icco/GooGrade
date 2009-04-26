#!/bin/bash
# A daily Build Script for blugoo


#make -C /var/www/html/svn/trunk/ publish &> $MESSAGE_FILE

cd /var/www/html/svn/trunk/goograde/;
ant clean &> /dev/null
ant -f dailybuild.xml -logfile $MESSAGE_FILE &> /dev/null

#Setting up the webapp
cp /var/www/html/wars/GooGrade.`date +%F`.war /usr/share/tomcat5/webapps/GooGrade.war
rm -rf /user/share/tomcat5/webapps/GooGrade/
/sbin/service tomcat5 restart

