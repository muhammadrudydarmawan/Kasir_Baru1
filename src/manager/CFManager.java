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
import model.forminputbarang;
import kmp_helper.ConnectionHelper;
import kmp_helper.CheckConnection;
/**
 *
 * @author ROG
 */
public class CFManager {
    
    public static List<forminputbarang> showforminputbarang(){
        List<forminputbarang> cfList = new ArrayList<>();
        
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from forminputbarang");
            while(rs.next()){
                forminputbarang cf = new forminputbarang();
                cf.setkd_barang(Integer.parseInt(rs.getString("kd_barang")));
                cf.setNama_barang(rs.getString("nama_barang"));
                cf.setHarga_barang(rs.getString("harga_barang"));
               
                cfList.add(cf);
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cfList;
    }
}
