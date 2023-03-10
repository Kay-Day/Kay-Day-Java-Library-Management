//package GiaoDienNe;
//
//import javax.swing.*;
//
//public class TrangChuChinh extends JFrame {
//}



package GiaoDienNe;

import Connect.Sach_Connect_implement;
import Connect.connectionSQL;
import Connect.Sach_Connect_Th;
import Model.Sach_Th;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class TrangChuChinh extends javax.swing.JFrame {
    private JButton jButton1;
    private JButton jButton11;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel3;
    private JLabel jLabel35;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JScrollPane jScrollPane5;
    private JSeparator jSeparator1;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTabbedPane jTabbedPane1;
    private JTable tableSearchSach;
    private TextArea textArea1;
    private JTextField textboxsearch;

    Sach_Connect_Th getSach = new Sach_Connect_implement();

    public TrangChuChinh() {
        initComponents();
//        if (connectionSQL.getConnection() == null) {
//            JOptionPane.showMessageDialog(null, "B???n ch??a ch???y file sql ????? t???o Database,"
//                    + " ch??? ch???y file sql n??y cho l???n ?????u ti??n!", "ERROR", JOptionPane.ERROR_MESSAGE);
//            System.exit(0);
//        }
        // B???ng l???n t??m ki???m
        DefaultTableCellRenderer renderers_SearchSach = (DefaultTableCellRenderer) tableSearchSach.getTableHeader().getDefaultRenderer();
        renderers_SearchSach.setHorizontalAlignment(0);
        tableSearchSach.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
        tableSearchSach.setRowHeight(30);
//       Chi???u  r???ng b???ng t??m ki???m  nh???
        TableColumnModel columnModel_SearchSach = tableSearchSach.getColumnModel();
        columnModel_SearchSach.getColumn(0).setPreferredWidth(50);
        columnModel_SearchSach.getColumn(1).setPreferredWidth(300);
        columnModel_SearchSach.getColumn(2).setPreferredWidth(150);
        columnModel_SearchSach.getColumn(3).setPreferredWidth(200);
        columnModel_SearchSach.getColumn(4).setPreferredWidth(100);
//    Hi???n th??? danh s??ch
        List<Sach_Th> allSach = getSach.getAllSach();

        DefaultTableModel sachtb = (DefaultTableModel) tableSearchSach.getModel();
        sachtb.setRowCount(0);
        int i = 0;
        for (Sach_Th s : allSach) {
            i++;
            sachtb.addRow(new Object[] {i, s.getTenSach(), s.getTacgia(), s.getNhaSB(), s.getSoluong()});
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel2 = new JPanel();
        textArea1 = new java.awt.TextArea();
        jPanel3 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jSeparator4 = new JSeparator();
        jLabel11 = new JLabel();
        jPanel6 = new JPanel();
        textboxsearch = new JTextField();
        jLabel27 = new JLabel();
        jButton11 = new JButton();
        jComboBox3 = new JComboBox<>();
        jComboBox4 = new JComboBox<>();
        jLabel35 = new JLabel();
        jLabel28 = new JLabel();
        jScrollPane5 = new JScrollPane();
        tableSearchSach = new JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 255));
        jTabbedPane1.setTabPlacement(JTabbedPane.RIGHT);
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        textArea1.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        textArea1.setForeground(new java.awt.Color(0, 51, 153));
        textArea1.setText("                                     Ph???n m???m qu???n l?? th?? vi???n");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textArea1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textArea1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("TRANG CH??? CH??NH            ", new javax.swing.ImageIcon(getClass().getResource("/Images/research.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tutorial (1).png"))); // NOI18N
        jLabel3.setText("B???n ??ang g???p kh?? kh??n khi ????ng nh???p?");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("B?????c 1: Ch???n n??t ????ng nh???p b??n g??c ph???i m??n h??nh");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setText("B?????c 2: Nh???p th??ng tin ????ng nh???p.");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setText("- N???u b???n l?? Sinh vi??n, gi???n vi??n mu???n t??m ki???m s??ch h??y ????ng nh???p v???i quy???n ?????c gi??? ????? b???t ?????u tra c???u ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setText("- N???u b???n l?? c??n b??? qu???n l?? th?? vi???n h??y ????ng nh???p v???i quy???n Ch??? th?? ????? ti???n h??nh qu???n l?? h??? th???ng!");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setText("B?????c 3: ???n n??t ????ng nh???p !");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/navigator.png"))); // NOI18N
        jLabel24.setText("H??? th???ng ph???n m???m Qu???n l?? th?? vi???n");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
