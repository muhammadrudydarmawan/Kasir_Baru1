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
import model.forminputbarang2;

/**
 *
 * @author ROG
 */
public class SFManager {
    public static List<forminputbarang2> showforminputbarang2(){
        List<forminputbarang2> sfList = new ArrayList<>();
        
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from forminputbarang2");
            while(rs.next()){
                forminputbarang2 sf = new forminputbarang2();
                sf.setkd_barang(Integer.parseInt(rs.getString("kd_barang")));
                sf.setNama_barang(rs.getString("nama_barang"));
                sf.setHarga_barang(rs.getString("harga_barang"));
               
                sfList.add(sf);
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sfList;
    }
}
