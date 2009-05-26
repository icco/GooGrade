#!/bin/bash
# Word. A script to mail the team.

FILE="/tmp/blugooemail";
TEAMNAME="BluGoo";
SUBJECT="[BluGoo] Currently Open Tickets for `/bin/date +%r`";
EMAIL="blugoo@lists.csc.calpoly.edu";

# Because I had to hand compile fortune on the wiki server
/home/nwelch/bin/fortune /home/nwelch/tmp/fortune-mod-9708/datfiles/literature > $FILE;
 

echo "" >> $FILE;
echo "Hey, $TEAMNAME" >> $FILE;
echo "" >> $FILE;
echo "Hope everyone is doing well. Here are the tickets that are either accepted or open to each member of the team. Please remember to accept tickets, so we know who is doing what." >> $FILE;

TEAM=`echo mduder nwelch pphu vgerdin kblizard | sed 's/ /\n/g' | /home/nwelch/bin/shuf`;

for n in $TEAM; do
	echo "" >> $FILE;
	echo "$n, the following tickets are open to you:" >> $FILE;

	OUT2=`sqlite3 /trac/blugoo/db/trac.db "select id FROM ticket t LEFT JOIN enum p ON p.name = t.priority AND p.type = 'priority' WHERE t.status IN ('new', 'assigned', 'reopened') AND owner = '$n' ORDER BY (status = 'assigned') DESC, t.priority, p.value, milestone, t.type, time"`;
	OUT=`echo $OUT2 | sed 's/ /\n/g'`;

	for ticket in $OUT; do
		TITLE=`sqlite3 /trac/blugoo/db/trac.db "select summary from ticket where id='$ticket'"`;
		IN=`sqlite3 /trac/blugoo/db/trac.db "select milestone from ticket where id='$ticket'"`;
		echo " * $TITLE " >> $FILE;
		echo "   --- http://wiki.csc.calpoly.edu/blugoo/ticket/$ticket" >> $FILE;
	done;
done;

echo "" >> $FILE;
echo "Unassigned Tickets" >> $FILE;

OUT1=`sqlite3 /trac/blugoo/db/trac.db "select id FROM ticket t LEFT JOIN enum p ON p.name = t.priority AND p.type = 'priority' WHERE t.status IN ('new', 'assigned', 'reopened') AND owner = '' ORDER BY (status = 'assigned') DESC, p.value, milestone, t.type, time"`;
OUT=`echo $OUT1 | sed 's/ /\n/g'`;

for ticket in $OUT; do
	TITLE=`sqlite3 /trac/blugoo/db/trac.db "select summary from ticket where id='$ticket'"`;
	echo " * $TITLE" >> $FILE;
	echo "   --- http://wiki.csc.calpoly.edu/blugoo/ticket/$ticket" >> $FILE;
done;

echo -e "\nSee you later, \n The BluGoo Trac Installation" >> $FILE;

# Send the email like a champ.
/bin/mail -s "$SUBJECT" "$EMAIL" < $FILE

