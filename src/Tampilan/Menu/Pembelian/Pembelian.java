/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tampilan.Menu.Pembelian;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import Tampilan.Menu.MenuAdmin;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.User;

/**
 *
 * @author lucky
 */
public class Pembelian extends javax.swing.JFrame {
 private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form StockSparePart
     */
    private static Pembelian pembelianFrom;
    public Pembelian() {
        initComponents();
        Tampil_Jam();
        Tampil_Tanggal();
        TableBuy();
        bNew.setToolTipText("NEW");
        bEdit.setToolTipText("EDIT");
        bDeleted.setToolTipText("DELETED");
        bCari.setToolTipText("CARI");
        bBack.setToolTipText("BACK TO MENU");
        txCari.setToolTipText("Cari");
        bReport.setToolTipText("PRINT REPORT");
        pembelianFrom = this;
    }
    protected void TableBuy(){
    Object[] baris = {"NO","FAKTUR","ID VENDOR","PART NUMBER","DESCRIPTION","QTY","STATUS","TANGGAL UPDATE"};
    tabmode = new DefaultTableModel(null,baris);
    TableBuy.setModel(tabmode);
   
    String sql = "select faktur,id_vendor, SIF, Description, qty_beli, status, tanggal from beli ORDER BY tanggal desc";
    try{
    java.sql.Statement stat = conn.createStatement();
            ResultSet input = stat.executeQuery(sql);
            int no = 1;
            while ( input.next()){
                String a = input.getString("faktur");
                String b = input.getString("id_vendor");
                String c = input.getString("SIF");
                String d = input.getString("Description");
                String e = Integer.toString(input.getInt("qty_beli"));
                String f =  input.getString("status");
                Date lastUpdateDate = input.getDate("tanggal");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String g = formatter.format(lastUpdateDate);
                
                String[] data = {Integer.toString(no),a,b,c,d,e,f,g};
                tabmode.addRow(data);
                no++;
             }
            String insertSql = "insert into stockmast (sif,Description, qty)\n" +
            "select beli.SIF, beli.Description,beli.qty_beli from beli \n" +
            "left join stockmast on stockmast.SIF = beli.SIF\n" +
            "where stockmast.SIF is null ";
            PreparedStatement insertState = conn.prepareStatement(insertSql);
            insertState.executeUpdate();
            
            String updateSql = "update stockmast A left join beli B on A.SIF = B.SIF\n" +
"           set A.qty = A.qty + B.qty_beli where B.status like '%finish%'";
            PreparedStatement updateState = conn.prepareStatement(updateSql);
            updateState.executeUpdate();
            
            String deleteSql = "delete from beli where status like '%finish%'";
            PreparedStatement deleteState = conn.prepareStatement(deleteSql);
            deleteState.executeUpdate();
        }catch (Exception ex){ex.printStackTrace();
    }
}
    public static Pembelian getpembelianFrom(){
        return pembelianFrom;
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
        bReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBuy = new javax.swing.JTable();

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

        bReport.setBackground(new java.awt.Color(204, 204, 204));
        bReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        bReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportActionPerformed(evt);
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
                .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bReport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
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
                    .addComponent(LbJam, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(LbTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bReport, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(bCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TableBuy.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableBuy);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        new SaveBuy().setVisible(true);
        
    }//GEN-LAST:event_bNewActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuAdmin("id").setVisible(true);
    }//GEN-LAST:event_bBackActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        Object[] baris = {"NO","FAKTUR","ID VENDOR","PART NUMBER","DESCRIPTION","QTY","STATUS","TANGGAL UPDATE"};
        tabmode = new DefaultTableModel(null,baris);
        TableBuy.setModel(tabmode);
        
        String sql = "select faktur,id_vendor,SIF,Description,qty_beli,status,tanggal from beli where faktur like '%"+txCari.getText()+"%'"
                + " or SIF like '%"+txCari.getText()+"%'"
                + " or qty_beli like '%"+txCari.getText()+"%'"
                + " or Description like '%"+txCari.getText()+"%'"
                + " or status like '%"+txCari.getText()+"%'"
                 + " or id_vendor like '%"+txCari.getText()+"%'";
                

       try{
    java.sql.Statement stat = conn.createStatement();
            ResultSet input = stat.executeQuery(sql);
            int no = 1;
            while ( input.next()){
                String a = input.getString("faktur");
                String b = input.getString("id_vendor");
                String c = input.getString("SIF");
                String d = input.getString("Description");
                String e = Integer.toString(input.getInt("qty_beli"));
                String f =  input.getString("status");
                Date lastUpdateDate = input.getDate("tanggal");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String g = formatter.format(lastUpdateDate);
                
                String[] data = {Integer.toString(no),a,b,c,d,e,f,g};
                tabmode.addRow(data);
                no++;
             }
        }catch (Exception ex){ex.printStackTrace();
    }
    }//GEN-LAST:event_bCariActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        new EditBuy().setVisible(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletedActionPerformed
        // TODO add your handling code here:
        new DeletedBuy().setVisible(true);
    }//GEN-LAST:event_bDeletedActionPerformed

    private void bReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportActionPerformed
        // TODO add your handling code here:
        try{
            String report = "src/Tampilan/Report/In.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            parameter.put("USER", User.user);
            File report_file = new File(report);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,conn);
            JasperViewer.viewReport(jasperPrint,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bReportActionPerformed

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
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbJam;
    private javax.swing.JLabel LbTanggal;
    private javax.swing.JTable TableBuy;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bDeleted;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bReport;
    private javax.swing.JLabel jLJam;
    private javax.swing.JLabel jLTanggal;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}
