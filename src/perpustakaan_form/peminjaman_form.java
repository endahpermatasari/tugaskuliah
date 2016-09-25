/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * peminjaman_form.java
 *
 * Created on Mar 27, 2014, 1:13:48 PM
 */

package perpustakaan_form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import konfigurasi.tengah;
/**
 *
 * @author YANET
 */
public class peminjaman_form extends javax.swing.JFrame {
Connection koneksi=null;
ResultSet peminjaman=null;
DefaultTableModel tabmodel;

    /** Creates new form peminjaman_form */
    public peminjaman_form() {
        initComponents();
        tampil();
        Timertime();
        icon();
    }
    
    void icon(){
    ImageIcon ico=new ImageIcon("src/icon/book_2.png");
    setIconImage(ico.getImage());
    
    }
    
    void tampil(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Berhasil Load Driver");
        }  catch(ClassNotFoundException cnfe){
           System.out.println("Tidak ada Driver "+cnfe);
           }
        try{
           koneksi=DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan","root","");
           System.out.println("Berhasil Koneksi Database");
        }  catch(SQLException se){
           System.out.println("Gagal Koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
           }
           
        try{
            Object[] judul_kolom={"Kode Pinjam", "Id  Petugas", "Nama Petugas", "Id Anggota", "Nama Anggota", "Id Buku", "Judul Buku", "Tgl Pinjam", "Tgl Kembali"};
            tabmodel=new DefaultTableModel(null,judul_kolom);
            jTable1.setModel(tabmodel);
            Statement stm;
            stm=koneksi.createStatement();
            tabmodel.getDataVector().removeAllElements();
            peminjaman=stm.executeQuery("select * from peminjaman");
            while (peminjaman.next()){
                Object[] data={peminjaman.getString("kode_pinjam"),
                               peminjaman.getString("id_petugas"),
                               peminjaman.getString("nama_petugas"),
                               peminjaman.getString("id_anggota"),
                               peminjaman.getString("nama_anggota"),
                               peminjaman.getString("id_buku"),
                               peminjaman.getString("judul_buku"),
                               peminjaman.getString("tgl_pinjam"),
                               peminjaman.getString("tgl_kembali")
                              };
                tabmodel.addRow(data);
                }
         }  catch(Exception e){
            e.printStackTrace();
            }
    }
    void hapustable(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
    }
    public void Timertime()
    {
         int delay = 1000;
        ActionListener taskPerformer = new ActionListener() {
            private Date date;
            public void actionPerformed(ActionEvent evt) {

                DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG);
                myDate = new Date();
                date = new Date();
                
                String myString2 = DateFormat.getDateInstance().format(date);
               
               jLabel13.setText(myString2);
            }
       };
    new Timer(delay, taskPerformer).start();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Peminjaman Perpustakan");
        setBackground(new java.awt.Color(-16776961,true));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEMINJAMAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 701, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Pinjam  ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 69, 80, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Id Petugas   ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 92, 80, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Id Anggota    ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 119, 80, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Nama Anggota");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 122, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Id Buku");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 148, 80, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 145, 151, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 143, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 119, 151, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 92, 151, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 66, 151, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/disk.png"))); // NOI18N
        jButton1.setText("  Simpan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 209, 103, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/email_edit.png"))); // NOI18N
        jButton2.setText("  Edit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 209, 102, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton3.setText("  Hapus");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 209, 101, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.gif"))); // NOI18N
        jButton5.setText("Menu Utama");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 387, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pinjam", "Id  Petugas", "Nama Petugas", "Id Anggota", "Nama Anggota", "Id Buku", "Judul Buku", "Tgl Pinjam", "Tgl Kembali"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 252, 710, 124));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Judul Buku");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 148, 80, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 143, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 171, 151, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 143, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Tgl_Pinjam    ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 174, 80, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Tgl Kembali");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 174, 73, -1));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 143, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Nama Petugas");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 92, -1, 20));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.gif"))); // NOI18N
        jButton4.setText("  Clear");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 209, 93, -1));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 54, 69, 14));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Format : Tahun-Bulan-Tanggal");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Tanggal :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
    dispose();
    new menu_utama().setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        new tengah(this);
    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    jTextField1.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),0)+"");
    jTextField2.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),1)+"");
    jTextField9.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),2)+"");
    jTextField3.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),3)+"");
    jTextField4.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),4)+"");
    jTextField5.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),5)+"");
    jTextField6.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),6)+"");
    jTextField7.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),7)+"");
    jTextField8.setText(tabmodel.getValueAt(jTable1.getSelectedRow(),8)+"");
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       try{
    Statement stm=koneksi.createStatement();
    stm.executeUpdate("insert into peminjaman set kode_pinjam='"+jTextField1.getText()+"',"+
                     "id_petugas='"+jTextField2.getText()+"',"+
                     "nama_petugas='"+jTextField9.getText()+"',"+
                     "id_anggota='"+jTextField3.getText()+"',"+
                     "nama_anggota='"+jTextField4.getText()+"',"+
                     "id_buku='"+jTextField5.getText()+"',"+
                     "judul_buku='"+jTextField6.getText()+"',"+
                     "tgl_pinjam='"+jTextField7.getText()+"',"+
                     "tgl_kembali='"+jTextField8.getText()+"'");
          tampil();
          hapustable();
         jTextField1.requestFocus();
       } catch(Exception e){
         e.printStackTrace();
         }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        hapustable();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
     try{
    Statement stm=koneksi.createStatement();
    stm.executeUpdate("delete from peminjaman where kode_pinjam='"+
            tabmodel.getValueAt(jTable1.getSelectedRow(),0)+"'");
    tampil();
    hapustable();
}catch(Exception e){
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    try{
    Statement stm=koneksi.createStatement();
    stm.executeUpdate("update peminjaman set kode_pinjam='"+jTextField1.getText()+"',"+
                       "id_petugas='"+jTextField2.getText()+"',"+
                       "nama_petugas='"+jTextField9.getText()+"',"+
                       "id_anggota='"+jTextField3.getText()+"',"+
                       "nama_anggota='"+jTextField4.getText()+"',"+
                       "id_buku='"+jTextField5.getText()+"',"+
                       "judul_buku='"+jTextField6.getText()+"',"+
                       "tgl_pinjam='"+jTextField7.getText()+"',"+
                       "tgl_kembali='"+jTextField8.getText()+"'where kode_pinjam='"+
                       tabmodel.getValueAt(jTable1.getSelectedRow(),0)+"'");
    tampil();
    hapustable();
}catch(Exception e){
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peminjaman_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    private Date myDate;
}