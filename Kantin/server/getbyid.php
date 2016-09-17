<?php
require("conn.php");
$id= $_GET['id'];
$query = "SELECT * from menu where id='$id'";
$que = mysqli_query($con,$query) or die("Error: ".mysqli_error($con));
$arraya = array();  

$index=0;
while($row = mysqli_fetch_assoc($que))  
{
	 $arraya[] =$row;
     $index++;
}
//print_r($arraya);exit;

echo json_encode(array('result'=>$arraya));

?>