//        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png"))); // NOI18N
//        jLabel25.setText("");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 0, 0));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/telephone.png"))); // NOI18N
        jLabel26.setText("Th??ng tin li??n h???: 123456 - ?????a ch???: Th??nh ph??? ???? N???ng");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setText("v?? m?????n s??ch nh??!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel3)
                                                .addGap(0, 228, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel25)
                                                                .addGap(79, 79, 79))
                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel9))
                                        .addComponent(jSeparator4))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel11)))
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jTabbedPane1.addTab("H?????NG D???N ????NG NH???P", new javax.swing.ImageIcon(getClass().getResource("/Images/tutorial.png")), jPanel3); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        textboxsearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textboxsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textboxsearchActionPerformed(evt);
            }
        });

//        T???o s??? ki???n t??m ki???m s??ch
        textboxsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textboxsearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textboxsearchKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searching.png"))); // NOI18N
        jLabel27.setText("T??m ki???m s??ch:");

        jButton11.setBackground(new java.awt.Color(255, 204, 204));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton11.setText("T??m ki???m");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // T??m ki???m l???y t???t c??? s??ch
                jButton11ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T??m theo danh m???c", "Chuy??n ng??nh ??i???n-??i???n t???", "Chuy??n ng??nh C?? kh??", "Chuy??n ng??nh C??ng ngh??? th??ng tin", "Chuy??n ng??nh X??y d???ng", "S??ch Ti???ng Anh", "K??? n??ng s???ng" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T??m theo th??? lo???i", "Gi??o tr??nh h???c", "S??ch tham kh???o", "V??n h??a l???ch s???", "Ch??nh tr???, Ph??p lu???t", "T???p ch??" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 102));
        jLabel35.setText("L???c theo th??? lo???i:");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("L???c theo danh m???c:");

        tableSearchSach.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tableSearchSach.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "STT", "T??n s??ch", "T??c gi???", "Nh?? s???n xu???t", "S??? l?????ng"
                }
        ));
        jScrollPane5.setViewportView(tableSearchSach);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel35)
                                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(textboxsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(textboxsearch)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel35))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox4)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("TRA C???U S??CH                   ", new javax.swing.ImageIcon(getClass().getResource("/Images/statistics.png")), jPanel6); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Mylove.jpg"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Svvku.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pmSv.jpg"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GocTv.jpg"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/navigator.png"))); // NOI18N
        jLabel17.setText("H??? th???ng ph???n m???m Qu???n l?? th?? vi???n");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/telephone.png"))); // NOI18N
        jLabel18.setText("Th??ng tin li??n h???: 0123455- ?????a ch???: Th??nh ph??? ???? N???ng");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
