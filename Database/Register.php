
<?php
require "init.php";
$username=isset($_POST["username"])?$_POST["username"]:"";
$password=isset($_POST["password"])?$_POST["password"]:"";
$Eid=isset($_POST["Eid"])?$_POST["Eid"]:"";
$Epin=isset($_POST["Epin"])?$_POST["Epin"]:"";
$OTP=isset($_POST["OTP"])?$_POST["OTP"]:"";
$IMEI=isset($_POST["IMEI"])?$_POST["IMEI"]:"";
$MAC=isset($_POST["MAC"])?$_POST["MAC"]:"";

$sql_query= "insert into einfo (username, password, Eid, Epin, OTP,IMEI,MAC) values ('$username','$password','$Eid','$Epin','$OTP','$IMEI','$MAC')";

if($con->query($sql_query) === TRUE)
{
	echo "Registered Successfully";
}
else
{
	echo "Error: " .$sql_qry . "<br>" . $con->error;
}
$con->close();

?>


