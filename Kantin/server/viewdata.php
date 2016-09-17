<?php
require("conn.php");
$jenis= $_GET['jenis'];
$query = "SELECT * from menu where jenis='$jenis' ORDER BY id DESC";
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