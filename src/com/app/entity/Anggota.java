/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Anggota {

    private String npm;
    private String nama;
    private String kelas;
    private String alamat;

    public Anggota() {
    }

    public Anggota(String npm, String nama, String kelas, String alamat) {
        this.npm = npm;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
    }

    public Anggota(ResultSet rs) throws SQLException {
        this.npm = rs.getString("npm");
        this.nama = rs.getString("nama");
        this.kelas = rs.getString("kelas");
        this.alamat = rs.getString("alamat");
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Object getValue(int index) {
        switch (index) {
            case 0:
                return npm;
            case 1:
                return nama;
            case 2:
                return kelas;
            case 3:
                return alamat;
            default:
                return "";
        }
    }
}
