package com.example.user.komsi.model;

public class Log {
    private String nama;
    private String kegiatan;
    private String tanggal;
    private String jam;

    public Log(String nama, String kegiatan, String tanggal, String jam){
        this.nama=nama;
        this.kegiatan=kegiatan;
        this.tanggal=tanggal;
        this.jam=jam;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getTanggal(){
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

}
