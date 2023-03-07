package GiaoDienNe;

import DichVu.CTPhieuMuon_Dv;
import DichVu.PhieuMuon_Dv;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;

import Connect.connectionSQL;
import Model.ChiTietPhieuMuon;
import Model.PhieuMuon;
import com.toedter.calendar.JDateChooser;

public class TrangChuThuVien_QLPM extends JFrame {
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModel1_CTPM;
    PhieuMuon_Dv pms_Service;
    CTPhieuMuon_Dv ctpms_Service;

    public Connection conn = connectionSQL.getConnection();

    public TrangChuThuVien_QLPM() {
        initComponents();
        pms_Service = new PhieuMuon_Dv();
        ctpms_Service = new CTPhieuMuon_Dv();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        tblK_kq.setModel(defaultTableModel);
        loadData_TblDSPM();
        Disable();

        cbbK_maPM.removeAllItems();
        loadMaPM();


        defaultTableModel1_CTPM = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblK_CTPM.setModel(defaultTableModel1_CTPM);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPK_tieuDe = new javax.swing.JPanel();
        lbK_tieuDe = new javax.swing.JLabel();
        btnK_veTrangTruoc = new javax.swing.JButton();
        jPK_qlPM = new javax.swing.JPanel();
        jPK_themPM = new javax.swing.JPanel();
        lbK_maPM1 = new javax.swing.JLabel();
        txtK_maPM_1 = new javax.swing.JTextField();
        lbL_maTK = new javax.swing.JLabel();
        txtK_maTK = new javax.swing.JTextField();
        lbK_maCB = new javax.swing.JLabel();
        lbK_soNgayMuon = new javax.swing.JLabel();
        cbbK_soNgayMuon = new javax.swing.JComboBox<>();
        btnK_chonMaTK = new javax.swing.JButton();
        lbK_ngayMuon = new javax.swing.JLabel();
        txtK_ngayMuon = new com.toedter.calendar.JDateChooser();
        lbK_ghiChu = new javax.swing.JLabel();
        txtK_ghiChu = new javax.swing.JTextField();
        lbK_trangThai = new javax.swing.JLabel();
        cbbK_trangThai = new javax.swing.JComboBox<>();
        cbbK_maCB = new javax.swing.JComboBox<>();
        jPK_themMaSach = new javax.swing.JPanel();
        txtK_maPM_2 = new javax.swing.JTextField();
        lbK_maPM2 = new javax.swing.JLabel();
        txtK_maSach = new javax.swing.JTextField();
        lbK_maSach = new javax.swing.JLabel();
        btnK_chonMaSach = new javax.swing.JButton();
        lbK_maPM3 = new javax.swing.JLabel();
        cbbK_maPM = new javax.swing.JComboBox<>();
        jPK_button = new javax.swing.JPanel();
        jPK_btnQLPM = new javax.swing.JPanel();
        btnK_themPM = new javax.swing.JButton();
        btnK_suaPM = new javax.swing.JButton();
        btnK_lamMoiPM = new javax.swing.JButton();
        btnK_luuPM = new javax.swing.JButton();
        jPK_btnQLS = new javax.swing.JPanel();
        btnK_themMaSach = new javax.swing.JButton();
        btnK_lamMoiSach = new javax.swing.JButton();
        btnK_xoaMaSach = new javax.swing.JButton();
        btnK_luuMaSach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblK_kq = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblK_CTPM = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPK_tieuDe.setBackground(new java.awt.Color(255, 204, 204));

        lbK_tieuDe.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbK_tieuDe.setForeground(java.awt.Color.darkGray);
        lbK_tieuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill.png"))); // NOI18N
        lbK_tieuDe.setText("QUẢN LÝ PHIẾU MƯỢN");

        btnK_veTrangTruoc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnK_veTrangTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_previous.png"))); // NOI18N
        btnK_veTrangTruoc.setText("Về trang trước");
        btnK_veTrangTruoc.setToolTipText("");
        btnK_veTrangTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_veTrangTruocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPK_tieuDeLayout = new javax.swing.GroupLayout(jPK_tieuDe);
        jPK_tieuDe.setLayout(jPK_tieuDeLayout);
        jPK_tieuDeLayout.setHorizontalGroup(
                jPK_tieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_tieuDeLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnK_veTrangTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250)
                                .addComponent(lbK_tieuDe)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPK_tieuDeLayout.setVerticalGroup(
                jPK_tieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_tieuDeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPK_tieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbK_tieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                        .addComponent(btnK_veTrangTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPK_qlPM.setBackground(new java.awt.Color(255, 255, 204));

        jPK_themPM.setBackground(new java.awt.Color(204, 204, 255));
        jPK_themPM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbK_maPM1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_maPM1.setText("Mã phiếu mượn:");

        txtK_maPM_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbL_maTK.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbL_maTK.setText("Mã tài khoản:");

        txtK_maTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbK_maCB.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_maCB.setText("Mã cán bộ:");

        lbK_soNgayMuon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_soNgayMuon.setText("Số ngày mượn:");

        cbbK_soNgayMuon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbK_soNgayMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "14", "21" }));

