package com.example.user.komsi.model;

public class ListItemModel {
    private String nama;
    private String pembuat;
    private String tanggal;
    private String jam;

    public ListItemModel(String nama, String pembuat, String tanggal, String jam) {
        this.nama = nama;
        this.pembuat = pembuat;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getJam() {
        return jam;
    }
}
