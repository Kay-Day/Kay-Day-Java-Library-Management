
package GiaoDienNe;

import Model.ChiTietPhieuMuon;
import Model.PhieuMuon;
import Model.Sach;
import Model.Sach;
import DichVu.PhieuMuon_Dv;
import DichVu.Sach_Dv;
import DichVu.CTPhieuMuon_Dv;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Connect.connectionSQL;


public class TrangChuDocGia extends javax.swing.JFrame {
    private JButton btnReset;
    private JButton btnXacNhan;
    private JButton btnXemCT;
    private JButton btnXoaMuon;
    private JComboBox<String> cbbDanhMuc;
    private JComboBox<String> cbbHenTra;
    private JComboBox<String> cbbTheLoai;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel36;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTabbedPane jTabbedPane1;
    private JLabel lblGioiHan;
    private JLabel lblGioiHan1;
    private JLabel lblTongMuon;
    private JTable tblDSMuon;
    private JTable tblDanhMucSach;
    private JTextField txtTimSach;



//Các biến của tra cứu sách
    DefaultTableModel DMSach_model;
    public String sachDaChon;
    Sach_Dv sachServices = new Sach_Dv();
    boolean isLoaded = false;

    //Các biến của danh sách mượn
    public Sach sachMuon;
    public String maTaiKhoan;
    int tongMuon = 0;
    int gioiHan;
    DefaultTableModel DSMuon_model;
    PhieuMuon_Dv PM_Services = new PhieuMuon_Dv();
    CTPhieuMuon_Dv ctpmServices = new CTPhieuMuon_Dv();


    public TrangChuDocGia(String matk, int soluongmuon) {
        initComponents();
//  Tra cứu sách
        maTaiKhoan = matk;
        gioiHan = 3 - soluongmuon;
        DMSach_model = new  DefaultTableModel();
        DMSach_model.addColumn("Mã sách");
        DMSach_model.addColumn("Tên sách");
        DMSach_model.addColumn("Tác giả");
        DMSach_model.addColumn("Nhà xuất bản");
        tblDanhMucSach.setModel(DMSach_model);
        setAllDM_Sach();
        setHeaderTbl(tblDanhMucSach);
        loadmaTheLoai();
        loadmaDanhMuc();
        isLoaded = true;

//  Danh sách mượn
        DSMuon_model = new DefaultTableModel();
        DSMuon_model.addColumn("Mã sách");
        DSMuon_model.addColumn("Tên sách");
        DSMuon_model.addColumn("Tác giả");
        DSMuon_model.addColumn("Nhà xuất bản");
        DSMuon_model.addColumn("Năm xuất bản");
        tblDSMuon.setModel(DSMuon_model);
        lblGioiHan.setText(String.valueOf(gioiHan)); //Set giới hạn mượn
        setTongMuon();
        setHeaderTbl(tblDSMuon);
    }

