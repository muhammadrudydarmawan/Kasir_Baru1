/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kmp_helper.CheckConnection;
import kmp_helper.ConnectionHelper;
import model.TransaksiModel;

/**
 *
 * @author ROG
 */
public class TransaksiManager {
    public static List<TransaksiModel> shoTransaksiModel(){
        List<TransaksiModel> tfList = new ArrayList<>();
        
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from transaksi");
            while(rs.next()){
                TransaksiModel tf = new TransaksiModel();
                tf.setNo_stand(Integer.parseInt(rs.getString("no_stand")));
                tf.setNama_barang(rs.getString("nama_barang"));
                tf.setHarga_satuan(rs.getString("harga_satuan"));
                tf.setJumlah_beli(rs.getInt("jumlah_beli"));
               
                tfList.add(tf);
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tfList;
    }
}
