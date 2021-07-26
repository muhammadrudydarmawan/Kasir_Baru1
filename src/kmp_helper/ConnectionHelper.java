package kmp_helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author ROG
 */
public class ConnectionHelper {

    public static Connection getConnection() throws SQLException { //membuat method connection 
        DriverManager.registerDriver(new Driver()); //memanggil class, untuk mengelola drive
        //membuat koneksi supaya terhubung ke database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplikasipenjualan", "root", "");
        return connection; //mengembalikan isi dari method connection
    }
}