    public void setAllDM_Sach() {
        DMSach_model.setRowCount(0);
        List<Sach> listSach = sachServices.getDSSach();
        for(Sach sach : listSach) {
            DMSach_model.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getNXB()});
        }
    }

    public void setHeaderTbl(javax.swing.JTable tbl) {
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbl.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        tbl.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        tbl.setRowHeight(30);

        TableColumnModel columnModel = tbl.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(300);
    }

    private void timkiem(String query){
        TableRowSorter<DefaultTableModel> tbl = new TableRowSorter<DefaultTableModel>(DMSach_model);
        tblDanhMucSach.setRowSorter(tbl);
        tbl.setRowFilter(RowFilter.regexFilter(query));
    }

    public boolean ktDSMuon(String masach) {
        TableRowSorter<DefaultTableModel> tbl = new TableRowSorter<DefaultTableModel>(DSMuon_model);
        tbl.setRowFilter(RowFilter.regexFilter(masach));
        if(tbl.getViewRowCount() != 0)
            return true;
        return false;
    }

    public void addDSMuon(Sach sach) {
        if(ktDSMuon(sach.getMaSach())) {
            JOptionPane.showMessageDialog(this, "Sách đã tồn tại trong danh sách mượn", "", JOptionPane.PLAIN_MESSAGE);
        } else {
            DSMuon_model.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(),
                    sach.getTacGia(), sach.getNXB(), sach.getNamXuatBan()});
            setTongMuon();
        }
    }

    public void setTongMuon() {
        tongMuon = DSMuon_model.getRowCount();
        lblTongMuon.setText(String.valueOf(tongMuon));
        if(tongMuon > gioiHan)
            lblTongMuon.setForeground(Color.red);
        else
            lblTongMuon.setForeground(Color.black);
    }

    Connection con = connectionSQL.getConnection();
    public void loadmaTheLoai(){
        cbbTheLoai.removeAllItems();
        cbbTheLoai.addItem("Thể loại");
        String sql = "SELECT tenTheLoai FROM TheLoai";
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                cbbTheLoai.addItem(rs.getString("tenTheLoai"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadmaDanhMuc(){
        cbbDanhMuc.removeAllItems();
        cbbDanhMuc.addItem("Danh mục sách");
        String sql = "SELECT tenDMSach FROM DanhMucSach";
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                cbbDanhMuc.addItem(rs.getString("tenDMSach"));
            }
        }catch(Exception e){

        }
    }



    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        txtTimSach = new JTextField();
        cbbDanhMuc = new JComboBox<>();
        cbbTheLoai = new JComboBox<>();
        btnReset = new JButton();
        jLabel5 = new JLabel();
        jScrollPane2 = new JScrollPane();
        tblDanhMucSach = new JTable();
        jSeparator2 = new JSeparator();
        jPanel2 = new JPanel();
        btnXemCT = new JButton();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jSeparator1 = new JSeparator();
        btnXoaMuon = new JButton();
        jLabel4 = new JLabel();
        lblTongMuon = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblDSMuon = new JTable();
        lblGioiHan = new JLabel();
        lblGioiHan1 = new JLabel();
        jLabel1 = new JLabel();
        jLabel6 = new JLabel();
        cbbHenTra = new JComboBox<>();
        btnXacNhan = new JButton();
        jLabel36 = new JLabel();
        jButton1 = new JButton();
        jLabel8 = new JLabel();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ dành cho Độc giả");
        setBackground(new Color(255, 204, 204));

        jTabbedPane1.setBackground(new Color(204, 204, 255));
        jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);
        jTabbedPane1.setFont(new Font("Times New Roman", 1, 22)); // NOI18N

        jPanel3.setBackground(new Color(255, 255, 204));

        jPanel4.setBackground(new Color(255, 255, 204));
        jPanel4.setCursor(new Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setDoubleBuffered(false);

        txtTimSach.setFont(new Font("Times New Roman", 0, 18)); // NOI18N
        txtTimSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSachKeyReleased(evt);
            }
        });

        cbbDanhMuc.setFont(new Font("Times New Roman", 0, 18)); // NOI18N
        cbbDanhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDanhMucItemStateChanged(evt);
            }
        });

        cbbTheLoai.setFont(new Font("Times New Roman", 0, 18)); // NOI18N
        cbbTheLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cbbDanhMucItemStateChanged(evt);
            }
        });

        btnReset.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.setIcon(new ImageIcon(getClass().getResource("/Images/eraser.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel5.setFont(new Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tìm kiếm");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(cbbDanhMuc, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbbTheLoai, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtTimSach, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5,GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(txtTimSach, GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbDanhMuc, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbTheLoai, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
        );

        tblDanhMucSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDanhMucSach.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String [] {

                }
        ));
        jScrollPane2.setViewportView(tblDanhMucSach);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        btnXemCT.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnXemCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        btnXemCT.setText("Xem chi tiết sách");
        btnXemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(128, Short.MAX_VALUE)
                                .addComponent(btnXemCT)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnXemCT)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("TRA CỨU                   ", new ImageIcon(getClass().getResource("/Images/research.png")), jPanel3); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tutorial (1).png"))); // NOI18N
        jLabel2.setText("Thông tin sách");

        btnXoaMuon.setBackground(new java.awt.Color(255, 204, 204));
        btnXoaMuon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa.png"))); // NOI18N
        btnXoaMuon.setText("Xóa");
        btnXoaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMuonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Tổng đơn sách bạn mượn:");

        lblTongMuon.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTongMuon.setHorizontalAlignment(SwingConstants.RIGHT);

        tblDSMuon.setFont(new Font("Times New Roman", 0, 18)); // NOI18N
        tblDSMuon.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String [] {

                }
        ));
        jScrollPane1.setViewportView(tblDSMuon);

        lblGioiHan.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblGioiHan.setHorizontalAlignment(SwingConstants.LEFT);

        lblGioiHan1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGioiHan1.setHorizontalAlignment(SwingConstants.CENTER);
        lblGioiHan1.setText("/");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("(Đọc kỹ danh sách trước khi gửi phiếu mượn)");

        jLabel6.setFont(new Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/Images/schedule.png"))); // NOI18N
        jLabel6.setText("Chọn ngày hẹn trả:");

        cbbHenTra.setFont(new Font("Times New Roman", 0, 20)); // NOI18N
        cbbHenTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "14", "20", "30", "45", "90" }));
        cbbHenTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHenTraActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(255, 204, 204));
        btnXacNhan.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
        btnXacNhan.setIcon(new ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(282, 282, 282)
                                                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jLabel6)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(cbbHenTra, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblTongMuon, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(lblGioiHan1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblGioiHan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnXoaMuon, GroupLayout.PREFERRED_SIZE, 111,GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblTongMuon, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblGioiHan,GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGioiHan1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoaMuon, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbHenTra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("DANH SÁCH MƯỢN", new ImageIcon(getClass().getResource("/Images/contact-list.png")), jPanel1); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setText(" TRƯỜNG ĐẠI HỌC CÔNG NGHỆ THÔNG TIN VÀ TRUYỀN THÔNG VIỆT - HÀN");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/choice.png"))); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new Font("Times New Roman", 1, 26)); // NOI18N
        jLabel8.setForeground(new Color(0, 0, 102));
        jLabel8.setText("QUẢN LÝ THƯ VIỆN");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vkuu.png"))); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel36))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(297, 297, 297)
                                                .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 168,GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1, GroupLayout.Alignment.TRAILING))))
                                .addGap(24, 24, 24)
                                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 471,GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    //Chức năng mượn sách
    private void btnXoaMuonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tblDSMuon.getSelectedRow();
        if(row == -1)
            JOptionPane.showMessageDialog(TrangChuDocGia.this, "Chọn một cuốn sách để xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
        else
            DSMuon_model.removeRow(row);
        setTongMuon();
    }

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {
        if(tongMuon == 0) {
            JOptionPane.showMessageDialog(TrangChuDocGia.this, "Danh sách mượn trống!", "Thất bại", JOptionPane.ERROR_MESSAGE);
        } else
        if(tongMuon > gioiHan)
            if(gioiHan == 0)
                JOptionPane.showMessageDialog(TrangChuDocGia.this, "Bạn đã hết lượt mượn,"
                        + " trả sách đã mượn để được mượn tiếp!", "Thất bại", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(TrangChuDocGia.this, "Vượt quá số lượng sách được phép mượn! "
                        + "Hãy xóa bớt danh sách mượn", "Thất bại", JOptionPane.ERROR_MESSAGE);
        else {
//              Thêm mới một phiếu mượn
            PhieuMuon phieuMuon = new PhieuMuon();
            phieuMuon.setSoNgayMuon(Integer.parseInt(cbbHenTra.getSelectedItem().toString()));
            phieuMuon.setMaTaiKhoan(maTaiKhoan);
            phieuMuon.setMaCanBo(null);
            phieuMuon.setTrangThai("Chưa duyệt");
            phieuMuon.setNgayMuon(null);
            PM_Services.addPhieuMuon(phieuMuon);

//              Thêm các sách vào chi tiết phiếu mượn
            int rowCount = tblDSMuon.getRowCount();
            String maPM = PM_Services.getMaPMInserted();
            for(int i = 0; i<rowCount; i++) {
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon(maPM, String.valueOf(tblDSMuon.getValueAt(i, 0)));
                ctpmServices.insertChiTietPM(ctpm);
            }
            gioiHan -= rowCount;
//              setGioiHanMuon(gioiHan);
            lblGioiHan.setText(String.valueOf(gioiHan));

            JOptionPane.showMessageDialog(TrangChuDocGia.this, "Xác nhận thành công!"
                    + "\nMời bạn đến thư viện để nhận sách trong thời gian sớm nhất.");
            DSMuon_model.setRowCount(0);
            setTongMuon();
//              setGioiHanMuon();

        }
    }

    //Chức năng tra cứu sách
    private void btnXemCTActionPerformed(java.awt.event.ActionEvent evt) {
        int row =  tblDanhMucSach.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(TrangChuDocGia.this, "Chọn một cuốn sách để xem!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String maSachChon = String.valueOf(tblDanhMucSach.getValueAt(row, 0));
            Sach sachChon = new Sach();
            sachChon = sachServices.getSachByMS(maSachChon);
            TrangChuDocGia_ChiTietSach chiTietSach = new TrangChuDocGia_ChiTietSach(sachChon);
            chiTietSach.setVisible(true);
            chiTietSach.muonsach = this;
        }

    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        setAllDM_Sach();
        timkiem("");
        txtTimSach.setText("");
        cbbDanhMuc.setSelectedIndex(0);
        cbbTheLoai.setSelectedIndex(0);
    }

    private void cbbDanhMucItemStateChanged(java.awt.event.ItemEvent evt) {
        if(isLoaded) {
            String dmSelected = cbbDanhMuc.getSelectedItem().toString();
            String tlSelected = cbbTheLoai.getSelectedItem().toString();

            if(dmSelected.equalsIgnoreCase("Danh mục sách") == false
                    && tlSelected.equalsIgnoreCase("Thể loại") == false) {
                DMSach_model.setRowCount(0);
                List<Sach> listSach = sachServices.getAllSachByBoth(dmSelected, tlSelected);;
                for(Sach sach : listSach)
                    DMSach_model.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getNXB()});

            } else {
                if(dmSelected.equalsIgnoreCase("Danh mục sách") == false
                        && tlSelected.equalsIgnoreCase("Thể loại") == true) {

                    DMSach_model.setRowCount(0);
                    List<Sach> listSach = sachServices.getAllSachByOne(dmSelected, "danhmuc");
                    for(Sach sach : listSach)
                        DMSach_model.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getNXB()});

                } else {
                    if(dmSelected.equalsIgnoreCase("Danh mục sách") == true
                            && tlSelected.equalsIgnoreCase("Thể loại") == false) {

                        DMSach_model.setRowCount(0);
                        List<Sach> listSach = sachServices.getAllSachByOne(tlSelected, "theloai");;
                        for(Sach sach : listSach)
                            DMSach_model.addRow(new Object[] {sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getNXB()});

                    } else
                        setAllDM_Sach();
                }
            }
        }
    }


    private void txtTimSachKeyReleased(java.awt.event.KeyEvent evt) {
        String query = txtTimSach.getText();
        timkiem(query);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new DangNhap().setVisible(true);
        this.setVisible(false);
    }

    private void cbbHenTraActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



    }




}
