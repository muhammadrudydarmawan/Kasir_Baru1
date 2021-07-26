/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkmp;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kmp_helper.ConnectionHelper;

/**
 *
 * @author ROG
 */
public class forminputbarang extends javax.swing.JFrame {
     private DefaultTableModel model;
    /**
     * Creates new form forminputbarang
     */
    public forminputbarang() {
        initComponents();
        
        model = new DefaultTableModel();

        tabelinput.setModel(model);

        model.addColumn("kd_barang");
        model.addColumn("nama_barang");
        model.addColumn("harga_jual");
        loadData();
AutoNokode();
        
       
    }

     public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    public  void loadData() {
        bsimpan.setEnabled(true);
        bhapus.setEnabled(false);
        bedit.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_barang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("harga_jual");
            

             
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void AutoNokode() {
         try {
                      String kd_barang = "K0";
             int i = 0;
            Connection conn = ConnectionHelper.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from tbl_barang");
            while (rs.next()) {
                kd_barang = rs.getString("kd_barang");
              
            }
            kd_barang = kd_barang.substring(1);
            i = Integer.parseInt(kd_barang)+ 1;
//            
            kd_barang = "00" + i;
            kd_barang = "K0" + kd_barang.substring(kd_barang.length()-2);
            tkdbarang.setText(kd_barang);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
System.out.println(e.getStackTrace());
        }
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        thargajual = new javax.swing.JTextField();
        tkdbarang = new javax.swing.JTextField();
        tnamabarang = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(170, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CARI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        thargajual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                thargajualKeyTyped(evt);
            }
        });
        jPanel1.add(thargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 230, 30));

        tkdbarang.setEditable(false);
        tkdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdbarangActionPerformed(evt);
            }
        });
        jPanel1.add(tkdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 230, 30));

        tnamabarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnamabarangKeyTyped(evt);
            }
        });
        jPanel1.add(tnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 230, 30));

        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 100, 50));

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 100, 50));

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel1.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 100, 50));

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelinput);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 770, 180));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Harga Jual");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });
        jPanel1.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 270, 30));

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input Barang Stand 1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        exit.setText("KEMBALI");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        AplikasiKmp fb = new AplikasiKmp();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        if(tkdbarang.getText().equals("") ||tnamabarang.getText().equals("") || thargajual.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "KMP Berkah", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String kd_barang = tkdbarang.getText();
            String nama_barang = tnamabarang.getText();
            String harga_jual = thargajual.getText();
           
            try {
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                System.out.println(date); 
                String tgl = date.toString();
                Connection c = ConnectionHelper.getConnection();

                String sql = "INSERT INTO tbl_barang VALUES (?, ?, ?)";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kd_barang);
                p.setString(2, nama_barang);
                p.setString(3, harga_jual);
                
                p.executeUpdate();

//                p.close();
                
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                loadData();

                
                tkdbarang.setText("");
                tnamabarang.setText("");
                thargajual.setText("");
                

                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "KMP Berkah", JOptionPane.INFORMATION_MESSAGE);
                AutoNokode();
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tabelinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinputMouseClicked
        // TODO add your handling code here:
         bsimpan.setEnabled(false);
         bedit.setEnabled(true);
         bhapus.setEnabled(true);
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kbarang = (String) model.getValueAt(i, 0);
        tkdbarang.setText(kbarang);

        String nbarang = (String) model.getValueAt(i, 1);
        tnamabarang.setText(nbarang);

        String hjual = (String) model.getValueAt(i, 2);
        thargajual.setText(hjual);
    }//GEN-LAST:event_tabelinputMouseClicked

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
         try {
            String sql ="delete from tbl_barang where kd_barang='"+tkdbarang.getText()+"'";
            java.sql.Connection conn=(Connection)ConnectionHelper.getConnection();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil di hapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        loadData();
        tkdbarang.setText("");
        tnamabarang.setText("");
        thargajual.setText("");
    }//GEN-LAST:event_bhapusActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if(tkdbarang.getText().equals("") ||tnamabarang.getText().equals("") ||  thargajual.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "KMP Berkah", JOptionPane.INFORMATION_MESSAGE);
        }else{
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String user = (String) model.getValueAt(i, 0);
        try {
            Connection c = ConnectionHelper.getConnection();
            String sql = "UPDATE  tbl_barang SET nama_barang =  '" + tnamabarang.getText() +  "', harga_jual='"+ thargajual.getText() +"' WHERE  kd_barang ='" + tkdbarang.getText() + "'";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        } finally {
            loadData();
            tkdbarang.setText("");
            tnamabarang.setText("");
            thargajual.setText("");
            bsimpan.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "KMP Berkah", JOptionPane.INFORMATION_MESSAGE);
            AutoNokode();
        }
        }
    }//GEN-LAST:event_beditActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();

            String sql = "select * from tbl_barang where kd_barang like '%" + tcari.getText() + "%' or nama_barang like'%" + tcari.getText() + "%' " + "or harga_jual like'%" + tcari.getText() + "%'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("harga_jual");
                
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void tkdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdbarangActionPerformed

    private void tnamabarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnamabarangKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_tnamabarangKeyTyped

    private void thargajualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thargajualKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_thargajualKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
AutoNokode();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(forminputbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forminputbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forminputbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forminputbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forminputbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelinput;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField thargajual;
    private javax.swing.JTextField tkdbarang;
    private javax.swing.JTextField tnamabarang;
    // End of variables declaration//GEN-END:variables
}