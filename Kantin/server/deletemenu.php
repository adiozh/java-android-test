<?php 

$id = $_GET['id'];
	
require_once('conn.php');
	
//query delete
$sql = "DELETE FROM menu WHERE id=$id;";

//Deleting record in database 
if(mysqli_query($con,$sql)){
	echo 'Berhasil dihapus';
}else{
	echo 'Error';
}

mysqli_close($con);
?>