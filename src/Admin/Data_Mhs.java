package Admin;
import java.sql.*;
import Connection.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Data_Mhs extends javax.swing.JFrame {
    private java.sql.Connection conn = new Connection().connect();
    private Image logo;
    private DefaultTableModel tabelmode;
    public static String npm;
    public Data_Mhs() {
        initComponents();
        table();
        empty();
        //tusername.setText(Login.getnama());
        TableMhs.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        TableMhs.getTableHeader().setOpaque(false);
        TableMhs.getTableHeader().setBackground(new Color(32, 136, 203));
        TableMhs.getTableHeader().setForeground(new Color(255, 255, 255));
    }
    public static String getnpm(){
        return npm;
    }
    public void empty(){
        tnpm.setText("");
        tnama.setText("");
        tkelas.setText("");
        cbprodi.setSelectedIndex(0);
        tno.setText("");
        talamat.setText("");
    }
    public void table(){
        Object [] Baris ={"NPM", "Nama", "Kelas", "Prodi", "No Telp", "Alamat"};
        tabelmode = new DefaultTableModel(null, Baris);
        String cari = tcari.getText();
        try{
            String SQL = "SELECT * FROM mahasiswa where NPM like '&"+cari+"&' or Nama like'%"+cari+"%' order by NPM asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            //npm = Result.getString("NPM");
            while(Result.next()){
                tabelmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getString(5),
                    Result.getString(6)});     
                }TableMhs.setModel(tabelmode);
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
        TableMhs = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        puser = new javax.swing.JPanel();
        User = new javax.swing.JLabel();
        phms = new javax.swing.JPanel();
        mhs = new javax.swing.JLabel();
        pcrit = new javax.swing.JPanel();
        Crit = new javax.swing.JLabel();
        pnormal = new javax.swing.JPanel();
        normal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bcari = new Button.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tnpm = new Text.TextFields();
        tnama = new Text.TextFields();
        tkelas = new Text.TextFields();
        cbprodi = new javax.swing.JComboBox<>();
        tno = new Text.TextFields();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        bup = new Button.Button();
        bdel = new Button.Button();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        Report = new Button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(228, 228, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TableMhs.setModel(new javax.swing.table.DefaultTableModel(
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
                "NPM", "Nama", "Kelas", "Prodi", "No Telp", "Alamat"
            }
        ));
        TableMhs.setGridColor(new java.awt.Color(0, 0, 0));
        TableMhs.setRowHeight(25);
        TableMhs.setSelectionBackground(new java.awt.Color(232, 57, 95));
        TableMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableMhs);

        jPanel7.setBackground(new java.awt.Color(32, 136, 203));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        Logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoMouseClicked(evt);
            }
        });

        puser.setBackground(new java.awt.Color(32, 136, 203));
        puser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puserMouseClicked(evt);
            }
        });

        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText("DATA USER");
        User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserMouseClicked(evt);
            }
        });

        phms.setBackground(new java.awt.Color(32, 110, 197));
        phms.setForeground(new java.awt.Color(204, 204, 204));
        phms.setAutoscrolls(true);
        phms.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        mhs.setBackground(new java.awt.Color(255, 255, 255));
        mhs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mhs.setForeground(new java.awt.Color(255, 255, 255));
        mhs.setText("DATA MAHASISWA");

        pcrit.setBackground(new java.awt.Color(32, 136, 203));
        pcrit.setPreferredSize(new java.awt.Dimension(142, 39));

        Crit.setBackground(new java.awt.Color(255, 255, 255));
        Crit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Crit.setForeground(new java.awt.Color(255, 255, 255));
        Crit.setText("DATA NILAI MAHASISWA");
        Crit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CritMouseClicked(evt);
            }
        });

        pnormal.setBackground(new java.awt.Color(32, 136, 203));

        normal.setBackground(new java.awt.Color(255, 255, 255));
        normal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        normal.setForeground(new java.awt.Color(255, 255, 255));
        normal.setText("NORMALISASI");
        normal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                normalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnormalLayout = new javax.swing.GroupLayout(pnormal);
        pnormal.setLayout(pnormalLayout);
        pnormalLayout.setHorizontalGroup(
            pnormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnormalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(normal)
                .addGap(145, 145, 145))
        );
        pnormalLayout.setVerticalGroup(
            pnormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnormalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(normal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pcritLayout = new javax.swing.GroupLayout(pcrit);
        pcrit.setLayout(pcritLayout);
        pcritLayout.setHorizontalGroup(
            pcritLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnormal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcritLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(Crit)
                .addGap(98, 98, 98))
        );
        pcritLayout.setVerticalGroup(
            pcritLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcritLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Crit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout phmsLayout = new javax.swing.GroupLayout(phms);
        phms.setLayout(phmsLayout);
        phmsLayout.setHorizontalGroup(
            phmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pcrit, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(phmsLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(mhs)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phmsLayout.setVerticalGroup(
            phmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phmsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pcrit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout puserLayout = new javax.swing.GroupLayout(puser);
        puser.setLayout(puserLayout);
        puserLayout.setHorizontalGroup(
            puserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, puserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(User)
                .addGap(161, 161, 161))
        );
        puserLayout.setVerticalGroup(
            puserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(puserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(phms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(puser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addGap(201, 201, 201)
                .addComponent(puser, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        bcari.setText("Cari");
        bcari.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NPM");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Kelas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Prodi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("No Telp");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Alamat");

        tnpm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tkelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbprodi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbprodi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Arsitektur", "Desain Komunikasi Visual", "Informatika", "Pendidikan Bahasa Indonesia", "Pendidikan Bahasa Inggris", "Pendidikan Bimbingan & Konseling", "Pendidikan Biologi", "Pendidikan Ekonomi", "Pendidikan Fisika", "Pendidikan Matematika", "Teknik Industri" }));

        tno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        talamat.setColumns(20);
        talamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        talamat.setRows(5);
        jScrollPane2.setViewportView(talamat);

        bup.setText("Update");
        bup.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupActionPerformed(evt);
            }
        });

        bdel.setText("Delete");
        bdel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdelActionPerformed(evt);
            }
        });

        Report.setText("Report");
        Report.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addGap(156, 156, 156)
                        .addComponent(tnpm, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3)
                        .addGap(147, 147, 147)
                        .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel4)
                        .addGap(151, 151, 151)
                        .addComponent(tkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5)
                        .addGap(152, 152, 152)
                        .addComponent(cbprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel6)
                        .addGap(130, 130, 130)
                        .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel7)
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(bup, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(bdel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(tnpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(tkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(cbprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bdel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void puserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puserMouseClicked
        new Data_Mhs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_puserMouseClicked

    private void CritMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CritMouseClicked
        new Data_Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CritMouseClicked

    private void UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMouseClicked
        new Data_User().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserMouseClicked

    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        new Data_Mhs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoMouseClicked

    private void TableMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMhsMouseClicked
        int brs = TableMhs.getSelectedRow();
        String ini = tabelmode.getValueAt(brs, 0).toString();
        String itu = tabelmode.getValueAt(brs, 1).toString();
        String uhuy = tabelmode.getValueAt(brs, 2).toString();
        String uwu = tabelmode.getValueAt(brs, 3).toString();
        String ono = tabelmode.getValueAt(brs, 4).toString();
        String kiw = tabelmode.getValueAt(brs, 5).toString();
        tnpm.setText(ini);
        tnama.setText(itu);
        tkelas.setText(uhuy);
        cbprodi.setSelectedItem(uwu);
        tno.setText(ono);
        talamat.setText(kiw);
    }//GEN-LAST:event_TableMhsMouseClicked

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        table();
    }//GEN-LAST:event_bcariActionPerformed

    private void bupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupActionPerformed
        String SQL = "update mahasiswa set Nama=?, Kelas=?, Prodi=?, No_Telp=?, Alamat=? where NPM='"+tnpm.getText()+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
            State.setString(1, tnama.getText());
            State.setString(2, tkelas.getText());
            State.setString(3, (String)cbprodi.getSelectedItem());
            State.setString(4, tno.getText());
            State.setString(5, talamat.getText());
            State.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil DiUbah");
            empty();
            tnpm.requestFocus();
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +yusuf);
        }table();
    }//GEN-LAST:event_bupActionPerformed

    private void bdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdelActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM mahasiswa where NPM = '"+tnpm.getText()+"'";
            try{
            PreparedStatement State = conn.prepareStatement(SQL);
            State.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil DiHapus");
            empty();
            tnpm.requestFocus();
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "Data gagal DiHapus " +yusuf);
        }table();
        }
    }//GEN-LAST:event_bdelActionPerformed

    private void normalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_normalMouseClicked
        new Normalisasi().setVisible(true); this.dispose();
    }//GEN-LAST:event_normalMouseClicked

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        try{    
            String File1 = "src/Report/ReportMhs.jasper";
            HashMap par = new HashMap();
            File report = new File(File1);
            JasperReport Jasper = (JasperReport)JRLoader.loadObject(report.getPath());
            JasperPrint Print = JasperFillManager.fillReport (Jasper, par, conn);
            JasperViewer.viewReport(Print, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception yusuf){
            JOptionPane.showMessageDialog(this, yusuf.getMessage());
        }
    }//GEN-LAST:event_ReportActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Crit;
    private javax.swing.JLabel Logo;
    private Button.Button Report;
    private javax.swing.JTable TableMhs;
    private javax.swing.JLabel User;
    private Button.Button bcari;
    private Button.Button bdel;
    private Button.Button bup;
    private javax.swing.JComboBox<String> cbprodi;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mhs;
    private javax.swing.JLabel normal;
    private javax.swing.JPanel pcrit;
    private javax.swing.JPanel phms;
    private javax.swing.JPanel pnormal;
    private javax.swing.JPanel puser;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tcari;
    private Text.TextFields tkelas;
    private Text.TextFields tnama;
    private Text.TextFields tno;
    private Text.TextFields tnpm;
    // End of variables declaration//GEN-END:variables
}
