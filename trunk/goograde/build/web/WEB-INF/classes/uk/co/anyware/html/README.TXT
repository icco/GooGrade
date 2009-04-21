HTML Escaping code
Copyright (C) 2000 Marc Palmer / AnyWare Ltd.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

http://www.anyware.co.uk/java for updates and other stuff

The static method uk.co.anyware.html.HTMLEscaper.escape(String) will take
the inputand return a new String having converted all "funny" characters 
for which HTML has and entity defined. I am guessing that this is HTML 3.2
compliant at the moment (i.e. there is no &euro;).

Seems to work well, but looks like it does some unnecessary manipulations at
startup. However the idea is to avoid using a Hashtable because that would 
require creation of many Character or String classes, and as this function
is probably going to be used on thousands of strings many hundreds of 
characters in length, it seems like a good idea.

Usage:

You would typically use this code to escape strings returned from a database
for presentation to the user in HTML. You should NOT escape strings that will
be used in form fields (i.e. the VALUE= attribute) and note that browsers
send you the fields of a form UN-escaped, though you probably don't want to
escape before you store the data (for the reason cited above).

Thanks to Jason Hunter for his great book "JAVA Servlet Programming" used as
the source for the entity mappings. 

Thanks to CARDIACS for making the most joyful music 
(www.cardiacs.com/button.html)

Marc Palmer
marc@anyware.co.uk
