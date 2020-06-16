package Admin;

import java.sql.*;
import Connection.Connection;
import User.Input_Data;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Normalisasi extends javax.swing.JFrame {
    private java.sql.Connection conn = new Connection().connect();
    private Image logo;
    private DefaultTableModel KriteriaTab;
    private DefaultTableModel NormalizationTab;
    private DefaultTableModel RankTab;
    public static double ipk;
    public static int jpo,jarak;
    public Normalisasi() {
        initComponents();
        table();
        krit();
        norm();
        ran();
    }
        public void krit(){
            //TableNormalization
            TableKriteria.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            TableKriteria.getTableHeader().setOpaque(false);
            TableKriteria.getTableHeader().setBackground(new Color(32, 136, 203));
            TableKriteria.getTableHeader().setForeground(new Color(255, 255, 255));
        }
        public void norm(){
            TableNormalization.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            TableNormalization.getTableHeader().setOpaque(false);
            TableNormalization.getTableHeader().setBackground(new Color(32, 136, 203));
            TableNormalization.getTableHeader().setForeground(new Color(255, 255, 255));
        }
        public void ran(){
            RankTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            RankTable.getTableHeader().setOpaque(false);
            RankTable.getTableHeader().setBackground(new Color(32, 136, 203));
            RankTable.getTableHeader().setForeground(new Color(255, 255, 255));
        }
    public void RankModel(){
        Object [] Baris ={"NPM" , "Grade"};
        RankTab = new DefaultTableModel(null, Baris);
        
        try{
            String SQL = "SELECT * FROM rank order by Grade desc";
            Statement State = conn.createStatement();
            ResultSet hasil = State.executeQuery(SQL);
            while(hasil.next()){
                RankTab.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getFloat(2)});     
                }RankTable.setModel(RankTab);
        } catch (SQLException yusuf) {
            JOptionPane.showMessageDialog(this, "data gagal dipanggil "+yusuf);
        }
    }
    public void setRank(){
    try{
            LinkedList Link = new LinkedList();
            String SQL = "SELECT * FROM kriteria order by NPM";
            Statement State = conn.createStatement();
            ResultSet result = State.executeQuery(SQL);
            RankModel();
            while (result.next()){
                 Link.add(result.getString(1));
                 Link.add(result.getString(2));
                 Link.add(result.getString(3));
                 Link.add(result.getString(4));
                 Link.add(result.getString(5));
            }
			
            for (int key = 0; key < TableNormalization.getRowCount(); key++) {
                String sql = "DELETE FROM rank WHERE NPM = NPM";
                PreparedStatement St = conn.prepareStatement(sql);
                St.executeUpdate();
            }
            for (int andro = 0; andro < TableNormalization.getRowCount(); andro++){
                float temp1;
                float temp2;
                float temp3;
                float temp4;
                float temp5;
                float HasilAkhir;
                temp1 = (Float.valueOf(TableNormalization.getValueAt(andro, 0).toString())*Float.valueOf(Link.get(0).toString()));
                temp2 = (Float.valueOf(TableNormalization.getValueAt(andro, 1).toString())*Float.valueOf(Link.get(1).toString()));
                temp3 = (Float.valueOf(TableNormalization.getValueAt(andro, 2).toString())*Float.valueOf(Link.get(2).toString()));
                temp4 = (Float.valueOf(TableNormalization.getValueAt(andro, 3).toString())*Float.valueOf(Link.get(3).toString()));
                temp5 = (Float.valueOf(TableNormalization.getValueAt(andro, 4).toString())*Float.valueOf(Link.get(4).toString()));
                HasilAkhir=temp1+temp2+temp3+temp4+temp5;
                
                String sql1 = "insert into rank values(?,?)";
                PreparedStatement St1 = conn.prepareStatement(sql1);
                St1.setString(1, (String)TableKriteria.getValueAt(andro, 5));
                St1.setFloat(2, HasilAkhir);
                St1.executeUpdate();
            }RankModel();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    public void NormalizationTab(){
        LinkedList max = new LinkedList();
        LinkedList Link = new LinkedList();
        Object [] Baris ={"C1","C2","C3","C4","C5"};
        NormalizationTab = new DefaultTableModel(null, Baris);
        try{
            String SQL = "select max(Hasil_Tes),"
                    + " max(IPK), "
                    + "max(JPO), "
                    + "max(Jarak), "
                    + "max(Perilaku) "
                    + "from "
                    + "kriteria";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                //NormalizationTab.addRow(new Object[]{
                    max.add(Result.getInt(1)); 
                    max.add(Result.getInt(2));
                    max.add(Result.getInt(3)); 
                    max.add(Result.getInt(4));
                    max.add(Result.getInt(5));
            }     
                //}TableNormalization.setModel(NormalizationTab);
                String sql = "select * from kriteria";
                Statement Stet = conn.createStatement();
                ResultSet Rslt = Stet.executeQuery(sql);
            
            while (Rslt.next()){
                NormalizationTab.addRow(new Object[]{
                    (Rslt.getFloat(1)/Float.valueOf(max.get(0).toString())),
                    (Rslt.getFloat(2)/Float.valueOf(max.get(1).toString())),
                    (Rslt.getFloat(3)/Float.valueOf(max.get(2).toString())),
                    (Rslt.getFloat(4)/Float.valueOf(max.get(3).toString())),
                    (Rslt.getFloat(5)/Float.valueOf(max.get(4).toString())),
                    //(Float.valueOf(max.get(3).toString())/Rslt.getFloat(5))
                });
                //max.get(1).toString())/Rslt.getFloat(5)
            }TableNormalization.setModel(NormalizationTab);
            }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil "+yusuf);
        }
    }

    public void table(){
        Object [] Baris ={"Hasil Tes", "IPK", "JPO", "Jarak", "Perilaku", "NPM"};
        KriteriaTab = new DefaultTableModel(null, Baris);
        try{
            String SQL = "SELECT * FROM kriteria order by NPM asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                KriteriaTab.addRow(new Object[]{
                    Result.getInt(1),
                    Result.getInt(2), 
                    Result.getDouble(3),
                    Result.getInt(4), 
                    Result.getInt(5),
                    Result.getString(6)});     
                }TableKriteria.setModel(KriteriaTab);
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
        jPanel7 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        DataMhs = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        InputKriteria = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        NormalisasiData = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableNormalization = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        RankTable = new javax.swing.JTable();
        bnormalization1 = new keeptoo.KButton();
        setRank = new keeptoo.KButton();
        bSummary = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(228, 228, 253));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel7.setBackground(new java.awt.Color(32, 136, 203));

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

        user.setBackground(new java.awt.Color(255, 255, 255));
        user.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("DATA USER");
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(32, 136, 203));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        DataMhs.setBackground(new java.awt.Color(255, 255, 255));
        DataMhs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DataMhs.setForeground(new java.awt.Color(255, 255, 255));
        DataMhs.setText("DATA MAHASISWA");
        DataMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataMhsMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(32, 136, 203));
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

        jPanel6.setBackground(new java.awt.Color(32, 110, 197));

        NormalisasiData.setBackground(new java.awt.Color(255, 255, 255));
        NormalisasiData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NormalisasiData.setForeground(new java.awt.Color(255, 255, 255));
        NormalisasiData.setText("NORMALISASI");
        NormalisasiData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NormalisasiDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(NormalisasiData)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(NormalisasiData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
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
                .addComponent(DataMhs)
                .addGap(129, 129, 129))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(user)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
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
                        .addGap(160, 160, 160)
                        .addComponent(logout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo)
                .addGap(176, 176, 176)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(41, 41, 41))
        );

        TableNormalization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "C1", "C2", "C3", "C4", "C5", "W"
            }
        ));
        TableNormalization.setRowHeight(25);
        TableNormalization.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jScrollPane2.setViewportView(TableNormalization);

        RankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NPM", "Hasil Akhir"
            }
        ));
        RankTable.setRowHeight(25);
        RankTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jScrollPane3.setViewportView(RankTable);

        bnormalization1.setText("Normalization");
        bnormalization1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        bnormalization1.setkBackGroundColor(new java.awt.Color(32, 136, 203));
        bnormalization1.setkEndColor(new java.awt.Color(32, 136, 203));
        bnormalization1.setkHoverEndColor(new java.awt.Color(2, 27, 52));
        bnormalization1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        bnormalization1.setkHoverStartColor(new java.awt.Color(32, 136, 203));
        bnormalization1.setkSelectedColor(new java.awt.Color(255, 255, 255));
        bnormalization1.setkStartColor(new java.awt.Color(2, 27, 52));
        bnormalization1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnormalization1ActionPerformed(evt);
            }
        });

        setRank.setText("SetRank");
        setRank.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        setRank.setkBackGroundColor(new java.awt.Color(32, 136, 203));
        setRank.setkEndColor(new java.awt.Color(32, 136, 203));
        setRank.setkHoverEndColor(new java.awt.Color(2, 27, 52));
        setRank.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        setRank.setkHoverStartColor(new java.awt.Color(32, 136, 203));
        setRank.setkSelectedColor(new java.awt.Color(255, 255, 255));
        setRank.setkStartColor(new java.awt.Color(2, 27, 52));
        setRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setRankActionPerformed(evt);
            }
        });

        bSummary.setText("Summary");
        bSummary.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        bSummary.setkBackGroundColor(new java.awt.Color(32, 136, 203));
        bSummary.setkEndColor(new java.awt.Color(32, 136, 203));
        bSummary.setkHoverEndColor(new java.awt.Color(2, 27, 52));
        bSummary.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        bSummary.setkHoverStartColor(new java.awt.Color(32, 136, 203));
        bSummary.setkSelectedColor(new java.awt.Color(255, 255, 255));
        bSummary.setkStartColor(new java.awt.Color(2, 27, 52));
        bSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSummaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(bnormalization1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(setRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(bnormalization1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(setRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bSummary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        new Normalisasi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        new Input_Data().setVisible(true); this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void InputKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputKriteriaMouseClicked
        new Data_Kriteria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InputKriteriaMouseClicked

    private void DataMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataMhsMouseClicked
        new Data_Mhs().setVisible(true); this.dispose();
    }//GEN-LAST:event_DataMhsMouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        new Data_User().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void LogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoMouseClicked
        new Normalisasi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoMouseClicked

    private void bnormalizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnormalizationActionPerformed
        NormalizationTab();
    }//GEN-LAST:event_bnormalizationActionPerformed

    private void TableKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKriteriaMouseClicked
    }//GEN-LAST:event_TableKriteriaMouseClicked

    private void setRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setRankActionPerformed
        setRank();
    }//GEN-LAST:event_setRankActionPerformed

    private void NormalisasiDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NormalisasiDataMouseClicked
        new Normalisasi().setVisible(true); this.dispose();
    }//GEN-LAST:event_NormalisasiDataMouseClicked

    private void bSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSummaryActionPerformed
        try{
            String SQL = "SELECT * FROM Rank where grade >= 360 order by Grade DESC LIMIT 2;";
            PreparedStatement state = conn.prepareStatement(SQL);
            ResultSet Result = state.executeQuery(SQL);
            while(Result.next()){
                JOptionPane.showMessageDialog(this, "Dengan NPM: "+Result.getString("NPM")+ ", Dan Nilai Akhir: " +Result.getString("Grade"), "Highest Grade Achieve by: ", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException yusuf){
                JOptionPane.showMessageDialog(this, "error "+yusuf);
        }
    }//GEN-LAST:event_bSummaryActionPerformed

    private void bnormalization1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnormalization1ActionPerformed
         NormalizationTab();
    }//GEN-LAST:event_bnormalization1ActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        new Admin.Login.Login_Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Normalisasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataMhs;
    private javax.swing.JLabel InputKriteria;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel NormalisasiData;
    private javax.swing.JTable RankTable;
    private javax.swing.JTable TableKriteria;
    private javax.swing.JTable TableNormalization;
    private keeptoo.KButton bSummary;
    private keeptoo.KButton bnormalization1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logout;
    private keeptoo.KButton setRank;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
