package Admin;
import User.*;
import java.sql.*;
import Admin.Login.Login_Admin;
import Connection.Connection;
import static User.Kriteria.ipk;
import static User.Kriteria.jarak;
import static User.Kriteria.jpo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Data_Kriteria extends javax.swing.JFrame {
    private java.sql.Connection conn = new Connection().connect();
    private Image logo;
    private DefaultTableModel tabelmode;
    public static double ipk;
    public static int jpo,jarak;
    public Data_Kriteria() {
        initComponents();
        table();
        empty();
        convertipk();
        convertjarak();
        convertJPO();
        TableKriteria.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        TableKriteria.getTableHeader().setOpaque(false);
        TableKriteria.getTableHeader().setBackground(new Color(32, 136, 203));
        TableKriteria.getTableHeader().setForeground(new Color(255, 255, 255));
    }
    public void convertipk(){
            if(ipk>=3.85&&ipk<=4.00){
                ipk = 100;
            }else if(ipk>=3.70&&ipk<3.85){
                ipk = 95;
            }else if(ipk>=3.55&&ipk<3.70){
                ipk = 90;
            }else if(ipk>=3.40&&ipk<3.55){
                ipk = 85;
            }else if(ipk>=3.25&&ipk<3.40){
                ipk = 80;
            }else if(ipk>=3.10&&ipk<3.25){
                ipk = 75;
            }else if(ipk>=2.95&&ipk<3.10){
                ipk = 65;
            }
    }
    public void convertjarak(){
            if(jarak>15){
                jarak = 65;
            }else if(jarak>=12&&jarak<15){
                jarak = 72;
            }else if(jarak>=9&&jarak<12){
                jarak = 80;
            }else if(jarak>=6&&jarak<9){
                jarak = 87;
            }else if(jarak>=3&&jarak<6){
                jarak = 93;
            }else if(jarak>=0&&jarak<3){
                jarak = 100;
            }
    }
    public void convertJPO(){

            if(jpo>=0&&jpo<=2500000){
                jpo = 100;
            }else if(jpo>2500000&&jpo<=3500000){
                jpo = 88;
            }else if(jpo>3500000&&jpo<=4000000){
                jpo = 80;
            }else if(jpo>4000000&&jpo<=5500000){
                jpo = 72;
            }else if(jpo>5500000&&jpo<=7000000){
                jpo = 64;
            }else if(jpo>7000000){
                jpo = 54;
            }
    }
    public void empty(){
        thasil.setText("");
        tipk.setText("");
        //cbnpm.setSelectedIndex(0);
        tjarak.setText("");
        tperilaku.setText("");
    }
    public void table(){
        Object [] Baris ={"Hasil Tes", "IPK", "JPO", "Jarak", "Perilaku"};
        tabelmode = new DefaultTableModel(null, Baris);
        try{
            String SQL = "SELECT * FROM kriteria order by NPM asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabelmode.addRow(new Object[]{
                    Result.getInt(1),
                    Result.getInt(2), 
                    Result.getDouble(3),
                    Result.getInt(4), 
                    Result.getInt(5)});     
                }TableKriteria.setModel(tabelmode);
            }
        catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+yusuf);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableKriteria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bsave = new Button.Button();
        bcancel = new Button.Button();
        thasil = new Text.TextFields();
        tipk = new Text.TextFields();
        tjarak = new Text.TextFields();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        InputDiri = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        InputKriteria = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        About = new javax.swing.JLabel();
        tjpo = new Text.TextFields();
        tperilaku = new Text.TextFields();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(228, 228, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Kriteria", "Hasil Tes", "IPK", "Jumlah Penghasilan Orang Tua", "Jarak", "Perilaku"
            }
        ));
        TableKriteria.setGridColor(new java.awt.Color(0, 0, 0));
        TableKriteria.setRowHeight(25);
        TableKriteria.setSelectionBackground(new java.awt.Color(232, 57, 95));
        TableKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableKriteria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 767, 171));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hasil Tes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 93, -1, -1));

        bsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bsave.setText("Update");
        bsave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });
        jPanel1.add(bsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 145, -1));

        bcancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bcancel.setText("Delete");
        bcancel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });
        jPanel1.add(bcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 390, 145, -1));
        jPanel1.add(thasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 94, 379, -1));
        jPanel1.add(tipk, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 148, 379, -1));
        jPanel1.add(tjarak, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 257, 379, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("IPK (0.00 - 4.00)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 155, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Penghasilan Orang Tua");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 202, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Jarak Rumah (Km)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 264, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Nilai Perilaku");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 311, -1, -1));

        jPanel7.setBackground(new java.awt.Color(32, 136, 203));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        Logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(32, 136, 203));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Home.setForeground(new java.awt.Color(255, 255, 255));
        Home.setText("DATA USER");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(32, 136, 203));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.setAutoscrolls(true);
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        InputDiri.setBackground(new java.awt.Color(255, 255, 255));
        InputDiri.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InputDiri.setForeground(new java.awt.Color(255, 255, 255));
        InputDiri.setText("DATA MAHASISWA");
        InputDiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputDiriMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(32, 110, 197));
        jPanel5.setPreferredSize(new java.awt.Dimension(142, 39));

        InputKriteria.setBackground(new java.awt.Color(255, 255, 255));
        InputKriteria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InputKriteria.setForeground(new java.awt.Color(255, 255, 255));
        InputKriteria.setText("DATA NILAI MAHASISWA");
        InputKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputKriteriaMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(32, 136, 203));

        About.setBackground(new java.awt.Color(255, 255, 255));
        About.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        About.setForeground(new java.awt.Color(255, 255, 255));
        About.setText("NORMALISASI");
        About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(About)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(About, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(InputKriteria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(InputKriteria)
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InputDiri)
                .addGap(129, 129, 129))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InputDiri, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(Home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addGap(176, 176, 176)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 777));
        jPanel1.add(tjpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 203, 379, -1));
        jPanel1.add(tperilaku, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 312, 379, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Data Kriteria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        new Data_Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        new Data_Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        new Data_User().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        empty();
    }//GEN-LAST:event_bcancelActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        ipk = Double.valueOf(tipk.getText());
        jarak = Integer.parseInt(tjarak.getText());
        jpo = Integer.parseInt(tjpo.getText());
        convertipk(); convertjarak(); convertJPO();
        String SQL = "update kriteria set Hasil_Tes=?, IPK=?, JPO=?, Jarak=?, Perilaku=? where Hasil_Tes='"+thasil.getText()+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
            State.setString(1, thasil.getText());
            State.setString(2, String.valueOf(ipk));
            State.setString(3, String.valueOf(jpo));
            State.setString(4, String.valueOf(jarak));
            State.setString(5, tperilaku.getText());
            State.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            empty();
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "Data gagal Disimpan " +yusuf);
        }table();
    }//GEN-LAST:event_bsaveActionPerformed

    private void InputKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputKriteriaMouseClicked
        new Data_Kriteria().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_InputKriteriaMouseClicked

    private void TableKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKriteriaMouseClicked
        int brs = TableKriteria.getSelectedRow();
        String ini = tabelmode.getValueAt(brs, 0).toString();
        String itu = tabelmode.getValueAt(brs, 1).toString();
        String uhuy = tabelmode.getValueAt(brs, 2).toString();
        String uwu = tabelmode.getValueAt(brs, 3).toString();
        String ono = tabelmode.getValueAt(brs, 4).toString();
        thasil.setText(ini);
        tipk.setText(itu);
        tjpo.setText(uhuy);
        tjarak.setText(uwu);
        tperilaku.setText(ono);
    }//GEN-LAST:event_TableKriteriaMouseClicked

    private void InputDiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDiriMouseClicked
        new Data_Mhs().setVisible(true); this.dispose();
    }//GEN-LAST:event_InputDiriMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        new Data_Mhs().setVisible(true); this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void AboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMouseClicked
        new Normalisasi().setVisible(true); this.dispose();
    }//GEN-LAST:event_AboutMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Kriteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel About;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel InputDiri;
    private javax.swing.JLabel InputKriteria;
    private javax.swing.JLabel Logo;
    private javax.swing.JTable TableKriteria;
    private Button.Button bcancel;
    private Button.Button bsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private Text.TextFields thasil;
    private Text.TextFields tipk;
    private Text.TextFields tjarak;
    private Text.TextFields tjpo;
    private Text.TextFields tperilaku;
    // End of variables declaration//GEN-END:variables
}
