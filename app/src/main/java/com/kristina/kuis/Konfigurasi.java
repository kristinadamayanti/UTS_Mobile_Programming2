package com.kristina.kuis;

public class Konfigurasi {
    public static final String URL_ADD="http://192.168.43.247/android/tumbuhan/tambah.php";
    public static final String URL_GET_ALL = "http://192.168.43.247/android/tumbuhan/tampilall.php";
    public static final String URL_GET_EMP = "http://192.168.43.247/android/tumbuhan/tampil.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.247/android/tumbuhan/update.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.247/android/tumbuhan/hapus.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_KATEGORI = "kategori"; //desg itu variabel untuk posisi

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_KATEGORI = "kategori";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
