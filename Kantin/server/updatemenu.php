<?php 
if($_SERVER['REQUEST_METHOD']=='POST'){
$id 	= $_POST['id'];
$nama 	= $_POST['nama'];
$harga 	= $_POST['harga'];
$jenis 	= $_POST['jenis'];
		
require_once('conn.php');
//query update
$sql = "UPDATE menu SET nama = '$nama', harga = '$harga', jenis = '$jenis' WHERE id = $id;";

if(mysqli_query($con,$sql)){
	echo 'Menu berhasil diubah';
	}else{
	echo 'Error';
}
		
mysqli_close($con);
}