        btnK_chonMaTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnK_chonMaTK.setText("Hỗ trợ tìm kiếm");
        btnK_chonMaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_chonMaTKActionPerformed(evt);
            }
        });

        lbK_ngayMuon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_ngayMuon.setText("Ngày mượn:");

        txtK_ngayMuon.setDateFormatString("yyyy-MM-dd");

        lbK_ghiChu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_ghiChu.setText("Ghi chú:");

        txtK_ghiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbK_trangThai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_trangThai.setText("Trạng thái:");

        cbbK_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbK_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa trả", "Đã trả", "Chưa duyệt", " " }));

        cbbK_maCB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPK_themPMLayout = new javax.swing.GroupLayout(jPK_themPM);
        jPK_themPM.setLayout(jPK_themPMLayout);
        jPK_themPMLayout.setHorizontalGroup(
                jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_themPMLayout.createSequentialGroup()
                                .addContainerGap(35, Short.MAX_VALUE)
                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPK_themPMLayout.createSequentialGroup()
                                                        .addComponent(lbK_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(40, 40, 40)
                                                        .addComponent(txtK_ngayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPK_themPMLayout.createSequentialGroup()
                                                        .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lbK_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lbK_ghiChu))
                                                        .addGap(27, 27, 27)
                                                        .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(cbbK_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtK_ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPK_themPMLayout.createSequentialGroup()
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbK_maPM1)
                                                        .addComponent(lbK_soNgayMuon))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtK_maPM_1)
                                                        .addComponent(cbbK_soNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(5, 5, 5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_themPMLayout.createSequentialGroup()
                                                .addComponent(lbK_maCB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbbK_maCB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_themPMLayout.createSequentialGroup()
                                                .addComponent(lbL_maTK, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnK_chonMaTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                        .addComponent(txtK_maTK, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPK_themPMLayout.setVerticalGroup(
                jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_themPMLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtK_maPM_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbK_maPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtK_maTK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbL_maTK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                        .addComponent(lbK_soNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbK_soNgayMuon)
                                        .addComponent(btnK_chonMaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPK_themPMLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lbK_ngayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtK_ngayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                                .addGap(11, 11, 11)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbK_ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtK_ghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbK_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbbK_trangThai))
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(jPK_themPMLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPK_themPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbbK_maCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbK_maCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPK_themMaSach.setBackground(new java.awt.Color(204, 204, 255));
        jPK_themMaSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtK_maPM_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbK_maPM2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_maPM2.setText("Mã phiếu mượn:");

        txtK_maSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbK_maSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_maSach.setText("Mã sách:");

        btnK_chonMaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnK_chonMaSach.setText("Hỗ trợ tìm kiếm");
        btnK_chonMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_chonMaSachActionPerformed(evt);
            }
        });

        lbK_maPM3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbK_maPM3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open-book.png"))); // NOI18N
        lbK_maPM3.setText("Mã phiếu mượn:");

        cbbK_maPM.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbK_maPM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbK_maPMItemStateChanged(evt);
            }
        });
        cbbK_maPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbK_maPMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPK_themMaSachLayout = new javax.swing.GroupLayout(jPK_themMaSach);
        jPK_themMaSach.setLayout(jPK_themMaSachLayout);
        jPK_themMaSachLayout.setHorizontalGroup(
                jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_themMaSachLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbK_maPM3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbK_maPM2))
                                        .addComponent(lbK_maSach))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtK_maSach)
                                        .addComponent(cbbK_maPM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtK_maPM_2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnK_chonMaSach)
                                .addGap(51, 51, 51))
        );
        jPK_themMaSachLayout.setVerticalGroup(
                jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_themMaSachLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbK_maPM3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbK_maPM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbK_maPM2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtK_maPM_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPK_themMaSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbK_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtK_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnK_chonMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPK_button.setBackground(new java.awt.Color(255, 255, 204));

        jPK_btnQLPM.setBackground(new java.awt.Color(204, 204, 255));
        jPK_btnQLPM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPK_btnQLPM.setPreferredSize(new java.awt.Dimension(520, 84));

        btnK_themPM.setBackground(new java.awt.Color(255, 204, 204));
        btnK_themPM.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_themPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        btnK_themPM.setText("Thêm");
        btnK_themPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_themPMActionPerformed(evt);
            }
        });

        btnK_suaPM.setBackground(new java.awt.Color(255, 204, 204));
        btnK_suaPM.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_suaPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exchange1.png"))); // NOI18N
        btnK_suaPM.setText("Sửa");
        btnK_suaPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_suaPMActionPerformed(evt);
            }
        });

        btnK_lamMoiPM.setBackground(new java.awt.Color(255, 204, 204));
        btnK_lamMoiPM.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_lamMoiPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eraser.png"))); // NOI18N
        btnK_lamMoiPM.setText("Làm mới");
        btnK_lamMoiPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_lamMoiPMActionPerformed(evt);
            }
        });

        btnK_luuPM.setBackground(new java.awt.Color(255, 204, 204));
        btnK_luuPM.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_luuPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/luu.png"))); // NOI18N
        btnK_luuPM.setText("Lưu");
        btnK_luuPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_luuPMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPK_btnQLPMLayout = new javax.swing.GroupLayout(jPK_btnQLPM);
        jPK_btnQLPM.setLayout(jPK_btnQLPMLayout);
        jPK_btnQLPMLayout.setHorizontalGroup(
                jPK_btnQLPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_btnQLPMLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnK_themPM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnK_suaPM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnK_luuPM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnK_lamMoiPM)
                                .addContainerGap())
        );
        jPK_btnQLPMLayout.setVerticalGroup(
                jPK_btnQLPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_btnQLPMLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPK_btnQLPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnK_suaPM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_btnQLPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnK_luuPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnK_lamMoiPM))
                                        .addComponent(btnK_themPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPK_btnQLS.setBackground(new java.awt.Color(204, 204, 255));
        jPK_btnQLS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPK_btnQLS.setPreferredSize(new java.awt.Dimension(540, 84));

        btnK_themMaSach.setBackground(new java.awt.Color(255, 204, 204));
        btnK_themMaSach.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_themMaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/them.png"))); // NOI18N
        btnK_themMaSach.setText("Thêm");
        btnK_themMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_themMaSachActionPerformed(evt);
            }
        });

        btnK_lamMoiSach.setBackground(new java.awt.Color(255, 204, 204));
        btnK_lamMoiSach.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_lamMoiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eraser.png"))); // NOI18N
        btnK_lamMoiSach.setText("Làm mới");
        btnK_lamMoiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_lamMoiSachActionPerformed(evt);
            }
        });

        btnK_xoaMaSach.setBackground(new java.awt.Color(255, 204, 204));
        btnK_xoaMaSach.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_xoaMaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa.png"))); // NOI18N
        btnK_xoaMaSach.setText("Xóa");
        btnK_xoaMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_xoaMaSachActionPerformed(evt);
            }
        });

        btnK_luuMaSach.setBackground(new java.awt.Color(255, 204, 204));
        btnK_luuMaSach.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnK_luuMaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/luu.png"))); // NOI18N
        btnK_luuMaSach.setText("Lưu");
        btnK_luuMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK_luuMaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPK_btnQLSLayout = new javax.swing.GroupLayout(jPK_btnQLS);
        jPK_btnQLS.setLayout(jPK_btnQLSLayout);
        jPK_btnQLSLayout.setHorizontalGroup(
                jPK_btnQLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_btnQLSLayout.createSequentialGroup()
                                .addContainerGap(57, Short.MAX_VALUE)
                                .addComponent(btnK_themMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnK_xoaMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnK_luuMaSach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnK_lamMoiSach)
                                .addGap(41, 41, 41))
        );
        jPK_btnQLSLayout.setVerticalGroup(
                jPK_btnQLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_btnQLSLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPK_btnQLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnK_luuMaSach)
                                        .addComponent(btnK_lamMoiSach)
                                        .addComponent(btnK_xoaMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnK_themMaSach))
                                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPK_buttonLayout = new javax.swing.GroupLayout(jPK_button);
        jPK_button.setLayout(jPK_buttonLayout);
        jPK_buttonLayout.setHorizontalGroup(
                jPK_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_buttonLayout.createSequentialGroup()
                                .addComponent(jPK_btnQLPM, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPK_btnQLS, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        jPK_buttonLayout.setVerticalGroup(
                jPK_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPK_btnQLPM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPK_btnQLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPK_qlPMLayout = new javax.swing.GroupLayout(jPK_qlPM);
        jPK_qlPM.setLayout(jPK_qlPMLayout);
        jPK_qlPMLayout.setHorizontalGroup(
                jPK_qlPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPK_qlPMLayout.createSequentialGroup()
                                .addGroup(jPK_qlPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPK_qlPMLayout.createSequentialGroup()
                                                .addComponent(jPK_themPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPK_themMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPK_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        jPK_qlPMLayout.setVerticalGroup(
                jPK_qlPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPK_qlPMLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPK_qlPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPK_themPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPK_themMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPK_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tblK_kq.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tblK_kq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblK_kqMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblK_kq);

        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(540, 402));
        jScrollPane1.setRequestFocusEnabled(false);

        tblK_CTPM.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tblK_CTPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblK_CTPMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblK_CTPM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPK_tieuDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPK_qlPM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPK_tieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPK_qlPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void btnK_chonMaTKActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        TrangChuThuVien_Sreach timKiem = new TrangChuThuVien_Sreach();
        timKiem.setVisible(true);

    }

    private void btnK_chonMaSachActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        TrangChuThuVien_Sreach timKiem = new TrangChuThuVien_Sreach();
        timKiem.setVisible(true);
    }

    private void btnK_themPMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txtK_ghiChu.setEnabled(true);
        cbbK_maCB.setEnabled(true);
        txtK_maTK.setEnabled(true);
        cbbK_soNgayMuon.setEnabled(true);
        cbbK_trangThai.setEnabled(true);
        txtK_ngayMuon.setEnabled(true);
        btnK_chonMaTK.setEnabled(true);
        btnK_themPM.setEnabled(false);
        btnK_luuPM.setEnabled(true);

        load_MaCB();
    }

    private void btnK_luuPMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(txtK_maPM_1.getText().compareTo("")==0) {
            if(txtK_maTK.getText().equals("") || new java.sql.Date(txtK_ngayMuon.getDate().getTime()).toString().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mã TK và ngày mượn!");
            } else {
                if(checkSoLuongMuon(txtK_maTK.getText())==true) {
                    PhieuMuon pm = new PhieuMuon();
                    pm.setMaTaiKhoan(txtK_maTK.getText());
                    pm.setMaCanBo(cbbK_maCB.getSelectedItem().toString());
                    pm.setSoNgayMuon(Integer.parseInt(cbbK_soNgayMuon.getSelectedItem().toString()));
                    pm.setNgayMuon(new java.sql.Date(txtK_ngayMuon.getDate().getTime()).toString());
                    pm.setGhiChu(txtK_ghiChu.getText());
                    pm.setTrangThai(cbbK_trangThai.getSelectedItem().toString());

                    pms_Service.addPhieuMuon(pm);
                    loadData_TblDSPM();
                    refreshPM();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã mượn tối đa 3 cuốn sách!");
                }

            }
        } else if(txtK_maPM_1.getText().compareTo("")!=0) {
            PhieuMuon pm1 = new PhieuMuon();
            pm1.setMaPM(txtK_maPM_1.getText());
            pm1.setGhiChu(txtK_ghiChu.getText());
            pm1.setTrangThai(cbbK_trangThai.getSelectedItem().toString());
            pm1.setMaCanBo(cbbK_maCB.getSelectedItem().toString());
            pm1.setNgayMuon(new java.sql.Date(txtK_ngayMuon.getDate().getTime()).toString());

            pms_Service.updatePhieuMuon(pm1);
            loadData_TblDSPM();
            refreshPM();
        }


    }

    private void tblK_kqMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int selectedRow = tblK_kq.getSelectedRow();
        txtK_maPM_1.setText(tblK_kq.getValueAt(selectedRow, 0).toString());
        loadMaTKwithName(tblK_kq.getValueAt(selectedRow, 1).toString());
        try {
            loadMaCBwithName(tblK_kq.getValueAt(selectedRow, 2).toString());
            ((JTextField)txtK_ngayMuon.getDateEditor().getUiComponent()).setText(tblK_kq.getValueAt(selectedRow, 3).toString());
        } catch (Exception e) {

        }


        cbbK_soNgayMuon.setSelectedItem(tblK_kq.getValueAt(selectedRow, 4).toString());
        txtK_ghiChu.setText(tblK_kq.getValueAt(selectedRow, 5).toString());
        cbbK_trangThai.setSelectedItem(tblK_kq.getValueAt(selectedRow, 6).toString());

        btnK_luuPM.setEnabled(false);
        btnK_themPM.setEnabled(false);
        btnK_suaPM.setEnabled(true);
        txtK_ghiChu.setEnabled(false);
        cbbK_trangThai.setEnabled(false);
    }

    private void btnK_suaPMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txtK_ghiChu.setEnabled(true);
        cbbK_trangThai.setEnabled(true);
        cbbK_maCB.setEnabled(true);
        btnK_suaPM.setEnabled(false);
        btnK_luuPM.setEnabled(true);
        load_MaCB();
        if(cbbK_trangThai.getSelectedItem().toString().equals("Chưa duyệt")) {
            txtK_ngayMuon.setEnabled(true);
        }
    }

    private void btnK_lamMoiPMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        refreshPM();
        loadData_TblDSPM();
    }

    private void btnK_themMaSachActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
