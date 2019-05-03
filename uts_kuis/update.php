<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$name = $_POST['name'];
		$kategori = $_POST['kategori'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_pegawai SET nama = '$name', kategori = '$kategori' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
		echo 'Berhasil Update Data Tumbuhan';
		}else{
		echo 'Gagal Update Data Tumbuhan';
		}
		
		mysqli_close($con);
	}
?>