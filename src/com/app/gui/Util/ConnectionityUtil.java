/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gui.Util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ConnectionityUtil {
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if(conn == null){
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setDatabaseName("perpustakaan");
            ds.setUser("root");
            ds.setPassword("");
            conn = ds.getConnection();
        }
        return conn;
    }
    
    
}
