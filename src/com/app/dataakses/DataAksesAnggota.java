/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dataakses;

import com.app.entity.Anggota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DataAksesAnggota {
    private Connection conn;

    public DataAksesAnggota(Connection conn) {
        this.conn = conn;
    }
    
    public List<Anggota> getALL () throws SQLException{
        String sql = "SELECT * FROM anggota";       
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Anggota> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Anggota(rs));
        }
        return list;
    }
    
    public Anggota getAnggotaByID (String id) throws SQLException{
    String sql = "SELECT * FROM anggota WHERE npm = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, id);
    ResultSet rs = statement.executeQuery();
    Anggota anggota = null;
    if (rs.next()){
        anggota = new Anggota(rs);
        }
    return anggota;
    }
    
    public boolean insert(Anggota anggota) throws SQLException{
    String sql = "INSERT INTO anggota VALUES(?,?,?,?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, anggota.getNpm());
    statement.setString(2, anggota.getNama());
    statement.setString(3, anggota.getKelas());
    statement.setString(4, anggota.getAlamat());
    int result = statement.executeUpdate();
    return result == 1;
    }
    
    public boolean update(Anggota anggota) throws SQLException{
    String sql = "UPDATE anggota SET nama=?,kelas=?,alamat=? WHERE npm=?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, anggota.getNama());
    statement.setString(2, anggota.getKelas());
    statement.setString(3, anggota.getAlamat());
    statement.setString(4, anggota.getNpm());
    int result = statement.executeUpdate();
    return result == 1;
    }
    
    public boolean delete(String id) throws SQLException{
    String sql = "DELETE FROM anggota WHERE npm=?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, id);
    int result = statement.executeUpdate();
    return result == 1;
    }
}
 