//        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png"))); // NOI18N
//        jLabel19.setText("");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 102));
        jLabel20.setText("C???ng tr?????ng VKU");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 102));
        jLabel21.setText("Sinh vi??n ?????c s??ch");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 102));
        jLabel22.setText("Ph??ng m??y sinh vi??n");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("M???t g??c c???a th?? vi???n");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(25, 25, 25))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jLabel20))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel22)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(215, 215, 215))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(231, 231, 231))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(143, 143, 143))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel14)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel14))
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel22)
                                                .addGap(17, 17, 17))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel23)
                                                .addGap(18, 18, 18)))
                                .addComponent(jSeparator3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("H??NH ???NH TH?? VI???N         ", new javax.swing.ImageIcon(getClass().getResource("/Images/books.png")), jPanel4); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel1.setText("QU???N L?? TH?? VI???N                     ");
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel2.setText(" TR?????NG ?????I H???C C??NG NGH??? TH??NG TIN V?? TRUY???N TH??NG VI???T - H??N");
        jLabel2.setForeground(new java.awt.Color(255, 69, 0));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png"))); // NOI18N
        jButton1.setText("????ng nh???p");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
//                 Logo tr?????ng

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vkuu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(248, 248, 248))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(302, 302, 302)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 8, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new DangNhap().setVisible(true);
        this.setVisible(false);
    }

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:

        // L???y th??? lo???i s??ch
        String TL = "TL00";
        int index = jComboBox4.getSelectedIndex();
        if (index == 0) return;
        TL+= Integer.toString(index);
        List<Sach_Th> sachBytheloai = getSach.getSachByTheloai(TL);
        DefaultTableModel sachtb = (DefaultTableModel) tableSearchSach.getModel();
        sachtb.setRowCount(0);
        int i = 0;
        for (Sach_Th s : sachBytheloai) {
            i++;
            sachtb.addRow(new Object[] {i, s.getTenSach(), s.getTacgia(), s.getNhaSB(), s.getSoluong()});
        }
    }
//                             L???y danh m???c s??ch
    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {
        String DM = "DM00";
        int index = jComboBox3.getSelectedIndex();
        if (index == 0) return;
        DM+= Integer.toString(index);
        List<Sach_Th> sachByCate = getSach.getSachByCategory(DM);
        DefaultTableModel sachtb = (DefaultTableModel) tableSearchSach.getModel();
        sachtb.setRowCount(0);
        int i = 0;
        for (Sach_Th s : sachByCate) {
            i++;
            sachtb.addRow(new Object[] {i, s.getTenSach(), s.getTacgia(), s.getNhaSB(), s.getSoluong()});
        }
    }
///                Box m??u thanh ch???n
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        String textSearch = textboxsearch.getText();
        List<Sach_Th> searchSach = getSach.getAllSach();
        List<Sach_Th> resultSearch = new ArrayList<>();
        DefaultTableModel sachtb = (DefaultTableModel) tableSearchSach.getModel();
        sachtb.setRowCount(0);
        // D??ng for c???i ti???n
        int i = 0;
        for (Sach_Th s : searchSach) {
            if (s.getTenSach().toLowerCase().contains(textSearch.toLowerCase())){
                resultSearch.add(s);
            }
        }
        for (Sach_Th s : resultSearch) {
            i++;
            sachtb.addRow(new Object[] {i, s.getTenSach(), s.getTacgia(), s.getNhaSB(), s.getSoluong()});
        }
    }

    private void textboxsearchKeyTyped(java.awt.event.KeyEvent evt) {

    }
///     T??m ki???m s??ch
    private void textboxsearchKeyReleased(java.awt.event.KeyEvent evt) {
        String textSearch = textboxsearch.getText();
        List<Sach_Th> searchSach = getSach.getAllSach();
        List<Sach_Th> resultSearch = new ArrayList<>();
        DefaultTableModel sachtb = (DefaultTableModel) tableSearchSach.getModel();
        sachtb.setRowCount(0);
        int i = 0;
        for (Sach_Th s : searchSach) {
            if (s.getTenSach().toLowerCase().contains(textSearch.toLowerCase()))
                resultSearch.add(s);
        }
        for (Sach_Th s : resultSearch) {
            i++;
            sachtb.addRow(new Object[] {i, s.getTenSach(), s.getTacgia(), s.getNhaSB(), s.getSoluong()});
        }
    }

    private void textboxsearchActionPerformed(java.awt.event.ActionEvent evt) {

    }


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
            java.util.logging.Logger.getLogger(TrangChuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify

    // End of variables declaration
}

