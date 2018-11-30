package com.example.user.komsi;

public class Item {
    private String nama;
    private String tanggal;
    private String pembuat;
    private String jam;

    public Item(String nama, String tanggal, String pembuat, String jam){
        this.nama=nama;
        this.tanggal=tanggal;
        this.pembuat=pembuat;
        this.jam=jam;

    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal(){
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
