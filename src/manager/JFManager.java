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
import model.forminputbarang3;

/**
 *
 * @author ROG
 */
public class JFManager {
    public static List<forminputbarang3> showforminputbarang3(){
        List<forminputbarang3> jfList = new ArrayList<>();
        
        try{
            Connection conn = ConnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from forminputbarang3");
            while(rs.next()){
                forminputbarang3 jf = new forminputbarang3();
                jf.setkd_barang(Integer.parseInt(rs.getString("kd_barang")));
                jf.setNama_barang(rs.getString("nama_barang"));
                jf.setHarga_barang(rs.getString("harga_barang"));
               
                jfList.add(jf);
            }
        }catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jfList;
    }
}
