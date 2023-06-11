/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tampilan.Menu.Vendor;
import Tampilan.Menu.Pembelian.*;
import Tampilan.Menu.Penjualan.*;
import Tampilan.Menu.StockSparepartForm.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import Tampilan.Menu.MenuAdmin;
import Tampilan.Menu.StockSparepartForm.Save;
import koneksi.koneksi;

/**
 *
 * @author lucky
 */
 
public class Vendor extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form StockSparePart
     */
    private static Vendor vendorFrom;
    public Vendor() {
        initComponents();
        Tampil_Jam();
        Tampil_Tanggal();
        TableVendor();
        bNew.setToolTipText("NEW");
        bEdit.setToolTipText("EDIT");
        bDeleted.setToolTipText("DELETED");
        bCari.setToolTipText("CARI");
        bBack.setToolTipText("BACK TO MENU");
        txCari.setToolTipText("Cari");
        vendorFrom = this;
    }
    protected void TableVendor(){
     Object[] baris = {"NO","ID","NAMA","TYPE","ALAMAT"};
    tabmode = new DefaultTableModel(null,baris);
    TableVendor.setModel(tabmode);
    String sql = "select id,nama,type,alamat from vendor";
    try{
    java.sql.Statement stat = conn.createStatement();
            ResultSet input = stat.executeQuery(sql);
            int no = 1;
            while ( input.next()){
                String a = input.getString("id");
                String b = input.getString("nama");
                String c = input.getString("type");
                String d = input.getString("alamat");
                
                
                String[] data = {Integer.toString(no),a,b,c,d};
                tabmode.addRow(data);
                no++;
             }
        }catch (Exception ex){ex.printStackTrace();
    }
}
    public static Vendor getvendorFrom(){
        return vendorFrom;
    }
    
protected void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
 
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            LbJam.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }   

protected void Tampil_Tanggal() {
    java.util.Date tglsekarang = new java.util.Date();
    SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
    String tanggal = smpdtfmt.format(tglsekarang);
    LbTanggal.setText(tanggal);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bNew = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        txCari = new javax.swing.JTextField();
        bDeleted = new javax.swing.JButton();
        jLJam = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLTanggal = new javax.swing.JLabel();
        LbTanggal = new javax.swing.JLabel();
        LbJam = new javax.swing.JLabel();
        bCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVendor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(184, 25, 25));

        bNew.setBackground(new java.awt.Color(204, 204, 204));
        bNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/new-file.png"))); // NOI18N
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        bBack.setBackground(new java.awt.Color(204, 204, 204));
        bBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/left-arrow.png"))); // NOI18N
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        bEdit.setBackground(new java.awt.Color(204, 204, 204));
        bEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit-text.png"))); // NOI18N
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        txCari.setBackground(new java.awt.Color(204, 204, 204));
        txCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        bDeleted.setBackground(new java.awt.Color(204, 204, 204));
        bDeleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/erase.png"))); // NOI18N
        bDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletedActionPerformed(evt);
            }
        });

        jLJam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLJam.setForeground(new java.awt.Color(255, 255, 255));
        jLJam.setText("JAM");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(":");

        jLTanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLTanggal.setForeground(new java.awt.Color(255, 255, 255));
        jLTanggal.setText("TANGGAL");

        LbTanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbTanggal.setForeground(new java.awt.Color(255, 255, 255));

        LbJam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbJam.setForeground(new java.awt.Color(255, 255, 255));

        bCari.setBackground(new java.awt.Color(204, 204, 204));
        bCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/search.png"))); // NOI18N
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bNew, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLJam, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbJam, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(LbTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txCari, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLJam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LbJam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLTanggal)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(bEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addComponent(bNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDeleted, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TableVendor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableVendor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        // TODO add your handling code here:
        new TambahVendor().setVisible(true);
        
    }//GEN-LAST:event_bNewActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuAdmin("id").setVisible(true);
    }//GEN-LAST:event_bBackActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        Object[] baris = {"NO","ID","NAMA","TYPE","ALAMAT"};
    tabmode = new DefaultTableModel(null,baris);
    TableVendor.setModel(tabmode);
        
        String sql = "select id,nama,type,alamat from vendor where id like '%"+txCari.getText()+"%'"
                + " or nama like '%"+txCari.getText()+"%'"
                + " or type like '%"+txCari.getText()+"%'"
                + " or alamat like '%"+txCari.getText()+"%'";
                
        try{
    java.sql.Statement stat = conn.createStatement();
            ResultSet input = stat.executeQuery(sql);
            int no = 1;
            while ( input.next()){
                String a = input.getString("id");
                String b = input.getString("nama");
                String c = input.getString("type");
                String d = input.getString("alamat");
                
                
                String[] data = {Integer.toString(no),a,b,c,d};
                tabmode.addRow(data);
                no++;
             }
        }catch (Exception ex){ex.printStackTrace();
    }
    }//GEN-LAST:event_bCariActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        new EditVendor().setVisible(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletedActionPerformed
        // TODO add your handling code here:
        new DeleteVendor().setVisible(true);
    }//GEN-LAST:event_bDeletedActionPerformed

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
            java.util.logging.Logger.getLogger(Vendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbJam;
    private javax.swing.JLabel LbTanggal;
    private javax.swing.JTable TableVendor;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bDeleted;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bNew;
    private javax.swing.JLabel jLJam;
    private javax.swing.JLabel jLTanggal;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}