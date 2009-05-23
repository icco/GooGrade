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
<title>BluGoo Development Server : <?php basename(dirname(__FILE__)); ?></title>
<link href="style.css" rel="stylesheet" type="text/css"/> 
</head>
<body>

<h1>Welcome!</h1>
<strong>Logs</strong><br />
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
</body>
</html>
