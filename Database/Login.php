<?php
require "init.php";
$con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);
$username=isset($_POST["username"])?$_POST["username"]:"";
$password=isset($_POST["password"])?$_POST["password"]:"";
$Eid=isset($_POST["Eid"])?$_POST["Eid"]:"";
$Epin=isset($_POST["Epin"])?$_POST["Epin"]:"";
$OTP=isset($_POST["OTP"])?$_POST["OTP"]:"";
$sql_query="select username from einfo where username like '$username' and password like '$password'";

$result=mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0)
{
echo "login Successfully";
}
else
{
	echo "Failed";	
}
?>





