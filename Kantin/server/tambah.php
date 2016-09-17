<?php
require_once("conn.php");

$nama= $_GET['nama'];
$harga= $_GET['harga'];
$jenis= $_GET['jenis'];

$response = array();
//add the users details to the database
$q="INSERT INTO menu (nama,harga,jenis) VALUES ('$nama', '$harga','$jenis')";
$result = mysqli_query($con,$q) ;

if($result){

echo "Menu ".$nama." Dibuat!";

} else {

echo "Error ";

}
echo json_encode($response);
?>