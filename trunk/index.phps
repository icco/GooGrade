<?php
/**
 * A file that lists all files in a directory, ignoring hidden files and itself.
 * Also this uses a natural sort and a simple stylesheet.
 */

static $pass = 0;
static $total = 0;

function passed($dir,$file)
{
	global $pass;
	$content = file_get_contents($dir.$file);

	if(ereg("BUILD SUCCESSFUL",$content))
	{
		$ret = "pass";
		$pass += 1;
	} else {
		$ret = "fail";
	}

	return "<span class=\"" . $ret . "\">" . $ret . "</span>";
}



?>
<html>
<head>
<title>BluGoo Development Server</title>
<link href="style.css" rel="stylesheet" type="text/css"/> 
</head>
<body>

<h1>Welcome!</h1>
<h3>To the BluGoo Development Server</h2>

<strong>General Links</strong>
<ul>
<li><a href="usage">Server Usage</a></li>
<li><a href="javadoc">JavaDocs</a></li>
<li><a href="wars/GooGrade.<?php echo date("Y-m-d",strtotime('-12 hours')); ?>.war">Lastest .WAR file</a></li>
<li><a href="svnstat">SVN Log</a></li>
<li><a href="svnstat2">SVN Statistics</a></li>
<li><a href="statsvn">More SVN Statistics</a></li>
<li><a href="http://wiki.csc.calpoly.edu/blugoo">TRAC</a></li>
<li><a href="http://blugoo.csc.calpoly.edu:8080/GooGrade">Lastest Deployed .War File</a></li>
</ul>

<strong>Build Logs</strong>
<ul>
<?php
$dir = opendir("logs");

while($entryName = readdir($dir)) {
    $dirArray[] = $entryName;
}

closedir($dir);

//  count elements in array
$indexCount = count($dirArray);

// sort 'em, newest up top.
rsort($dirArray);

//Needs to be done since the sort is relative. This reassigns all keys.
$dirArray = array_values($dirArray);

// print 'em
// loop through the array of files and print them all
foreach($dirArray as $entry) {
if (substr("$entry", 0, 1) != ".") {
        print("<li><a href=\"logs/$entry\">$entry</a> - " . passed("logs/",$entry) . "</li>");
    }
}

?>
</ul>
<strong>Test Logs</strong>
<ul>
<?php
$dir = opendir("test");
$dirArray = array();
while($entryName = readdir($dir)) {
    $dirArray[] = $entryName;
}

closedir($dir);

//  count elements in array
$indexCount = count($dirArray);

// sort 'em, newest up top.
rsort($dirArray);

//Needs to be done since the sort is relative. This reassigns all keys.
$dirArray = array_values($dirArray);

// print 'em
// loop through the array of files and print them all
foreach($dirArray as $entry) {
if (substr("$entry", 0, 1) != ".") {
        print("<li><a href=\"test/$entry\">$entry</a> - " . passed("test/",$entry) . "</li>");
    }
}

?>
</ul>
</body>
</html>
