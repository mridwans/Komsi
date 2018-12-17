package com.example.user.komsi.model;

public class DataUserModel {
    private String username;
    private String password;
    private String namaUser;
    private String nipUser;
    private String email;
    private String noHP;

    public DataUserModel(String username, String password, String namaUser, String nipUser, String email, String noHP){
        this.username=username;
        this.password=password;
        this.namaUser=namaUser;
        this.nipUser=nipUser;
        this.email=email;
        this.noHP=noHP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNipUser() {
        return nipUser;
    }

    public void setNipUser(String nipUser) {
        this.nipUser = nipUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
}
