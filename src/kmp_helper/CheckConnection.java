package kmp_helper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROG
 */
public class CheckConnection {
    
    public static void main(String[] args) {
        isConnected();
        showforminputbarang();
        showforminputbarang2();
        showforminputbarang3();
        showTransaksi();
    }
    
    private static boolean isConnected(){
        try {
            ConnectionHelper.getConnection();
            System.out.println("Database Connected");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to connect database");
            return false;
        }
    }
    
    public static void showforminputbarang(){
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from tbl_barang");

            while (rs.next()){
                System.out.println("Kode Barang : "+rs.getString("kd_barang")+ ", Nama Barang: "+rs.getString("nama_barang")
                        +", Harga Barang: "+rs.getString("harga_barang"));
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showforminputbarang2(){
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from tbl_barang2");

            while (rs.next()){
                System.out.println("Kode Barang : "+rs.getString("kd_barang")+ ", Nama Barang: "+rs.getString("nama_barang")
                        +", Harga Barang: "+rs.getString("harga_barang"));
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showforminputbarang3(){
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from tbl_barang3");

            while (rs.next()){
                System.out.println("Kode Barang : "+rs.getString("kd_barang")+ ", Nama Barang: "+rs.getString("nama_barang")
                        +", Harga Barang: "+rs.getString("harga_barang"));
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showTransaksi(){
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from dataprodukcf");

            while (rs.next()){
                System.out.println("No.Stand : "+rs.getString("no_stand")+ ", Nama Barang: "+rs.getString("nama_barang")
                        +", Harga Satuan: "+rs.getString("harga_satuan")+ ", Jumlah Beli : "+rs.getString("jumlah_beli"));
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
