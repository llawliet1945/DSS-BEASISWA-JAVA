package User;
import java.sql.*;
import Connection.Connection;
import static User.Kriteria.ipk;
import static User.Kriteria.jarak;
import static User.Kriteria.jpo;
import User.LoginAndRegister.Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Kriteria extends javax.swing.JFrame {
    private java.sql.Connection conn = new Connection().connect();
    private Image logo;
    private DefaultTableModel tabelmode;
    public static double ipk;
    public static int jpo,jarak;
    public Kriteria() {
        initComponents();
        table();
        empty();
        dataComboBox();
        convertipk();
        convertjarak();
        convertJPO();
        TableKriteria.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        TableKriteria.getTableHeader().setOpaque(false);
        TableKriteria.getTableHeader().setBackground(new Color(32, 136, 203));
        TableKriteria.getTableHeader().setForeground(new Color(255, 255, 255));
    }
    public void dataComboBox(){
        try {
            String SQL = "SELECT * FROM mahasiswa";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
             
            while (Result.next()) {                
                cbnpm.addItem(Result.getString("NPM"));
            }
             
            int jumlahdata = Result.getRow();
            Result.first();
             
        } catch (SQLException e) {
        }
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
        cbnpm.setSelectedIndex(0);
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
                    Result.getInt(5),
                    Result.getString(6)});     
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
        cbnpm = new javax.swing.JComboBox<String>();
        bsave = new Button.Button();
        bcancel = new Button.Button();
        thasil = new Text.TextFields();
        tipk = new Text.TextFields();
        tjarak = new Text.TextFields();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        InputDiri = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        InputKriteria = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        InputKriteria2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tjpo = new Text.TextFields();
        tperilaku = new Text.TextFields();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(228, 228, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TableKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NPM", "Nama", "Kelas", "Prodi", "No Telp", "Alamat", "Username"
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hasil Tes");

        cbnpm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        bsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bsave.setText("Save");
        bsave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        bcancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bcancel.setText("Cancel");
        bcancel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("IPK");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Penghasilan Orang Tua");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Jarak Rumah (Km)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Nilai Perilaku");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("NPM");

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
        Home.setText("HOME");
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
        InputDiri.setText("INPUT DATA DIRI");
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
        InputKriteria.setText("INPUT KRITERIA");
        InputKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputKriteriaMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(32, 136, 203));

        InputKriteria2.setBackground(new java.awt.Color(255, 255, 255));
        InputKriteria2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InputKriteria2.setForeground(new java.awt.Color(255, 255, 255));
        InputKriteria2.setText("HASIL AKHIR");
        InputKriteria2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputKriteria2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(InputKriteria2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(InputKriteria2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(InputKriteria)
                .addContainerGap(136, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(InputKriteria)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(InputDiri)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InputDiri, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(186, 186, 186)
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
                .addGap(103, 103, 103))
        );

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setText("LOGOUT");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Logo))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addGap(176, 176, 176)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(thasil, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tjpo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tperilaku, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbnpm, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tjarak, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tipk, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(bcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(thasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tjpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tjarak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tperilaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(cbnpm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        new Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        new Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        new Kriteria().setVisible(true);
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
        String SQL = "insert into kriteria values (?,?,?,?,?,?)";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
            State.setString(1, thasil.getText());
            State.setString(2, String.valueOf(ipk));
            State.setString(3, String.valueOf(jpo));
            State.setString(4, String.valueOf(jarak));
            State.setString(5, tperilaku.getText());
            State.setString(6, String.valueOf(cbnpm.getSelectedItem()));
            State.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            empty();
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "Data gagal Disimpan " +yusuf);
        }table();
    }//GEN-LAST:event_bsaveActionPerformed

    private void InputKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputKriteriaMouseClicked
        new Kriteria().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_InputKriteriaMouseClicked

    private void TableKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKriteriaMouseClicked
        int brs = TableKriteria.getSelectedRow();
        String ini = tabelmode.getValueAt(brs, 0).toString();
        String itu = tabelmode.getValueAt(brs, 1).toString();
        String uhuy = tabelmode.getValueAt(brs, 2).toString();
        String uwu = tabelmode.getValueAt(brs, 3).toString();
        String ono = tabelmode.getValueAt(brs, 4).toString();
        String kiw = tabelmode.getValueAt(brs, 5).toString();
        thasil.setText(ini);
        tipk.setText(itu);
        tjpo.setText(uhuy);
        tjarak.setText(uwu);
        tperilaku.setText(ono);
    }//GEN-LAST:event_TableKriteriaMouseClicked

    private void InputDiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDiriMouseClicked
        new Input_Data().setVisible(true); this.dispose();
    }//GEN-LAST:event_InputDiriMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        new Input_Data().setVisible(true); this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        new Login().setVisible(true); this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void InputKriteria2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputKriteria2MouseClicked
        new Hasil_Akhir().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InputKriteria2MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kriteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Home;
    private javax.swing.JLabel InputDiri;
    private javax.swing.JLabel InputKriteria;
    private javax.swing.JLabel InputKriteria2;
    private javax.swing.JLabel Logo;
    private javax.swing.JTable TableKriteria;
    private Button.Button bcancel;
    private Button.Button bsave;
    private javax.swing.JComboBox<String> cbnpm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
