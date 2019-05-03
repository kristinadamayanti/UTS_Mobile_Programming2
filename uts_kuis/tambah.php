<?php

 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$name = $_POST['name'];
		$kategori = $_POST['kategori'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_tumbuhan (nama,kategori) VALUES ('$name','$kategori)";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
		echo 'Berhasil Menambahkan Pegawai';
		}else{
		echo 'Gagal Menambahkan Pegawai';
		}
		
		mysqli_close($con);
	}
?>