//        loadData_TblCTPM();
        txtK_maPM_2.setText(cbbK_maPM.getSelectedItem().toString());
        txtK_maSach.setEnabled(true);
        btnK_themMaSach.setEnabled(false);
        btnK_xoaMaSach.setEnabled(false);
        btnK_luuMaSach.setEnabled(true);
        btnK_lamMoiSach.setEnabled(true);
        btnK_chonMaSach.setEnabled(true);
    }

    private void cbbK_maPMItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        btnK_themMaSach.setEnabled(true);
        try {
            loadData_TblCTPM();
        } catch (Exception e) {

        }

    }

    private void btnK_luuMaSachActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(checkSoLuongMuonWithMaPM(txtK_maPM_2.getText())==true) {
            ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
            ctpm.setMaSach(txtK_maSach.getText());
            ctpm.setMaPM(txtK_maPM_2.getText());
            ctpms_Service.insertChiTietPM(ctpm);
            loadData_TblCTPM();
            txtK_maSach.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn đã mượn tối đa 3 cuốn sách");
        }
    }

    private void btnK_lamMoiSachActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        btnK_luuMaSach.setEnabled(false);
        btnK_themMaSach.setEnabled(true);
        txtK_maSach.setEnabled(false);
        defaultTableModel1_CTPM.setColumnCount(0);
        defaultTableModel1_CTPM.setRowCount(0);
    }

    private void btnK_veTrangTruocActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        TrangChuThuThu trangChuThuThu = new TrangChuThuThu();
        trangChuThuThu.setVisible(true);
        this.setVisible(false);
        trangChuThuThu.setDSPM();
    }

    private void cbbK_maPMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tblK_CTPMMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int selectedRow = tblK_CTPM.getSelectedRow();
        txtK_maPM_2.setText(tblK_CTPM.getValueAt(selectedRow, 0).toString());
        txtK_maSach.setText(tblK_CTPM.getValueAt(selectedRow, 1).toString());
        btnK_xoaMaSach.setEnabled(true);
        btnK_themMaSach.setEnabled(false);
        btnK_luuMaSach.setEnabled(false);
        txtK_maPM_2.setEnabled(false);
        txtK_maSach.setEnabled(false);
    }

    private void btnK_xoaMaSachActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int selectedRow = tblK_CTPM.getSelectedRow();

        ctpms_Service.deleteChiTietPM(tblK_CTPM.getValueAt(selectedRow, 0).toString(), tblK_CTPM.getValueAt(selectedRow, 1).toString());

        loadData_TblCTPM();
        btnK_lamMoiSach.setEnabled(true);
        btnK_xoaMaSach.setEnabled(false);
        txtK_maPM_2.setText("");
        txtK_maSach.setText("");
        btnK_themMaSach.setEnabled(true);

    }

    private void Disable() {
        txtK_maPM_1.setEnabled(false);
        txtK_ghiChu.setEnabled(false);
        cbbK_maCB.setEnabled(false);
        txtK_maTK.setEnabled(false);
        cbbK_soNgayMuon.setEnabled(false);
        cbbK_trangThai.setEnabled(false);
        txtK_ngayMuon.setEnabled(false);
        btnK_suaPM.setEnabled(false);
        btnK_chonMaTK.setEnabled(false);
        btnK_luuPM.setEnabled(false);

        txtK_maPM_2.setEnabled(false);
        txtK_maSach.setEnabled(false);
        btnK_chonMaSach.setEnabled(false);
        btnK_lamMoiSach.setEnabled(false);
        btnK_themMaSach.setEnabled(false);
        btnK_luuMaSach.setEnabled(false);
        btnK_xoaMaSach.setEnabled(false);


    }

    private void refreshPM() {
        Disable();
        btnK_themPM.setEnabled(true);
        txtK_maPM_1.setText("");
        txtK_ghiChu.setText("");
        txtK_maTK.setText("");
        ((JTextField)txtK_ngayMuon.getDateEditor().getUiComponent()).setText("");
        cbbK_maPM.removeAllItems();
        loadMaPM();

    }

    private void setTableData_DSPM(List<PhieuMuon> pms) {
        for(PhieuMuon pm : pms) {
            defaultTableModel.addRow(new Object[] {pm.getMaPM(), pm.getMaTaiKhoan(), pm.getMaCanBo(),
                    pm.getNgayMuon(), pm.getSoNgayMuon(), pm.getGhiChu(), pm.getTrangThai()});
        }
    }

    private void setTableData_CTPM(List<ChiTietPhieuMuon> ctpms) {
        for(ChiTietPhieuMuon ctpm : ctpms) {
            defaultTableModel1_CTPM.addRow(new Object[]{ctpm.getMaPM(), ctpm.getMaSach()});
        }
    }

    private void loadData_TblDSPM() {
        defaultTableModel.setColumnCount(0);
        defaultTableModel.setRowCount(0);
        defaultTableModel.addColumn("Mã phiếu mượn");
        defaultTableModel.addColumn("Tên bạn đọc");
        defaultTableModel.addColumn("Mã cán bộ");
        defaultTableModel.addColumn("Ngày mượn");
        defaultTableModel.addColumn("Số ngày mượn");
        defaultTableModel.addColumn("Ghi chú");
        defaultTableModel.addColumn("Trạng thái");

        setTableData_DSPM(pms_Service.getAllDSPhieuMuon());
    }

    private void loadData_TblCTPM() {
        defaultTableModel1_CTPM.setColumnCount(0);
        defaultTableModel1_CTPM.setRowCount(0);
        defaultTableModel1_CTPM.addColumn("Mã Phiếu mượn");
        defaultTableModel1_CTPM.addColumn("Mã sách");

        setTableData_CTPM(ctpms_Service.getDSCHiTietPM(cbbK_maPM.getSelectedItem().toString()));
    }

    private void load_MaCB() {
        cbbK_maCB.removeAllItems();
        String sql = "SELECT maCanBo FROM CanBo";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                this.cbbK_maCB.addItem(rs.getString("maCanBo"));
            }
        }catch(Exception e){

        }
    }

    private void loadMaTKwithName(String name) {
        String sql = "SELECT maTaiKhoan FROM TaiKhoan WHERE tenNguoiDung like N'%" + name + "%'";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                this.txtK_maTK.setText(rs.getString("maTaiKhoan"));
            }
        }catch(Exception e){

        }

    }
    private void loadMaCBwithName(String name) {
        String sql = "SELECT maCanBo FROM CanBo WHERE tenCanBo like N'%" + name + "%'";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                this.cbbK_maCB.removeAllItems();
                this.cbbK_maCB.addItem(rs.getString("maCanBo"));
            }
        }catch(Exception e){

        }

    }

    private boolean checkSoLuongMuon(String maTK) {
        String sql = "SELECT soLuongMuon FROM TaiKhoan WHERE maTaiKhoan like '%" + maTK + "%'";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int result = Integer.parseInt(rs.getString("soLuongMuon"));
                if(result == 3) {
                    return false;
                }
            }

        }catch(Exception e){

        }
        return true;
    }

    private boolean checkSoLuongMuonWithMaPM (String maPM) {
        String sql = "select soLuongMuon from PhieuMuon, TaiKhoan where PhieuMuon.maTaiKhoan = TaiKhoan.maTaiKhoan and maPhieuMuon like '%" + maPM + "%'";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int result = Integer.parseInt(rs.getString("soLuongMuon"));
                if(result == 3) {
                    return false;
                }
            }

        }catch(Exception e){

        }
        return true;
    }

    private void loadMaPM() {
        String sql = "SELECT maPhieuMuon FROM PhieuMuon ORDER BY maPhieuMuon DESC";
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                this.cbbK_maPM.addItem(rs.getString("maPhieuMuon"));
            }
        }catch(Exception e){

        }
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
            java.util.logging.Logger.getLogger(TrangChuThuVien_QLPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuThuVien_QLPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuThuVien_QLPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuThuVien_QLPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuThuVien_QLPM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnK_chonMaSach;
    private javax.swing.JButton btnK_chonMaTK;
    private javax.swing.JButton btnK_lamMoiPM;
    private javax.swing.JButton btnK_lamMoiSach;
    private javax.swing.JButton btnK_luuMaSach;
    private javax.swing.JButton btnK_luuPM;
    private javax.swing.JButton btnK_suaPM;
    private javax.swing.JButton btnK_themMaSach;
    private javax.swing.JButton btnK_themPM;
    private javax.swing.JButton btnK_veTrangTruoc;
    private javax.swing.JButton btnK_xoaMaSach;
    private javax.swing.JComboBox<String> cbbK_maCB;
    private javax.swing.JComboBox<String> cbbK_maPM;
    private javax.swing.JComboBox<String> cbbK_soNgayMuon;
    private javax.swing.JComboBox<String> cbbK_trangThai;
    private javax.swing.JPanel jPK_btnQLPM;
    private javax.swing.JPanel jPK_btnQLS;
    private javax.swing.JPanel jPK_button;
    private javax.swing.JPanel jPK_qlPM;
    private javax.swing.JPanel jPK_themMaSach;
    private javax.swing.JPanel jPK_themPM;
    private javax.swing.JPanel jPK_tieuDe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbK_ghiChu;
    private javax.swing.JLabel lbK_maCB;
    private javax.swing.JLabel lbK_maPM1;
    private javax.swing.JLabel lbK_maPM2;
    private javax.swing.JLabel lbK_maPM3;
    private javax.swing.JLabel lbK_maSach;
    private javax.swing.JLabel lbK_ngayMuon;
    private javax.swing.JLabel lbK_soNgayMuon;
    private javax.swing.JLabel lbK_tieuDe;
    private javax.swing.JLabel lbK_trangThai;
    private javax.swing.JLabel lbL_maTK;
    private javax.swing.JTable tblK_CTPM;
    private javax.swing.JTable tblK_kq;
    private javax.swing.JTextField txtK_ghiChu;
    private javax.swing.JTextField txtK_maPM_1;
    private javax.swing.JTextField txtK_maPM_2;
    private javax.swing.JTextField txtK_maSach;
    private javax.swing.JTextField txtK_maTK;
    private com.toedter.calendar.JDateChooser txtK_ngayMuon;
    // End of variables declaration





}
