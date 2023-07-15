/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.model.HoaDon;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.management.StringValueExp;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.raven.service.impl.HoaDonImpl11;
import com.raven.service.impl.NhanVienImpl11;
import com.raven.service.impl.SanPhamImpl11;
import com.raven.viewmodel.ChiTietHoaDonVM;
import com.raven.viewmodel.HoaDonViewModel;
import com.raven.viewmodel.MaNhanVienVM;
import com.raven.viewmodel.SanPhamVM2;
import com.raven.service.HoaDonService11;
import com.raven.service.KhuyenMaiService;
import com.raven.service.NhanVienService11;
import com.raven.service.impl.KhuyenMaiImpl;
import com.raven.viewmodel.MaKhuyenMaiVM;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import javax.print.DocFlavor;

public class Form_BanHang extends javax.swing.JPanel {

    private ArrayList<SanPhamVM2> listSpVMD = new ArrayList<>();
    private HoaDonService11 HDservice = new HoaDonImpl11();
    private KhuyenMaiService KMservice = new KhuyenMaiImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    DefaultTableModel dtmSearch = new DefaultTableModel();
    DefaultTableModel dtmSearchHD = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private SanPhamImpl11 spImpl = new SanPhamImpl11();
    private NhanVienService11 nvsv = new NhanVienImpl11();
    ArrayList<ChiTietHoaDonVM> listCTHD = new ArrayList<>();
    ArrayList<MaNhanVienVM> listNV = new ArrayList<>();
    ArrayList<HoaDonViewModel> listHDVM = new ArrayList<>();
    ArrayList<MaKhuyenMaiVM> listKM = new ArrayList<>();

    public Form_BanHang() {
        initComponents();
        loadComboBoxMNV();
        loadcbbSapXep();
        loadcbbSapXepHD();
        loadComboBoxKM();
        loadMaGiamGiaFromLblGiamGia();
        loadGiaGiamFromCbb();
        listSpVMD = spImpl.getListSP();
        listHDVM = HDservice.getListHoaDon();
         
        loadTable();

    }

    private void loadcbbSapXep() {
        cbbSapXep.removeAllItems();
        cbbSapXep.addItem("Sap xep theo ten");
        cbbSapXep.addItem("Sap xep theo ten giam dan");
        cbbSapXep.addItem("Sap xep theo gia giam dan");
        cbbSapXep.addItem("Sap xep theo gia tang dan");
        cbbSapXep.addItem("Sap xep theo namsx tang dan");
        cbbSapXep.addItem("Sap xep theo namsx giam dan");
    }

    private void loadcbbSapXepHD() {
        cbbSapXepHD.removeAllItems();
        cbbSapXepHD.addItem("Sap xep theo ten NV A-->Z");
        cbbSapXepHD.addItem("Sap xep theo ten NV Z-->A");
        cbbSapXepHD.addItem("Sap xep theo gia giam dan");
        cbbSapXepHD.addItem("Sap xep theo gia tang dan");
        cbbSapXepHD.addItem("Sap xep theo trang thai chua thanh toan");
        cbbSapXepHD.addItem("Sap xep theo trang thai da thanh toan");
    }

    private void addTableHoaDon(ArrayList<HoaDon> listhoaDon) {
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dtmHoaDon.setRowCount(0);
        for (HoaDon hoaDon : listhoaDon) {
            dtmHoaDon.addRow(new Object[]{hoaDon.getIdNhanVien(), hoaDon.getIdHTTT(), hoaDon.getIdKhachHang(), hoaDon.getMa(), hoaDon.getTenXe(), hoaDon.getTenNV(), hoaDon.getTenKH(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getSoTienGiam(), hoaDon.getTrangThai()});
        }
    }

    private void loadTableGH() {
        DefaultTableModel dtmGH = (DefaultTableModel) tblLuachonsp.getModel();
        dtmGH.setRowCount(0);
        for (ChiTietHoaDonVM x : listCTHD) {
            dtmGH.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                x.getMauSac(),
                x.getXuatXu(),
                x.getGia(),});

        }

    }

    private void loadComboBoxMNV() {
        cbbMaNV.removeAllItems();
        listNV = (ArrayList<MaNhanVienVM>) nvsv.getNV();
        for (MaNhanVienVM maNV : listNV) {
            cbbMaNV.addItem(maNV);
        }

    }

    private void loadComboBoxKM() {
        cbbMaGG.removeAllItems();
        listKM = (ArrayList<MaKhuyenMaiVM>) KMservice.getKM();
        for (MaKhuyenMaiVM x : listKM) {
            cbbMaGG.addItem(x);
        }

    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbldanhsachsp.getModel();
        dtm.setRowCount(0);
        for (SanPhamVM2 x : listSpVMD) {
            SanPhamVM2 ct = x;
            dtm.addRow(new Object[]{
                ct.getMa(),
                ct.getTen(),
                ct.getMauSac(),
                ct.getGiaBan(),
                ct.getNamSx(),
                ct.getXuatXu(),
                ct.getTrangThai() == 1 ? "Ngung kinh doanh" : "Dang kinh doanh"
            });
        }

    }

    private void loadTableHoaDon() {
//        List<HoaDonViewModel> listHDVM = HDservice.getListHoaDon();
        dtmHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmHD.setRowCount(0);
        for (HoaDonViewModel x : listHDVM) {
            dtmHD.addRow(new Object[]{
                x.getMaNV(),
                x.getTenNV(),
                x.getTenKH(),
                x.getMaHD(),
                x.getMaXe(),
                x.getTenXe(),
                x.getMauSac(),
                x.getXuatXu(),
                x.getSoLuong(),
                x.getDonGia(),
                x.getTrangThai() == 1 ? "Chua thanh toán" : "Ðã thanh toán",
                x.getSoTienGiam(),
                x.getThanhTien(),
                x.getKhachTra(),
                x.getNgayTaoHoaDon(),
                x.getNgayThanhToan(),
                x.getSdt(),
                x.getDiaChi(),
                x.getGhiChu()

            });

        }

    }

    private void showDataTable(List<SanPhamVM2> list) {
        dtm = (DefaultTableModel) tbldanhsachsp.getModel();
        dtm.setRowCount(0);
        for (SanPhamVM2 sp : list) {
            dtm.addRow(sp.toRowData());
        }

    }

//    private void fillToTableHoaDon(int index) {
////        listSpVMD.removeAll(listSpVMD);
//        String baoHiem = "Bao Hiem";
//        String lamBien = "Lam Bien";
//        HoaDonViewModel hdvm = listHDVM.get(index);
//        lbMaHD.setText(hdvm.getMaHD());
//        lbTenNV.setText(hdvm.getTenNV());
//        cbbMaNV.setSelectedItem(hdvm.getMaNV());
//        txtTenKH.setText(hdvm.getTenKH());
//        lbMasp.setText(hdvm.getMaXe());
//        lbTensp.setText(hdvm.getTenXe());
//        lbDonGia.setText(String.valueOf(hdvm.getDonGia()));
//        txtSoLuong.setText(Integer.toString(hdvm.getSoLuong()));
//        lbTongtienxe.setText(String.valueOf(hdvm.getThanhTien()));
//        lbGiaGiam.setText(String.valueOf(hdvm.getSoTienGiam()));
//        txtKhachTra.setText(Double.toString(hdvm.getKhachTra()));
//        if (hdvm.getTrangThai() == 1) {
//            rdoChoThanhToan.setSelected(true);
//        } else {
//            rdoChoThanhToan.setSelected(false);
//            rdoThanhToan.setSelected(true);
//        }
//
////        if (cbBaoHiemXe.isSelected()) {
////            hdvm.setGhiChu(baoHiem);
////        } else if (cbDangKyBien.isSelected()) {
////            hdvm.setGhiChu(lamBien);
////        } else if (cbBaoHiemXe.isSelected() && cbDangKyBien.isSelected()) {
////            hdvm.setGhiChu(baoHiem + lamBien);
////        } else {
////            hdvm.setGhiChu("");
////        }
////        txaGhichu.setText(hdvm.getGhiChu());
//    }
    private String loadMaNvFromLblTenNV() {
        int indexMaNV = cbbMaNV.getSelectedIndex();
        String maNV = "";
        if (indexMaNV == 0) {
            maNV = "maNV1";
        } else if (indexMaNV == 1) {
            maNV = "maNV2";
        } else if (indexMaNV == 2) {
            maNV = "maNV3";
        } else if (indexMaNV == 3) {
            maNV = "maNV4";
        } else if (indexMaNV == 4) {
            maNV = "maNV5";
        } else if (indexMaNV == 5) {
            maNV = "maNV6";
        } else if (indexMaNV == 6) {
            maNV = "maNV7";
        } else if (indexMaNV == 7) {
            maNV = "maNV8";
        } else if (indexMaNV == 8) {
            maNV = "maNV9";
        } else if (indexMaNV == 9) {
            maNV = "maNV10";
        } else if (indexMaNV == 10) {
            maNV = "maNV11";
        } else if (indexMaNV == 11) {
            maNV = "maNV12";
        } else if (indexMaNV == 12) {
            maNV = "maNV13";
        } else if (indexMaNV == 13) {
            maNV = "maNV14";
        } else if (indexMaNV == 14) {
            maNV = "maNV15";
        } else if (indexMaNV == 15) {
            maNV = "maNV16";
        } else if (indexMaNV == 16) {
            maNV = "maNV17";
        } else if (indexMaNV == 17) {
            maNV = "maNV18";
        } else if (indexMaNV == 18) {
            maNV = "maNV19";
        } else if (indexMaNV == 19) {
            maNV = "maNV20";
        }
        return maNV;

    }

    private void loadTenNvFromCbb() {
        Integer maNV = (int) cbbMaNV.getSelectedIndex();
        if (maNV.equals(0)) {
            lbTenNV.setText("Chống Thiện Mỹ");
        } else if (maNV.equals(1)) {
            lbTenNV.setText("Phạm Khương Duy");
        } else if (maNV.equals(2)) {
            lbTenNV.setText("Phạm Quỳnh Diễm");
        } else if (maNV.equals(3)) {
            lbTenNV.setText("Bùi Thị Hạnh");
        } else if (maNV.equals(4)) {
            lbTenNV.setText("Minh Văn Hà");
        } else if (maNV.equals(5)) {
            lbTenNV.setText("Vũ Minh Hà");
        } else if (maNV.equals(6)) {
            lbTenNV.setText("Lê Nga Hằng");
        } else if (maNV.equals(7)) {
            lbTenNV.setText("Duy Phạm");
        } else if (maNV.equals(8)) {
            lbTenNV.setText("Nguyễn Văn Minh");
        } else if (maNV.equals(9)) {
            lbTenNV.setText("Trần Minh Hà");
        } else if (maNV.equals(10)) {
            lbTenNV.setText("Nguyễn Ngọc Lan");
        } else if (maNV.equals(11)) {
            lbTenNV.setText("Phạm Đặng Quỳnh Trang");
        } else if (maNV.equals(12)) {
            lbTenNV.setText("Nguyễn Khánh Ly");
        } else if (maNV.equals(13)) {
            lbTenNV.setText("Nguyễn Minh Anh");
        } else if (maNV.equals(14)) {
            lbTenNV.setText("Nguyễn Văn Minh");
        } else if (maNV.equals(15)) {
            lbTenNV.setText("Phạm Văn Đức");
        } else if (maNV.equals(16)) {
            lbTenNV.setText("Nguyễn Thị Nguyệt Hà");
        } else if (maNV.equals(17)) {
            lbTenNV.setText("Lưu Thị Huế");
        } else if (maNV.equals(18)) {
            lbTenNV.setText("Nguyễn Thị Thúy Hằng");
        } else if (maNV.equals(19)) {
            lbTenNV.setText("Trần Thúy Linh");
        }
    }

    private String loadMaGiamGiaFromLblGiamGia() {
        int indexTenGG = cbbMaGG.getSelectedIndex();
        String TenGG = "";
        if (indexTenGG == 0) {
            TenGG = "KM Thang4";
        } else if (indexTenGG == 1) {
            TenGG = "KM TET";
        } else if (indexTenGG == 2) {
            TenGG = "KM Thang11";
        } else if (indexTenGG == 3) {
            TenGG = "KM Thang10";
        } else if (indexTenGG == 4) {
            TenGG = "KM Thang12";
        } else if (indexTenGG == 5) {
            TenGG = "KM Thang9";
        } else if (indexTenGG == 6) {
            TenGG = "KM Bl fday";
        } else if (indexTenGG == 7) {
            TenGG = "KM Thang3";
        } else if (indexTenGG == 8) {
            TenGG = "KM Thang8";
        } else if (indexTenGG == 9) {
            TenGG = "KM Thang7";
        } else if (indexTenGG == 10) {
            TenGG = "KM Thang6";

        } else if (indexTenGG == 11) {
            TenGG = "KM Thang5";
        }
        return TenGG;
    }

    private String loadGiaGiamFromCbb() {
        Integer tenGG = (int) cbbMaGG.getSelectedIndex();
        if (tenGG == 0) {
            lbGiaGiam.setText("2500000");
        } else if (tenGG == (1)) {
            lbGiaGiam.setText("5000000");
        } else if (tenGG == (2)) {
            lbGiaGiam.setText("3000000");
        } else if (tenGG == (3)) {
            lbGiaGiam.setText("3500000");
        } else if (tenGG == (4)) {
            lbGiaGiam.setText("4000000");
        } else if (tenGG == (5)) {
            lbGiaGiam.setText("2500000");
        } else if (tenGG == (6)) {
            lbGiaGiam.setText("4500000");
        } else if (tenGG == (7)) {
            lbGiaGiam.setText("3000000");
        } else if (tenGG == (8)) {
            lbGiaGiam.setText("2500000");
        } else if (tenGG == (9)) {
            lbGiaGiam.setText("3000000");
        } else if (tenGG == (10)) {
            lbGiaGiam.setText("1500000");
        } else if (tenGG == (11)) {
            lbGiaGiam.setText("2000000");
        }
        return lbGiaGiam.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtKhachTra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaGhichu = new javax.swing.JTextArea();
        rdoThanhToan = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbBaoHiemXe = new javax.swing.JCheckBox();
        cbDangKyBien = new javax.swing.JCheckBox();
        lbTongtienxe = new javax.swing.JLabel();
        lbGiaGiam = new javax.swing.JLabel();
        lbTienTraLai = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        lblTienDichVu1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbMaGG = new javax.swing.JComboBox<MaKhuyenMaiVM>();
        cbFullDV = new javax.swing.JCheckBox();
        cbbMaNV = new javax.swing.JComboBox<MaNhanVienVM>();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lbMasp = new javax.swing.JLabel();
        lbTensp = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        lbMauSac = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbXuatXu = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbManv = new javax.swing.JLabel();
        lbTenNV = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldanhsachsp = new javax.swing.JTable();
        cbbSapXep = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLuachonsp = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtTimKiemHD = new javax.swing.JTextField();
        btnSearchHD = new javax.swing.JButton();
        btnHienThiHD = new javax.swing.JButton();
        cbbSapXepHD = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(722, 800));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ten nhan vien:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã hóa đơn");

        jPanel5.setBackground(new java.awt.Color(0, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tong tien xe:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giam gia:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Thue VAT:");

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("VAT 10%");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Khach tra:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tien tra lai:");

        txaGhichu.setColumns(20);
        txaGhichu.setRows(5);
        jScrollPane1.setViewportView(txaGhichu);

        buttonGroup1.add(rdoThanhToan);
        rdoThanhToan.setText("Thanh Toan");
        rdoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThanhToanActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Trang thai:");

        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chua Thanh toan");
        rdoChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoThanhToanActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Ghi chu:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Dich vu:");

        cbBaoHiemXe.setText("Bao hiem xe");
        cbBaoHiemXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBaoHiemXeMouseClicked(evt);
            }
        });
        cbBaoHiemXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBaoHiemXeActionPerformed(evt);
            }
        });

        cbDangKyBien.setText("Dang ky bien so");
        cbDangKyBien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDangKyBienMouseClicked(evt);
            }
        });
        cbDangKyBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDangKyBienActionPerformed(evt);
            }
        });

        lbTongtienxe.setText("jLabel32");

        lbGiaGiam.setText("jLabel33");

        lbTienTraLai.setText("jLabel35");

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 153));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        lblTienDichVu1.setText("jLabel32");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ma giam gia:");

        cbbMaGG.setModel(new javax.swing.DefaultComboBoxModel<MaKhuyenMaiVM>());
        cbbMaGG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaGGItemStateChanged(evt);
            }
        });
        cbbMaGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaGGActionPerformed(evt);
            }
        });

        cbFullDV.setText("Full dich vu");
        cbFullDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFullDVMouseClicked(evt);
            }
        });
        cbFullDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFullDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(43, 43, 43)
                                .addComponent(lbTongtienxe))
                            .addComponent(jLabel22)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(rdoChoThanhToan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoThanhToan)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTienDichVu1)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(lbGiaGiam)
                                .addComponent(txtKhachTra, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(lbTienTraLai)
                                .addComponent(cbbMaGG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbDangKyBien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbFullDV))
                            .addComponent(cbBaoHiemXe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTongtienxe))
                .addGap(7, 7, 7)
                .addComponent(lblTienDichVu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbGiaGiam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTienTraLai)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(rdoChoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBaoHiemXe)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDangKyBien)
                    .addComponent(cbFullDV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addGap(72, 72, 72))
        );

        cbbMaNV.setModel(new javax.swing.DefaultComboBoxModel<MaNhanVienVM>());
        cbbMaNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaNVItemStateChanged(evt);
            }
        });
        cbbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaNVActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(0, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Mã sản phẩm:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Tên sản phẩm:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Đơn giá:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Số lượng:");

        lbMasp.setText("jLabel6");

        lbTensp.setText("jLabel21");

        lbDonGia.setText("jLabel31");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Tên khach hang:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Màu sắc : ");

        lbMauSac.setText("jLabel21");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Xuất xứ : ");

        lbXuatXu.setText("jLabel21");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(195, 195, 195))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(31, 31, 31)
                                .addComponent(lbMasp))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMauSac)
                                    .addComponent(lbTensp)
                                    .addComponent(lbXuatXu)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDonGia))))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lbMasp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lbTensp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMauSac)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbXuatXu)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDonGia)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSoLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbMaHD.setText("maHD");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã nhan vien");

        lbTenNV.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(25, 25, 25)
                                        .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(319, 319, 319)
                                        .addComponent(lbManv)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbTenNV)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTenNV))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbManv))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Hoa don", jPanel3);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 872));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sach san pham");

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 153));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearch.setText("Tim kiem");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbldanhsachsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma san pham", "Ten san pham", "Mau Sac", "Gia Ban", "Nam SX", "Xuat Xu", "Trang Thai"
            }
        ));
        tbldanhsachsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachspMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldanhsachsp);

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSapXepItemStateChanged(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 153));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton7.setText("Hien thi");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("San pham da chon");

        jPanel7.setBackground(new java.awt.Color(0, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblLuachonsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma san pham", "Ten san pham", "Mau Sac", "Xuat Xu", "Gia ban"
            }
        ));
        tblLuachonsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLuachonspMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLuachonsp);

        btnTaoHoaDon.setBackground(new java.awt.Color(255, 255, 153));
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Notes.png"))); // NOI18N
        btnTaoHoaDon.setText("Tao hoa don");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        jButton3.setText("Lam moi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        jButton5.setText("Xoa khoi lua chon");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel2))
                        .addGap(0, 666, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quan ly ban hang", jPanel1);

        jPanel8.setBackground(new java.awt.Color(0, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Danh sách hóa đơn");

        jPanel9.setBackground(new java.awt.Color(0, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma NV", "Ten NV", "Ten KH", "Ma HD", "Ma SP", "Ten Xe", "Mau Sac", "Xuat Xu", "So luong", "Don Gia", "Trang Thai"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        txtTimKiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHDActionPerformed(evt);
            }
        });

        btnSearchHD.setBackground(new java.awt.Color(255, 255, 153));
        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearchHD.setText("Tim kiem");
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        btnHienThiHD.setBackground(new java.awt.Color(255, 255, 153));
        btnHienThiHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnHienThiHD.setText("Hien Thi");
        btnHienThiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiHDActionPerformed(evt);
            }
        });

        cbbSapXepHD.setBackground(new java.awt.Color(255, 255, 153));
        cbbSapXepHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapXepHD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSapXepHDItemStateChanged(evt);
            }
        });
        cbbSapXepHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepHDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Trang Thai");

        btnRemove.setBackground(new java.awt.Color(255, 255, 153));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnRemove.setText("Xoa");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(cbbSapXepHD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSearchHD)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiHD)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSapXepHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel27))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnHienThiHD)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trang thai hoa don", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoThanhToanActionPerformed

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void cbBaoHiemXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBaoHiemXeMouseClicked

    }//GEN-LAST:event_cbBaoHiemXeMouseClicked

    private void cbBaoHiemXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBaoHiemXeActionPerformed
        if (cbBaoHiemXe.isSelected()) {
            lblTienDichVu1.setText("+5.000.000 BH");
        } else {
            lblTienDichVu1.setText("");
        }
    }//GEN-LAST:event_cbBaoHiemXeActionPerformed

    private void cbDangKyBienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDangKyBienMouseClicked
        if (cbDangKyBien.isSelected()) {
            lblTienDichVu1.setText("+5.000.000 DKB");
        } else {
            lblTienDichVu1.setText("");
        }

    }//GEN-LAST:event_cbDangKyBienMouseClicked

    private void cbDangKyBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDangKyBienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDangKyBienActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed

        BigDecimal newKM = BigDecimal.valueOf(0);
        if (lblTienDichVu1.getText().equals("+5.000.000 BH")) {
            newKM = BigDecimal.valueOf(5000000);
        } else if (lblTienDichVu1.getText().equals("+5.000.000 DKB")) {
            newKM = BigDecimal.valueOf(5000000);
        } else if (lblTienDichVu1.getText().equals("+10.000.000 BH + DKB")) {
            newKM = BigDecimal.valueOf(10000000);
        }
        String maHD = lbMaHD.getText();
        String soLuong = txtSoLuong.getText();
        int trangThai;
        if (rdoChoThanhToan.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        HoaDonViewModel hoadon = new HoaDonViewModel();

        hoadon.setTrangThai(trangThai);
        hoadon.setGhiChu(txaGhichu.getText());
        hoadon.setNgayThanhToan(new Date());
        hoadon.setKhachTra(Double.parseDouble(txtKhachTra.getText().trim().replace(",", "")));
        hoadon.setSoTienGiam(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText())));
        hoadon.setTenNV(lbTenNV.getText());
        hoadon.setMaNV(loadMaNvFromLblTenNV());
        if (txaGhichu.getText().isEmpty()) {
            System.out.println("th1");
            if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                hoadon.setGhiChu("Bao Hiem");
            } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                hoadon.setGhiChu("Lam Bien");
            } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
            }
        } else if (txaGhichu.getText().trim().equals("Bao Hiem")) {
            System.out.println("th2");
            if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã có bảo hiểm");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())));
                hoadon.setGhiChu("Bao Hiem");
            } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM));
                hoadon.setGhiChu("Bao Hiem + Lam Bien 1");
            } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM.subtract(BigDecimal.valueOf(5000000))));
                hoadon.setGhiChu("Bao Hiem + Lam Bien 2");
            }
        } else if (txaGhichu.getText().trim().equals("Lam Bien")) {
            System.out.println("th3");
            if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM));
            } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã có đăng kí biển");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM));
                hoadon.setGhiChu("Lam Bien");
            } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())).add(newKM.subtract(BigDecimal.valueOf(5000000))));
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
            }
        } else if (txaGhichu.getText().trim().equals("Bao Hiem + Lam Bien")) {
            System.out.println("th4");
            if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())));
            } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())));
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
            } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText())));
                hoadon.setGhiChu("Bao Hiem + Lam Bien");
            }
        }
        System.out.println(hoadon.getThanhTien());
        System.out.println(hoadon.getGhiChu());
        System.out.println(hoadon.getTrangThai());
        JOptionPane.showMessageDialog(this, HDservice.update(new HoaDonViewModel(hoadon.getMaNV(), hoadon.getTenNV(), hoadon.getSoTienGiam(), hoadon.getThanhTien(), hoadon.getKhachTra(), new Date(), hoadon.getTrangThai(), hoadon.getGhiChu()), maHD));
        listHDVM.removeAll(listHDVM);
        listHDVM = HDservice.getListHoaDon();
        loadTableHoaDon();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void cbbMaGGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaGGItemStateChanged
        // TODO add your handling code here:
        loadGiaGiamFromCbb();
    }//GEN-LAST:event_cbbMaGGItemStateChanged

    private void cbbMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaGGActionPerformed

    private void cbFullDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFullDVMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFullDVMouseClicked

    private void cbFullDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFullDVActionPerformed
        // TODO add your handling code here:
        if (cbFullDV.isSelected()) {
            lblTienDichVu1.setText("+10.000.000 BH + DKB");
        } else {
            lblTienDichVu1.setText("");
        }
    }//GEN-LAST:event_cbFullDVActionPerformed

    private void cbbMaNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaNVItemStateChanged

        loadTenNvFromCbb();
        //
    }//GEN-LAST:event_cbbMaNVItemStateChanged

    private void cbbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaNVActionPerformed

    }//GEN-LAST:event_cbbMaNVActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //        listSpVMD.removeAll(listSpVMD);
        listSpVMD.clear();
        String ma = txtTimKiem.getText();
        listSpVMD = spImpl.getOneSP(ma);
        dtmSearch = (DefaultTableModel) tbldanhsachsp.getModel();
        try {
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tìm kiếm thất bại");
            } else if (listSpVMD.size() > 0) {
                JOptionPane.showMessageDialog(this, "Tim kiem thanh cong");
                dtmSearch.setRowCount(0);
                for (SanPhamVM2 ct : listSpVMD) {
                    dtmSearch.addRow(new Object[]{
                        ct.getMa(),
                        ct.getTen(),
                        ct.getMauSac(),
                        ct.getGiaBan(),
                        ct.getNamSx(),
                        ct.getXuatXu(),
                        ct.getTrangThai() == 1 ? "Ngung kinh doanh" : "Dang kinh doanh"
                    });

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            dtmSearch.setRowCount(0);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbldanhsachspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachspMouseClicked

        int res = JOptionPane.showConfirmDialog(this, "Ban chac chan muon chon san pham?", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            ChiTietHoaDonVM chiTietHoaDonVM = new ChiTietHoaDonVM();
            int rowCTHD = tbldanhsachsp.getSelectedRow();
            int soLuong = 1;

            if (tbldanhsachsp.getValueAt(rowCTHD, 6).equals("Dang kinh doanh")) {
                chiTietHoaDonVM.setMa(tbldanhsachsp.getValueAt(rowCTHD, 0).toString());
                chiTietHoaDonVM.setTen(tbldanhsachsp.getValueAt(rowCTHD, 1).toString());
                chiTietHoaDonVM.setMauSac(tbldanhsachsp.getValueAt(rowCTHD, 2).toString());
                chiTietHoaDonVM.setXuatXu(tbldanhsachsp.getValueAt(rowCTHD, 5).toString());
                chiTietHoaDonVM.setGia((BigDecimal) tbldanhsachsp.getValueAt(rowCTHD, 3));

                chiTietHoaDonVM.setSoluong(soLuong);
                listCTHD.add(chiTietHoaDonVM);
                loadTableGH();
            } else {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã ngừng kinh doanh");
            }

        } else if (res == JOptionPane.NO_OPTION) {

        } else if (res == JOptionPane.CLOSED_OPTION) {

        }
    }//GEN-LAST:event_tbldanhsachspMouseClicked

    private void cbbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSapXepItemStateChanged
        // TODO add your handling code here:
        String index = (String) cbbSapXep.getSelectedItem();
        System.out.println(index);
        if (index == "Sap xep theo ten") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o1.getTen().compareToIgnoreCase(o2.getTen());
                }
            });
            loadTable();
        } else if (index == "Sap xep theo ten giam dan") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o2.getTen().compareToIgnoreCase(o1.getTen());
                }
            });
            loadTable();
        } else if (index == "Sap xep theo gia giam dan") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o2.getGiaBan().compareTo(o1.getGiaBan());
                }
            });
            loadTable();
        } else if (index == "Sap xep theo gia tang dan") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o1.getGiaBan().compareTo(o2.getGiaBan());
                }
            });
            loadTable();
        } else if (index == "Sap xep theo namsx tang dan") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return Integer.compare(o1.getNamSx(), o2.getNamSx());
                }
            });
            loadTable();
        } else if (index == "Sap xep theo namsx giam dan") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return Integer.compare(o2.getNamSx(), o1.getNamSx());
                }
            });
            loadTable();
        }
    }//GEN-LAST:event_cbbSapXepItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        listSpVMD = spImpl.getListSP();
        loadTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tblLuachonspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLuachonspMouseClicked
        // TODO add your handling code here:

        int index = tblLuachonsp.getSelectedRow();
        lbMasp.setText(String.valueOf(tblLuachonsp.getValueAt(index, 0)));
        lbTensp.setText(String.valueOf(tblLuachonsp.getValueAt(index, 1)));
        lbDonGia.setText(String.valueOf(tblLuachonsp.getValueAt(index, 4)));
        lbMauSac.setText(String.valueOf(tblLuachonsp.getValueAt(index, 2)));
        lbXuatXu.setText(String.valueOf(tblLuachonsp.getValueAt(index, 3)));
    }//GEN-LAST:event_tblLuachonspMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        //        addTableHoaDon(listhoaDon);

        loadTableHoaDon();
        int check = 0;
        for (int i = 0; i < tblLuachonsp.getRowCount(); i++) {
            listHDVM = HDservice.getListHoaDon();
            HoaDonViewModel hoaDon = new HoaDonViewModel();
            String maHD = "HD";
            hoaDon.setTenNV(lbTenNV.getText());
            hoaDon.setMaNV(loadMaNvFromLblTenNV());
            hoaDon.setTenKH(txtTenKH.getText());
            hoaDon.setMaXe(tblLuachonsp.getValueAt(i, 0).toString());
            hoaDon.setTenXe(tblLuachonsp.getValueAt(i, 1).toString());
            hoaDon.setDonGia((BigDecimal) tblLuachonsp.getValueAt(i, 4));
            hoaDon.setSoLuong(1);
            hoaDon.setSoTienGiam(BigDecimal.valueOf(0));
            hoaDon.setTrangThai(1);
            hoaDon.setKhachTra(0);
            hoaDon.setNgayTaoHoaDon(new Date());
            hoaDon.setMaHD(maHD + (listHDVM.size() + 1));
            hoaDon.setMauSac(tblLuachonsp.getValueAt(i, 2).toString());
            hoaDon.setXuatXu(tblLuachonsp.getValueAt(i, 3).toString());
            if (hoaDon.getTenKH().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập tên khách hàng");
            } else {
                System.out.println(hoaDon.getTrangThai());
                HDservice.saveHoaDon(hoaDon);
                check = 1;
            }

            //            hoaDon.setSoTienGiam(BigDecimal.valueOf(0));
        }
        if (check == 1) {
            JOptionPane.showMessageDialog(this, "Tao hoa don thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        listCTHD.clear();
        DefaultTableModel dtmGH = (DefaultTableModel) tblLuachonsp.getModel();
        dtmGH.setRowCount(0);
        dtmGH.setColumnCount(5);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int index = tblLuachonsp.getSelectedRow();
        try {
            listCTHD.remove(index);
            loadTableGH();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm để xóa");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        listHDVM = HDservice.getListHoaDon();
        String baoHiem = "Bao Hiem";
        String lamBien = "Lam Bien";

        DecimalFormat formatTienTe = new DecimalFormat("##,###,###,###,###.##");

        int index = tblHoaDon.getSelectedRow();
        HoaDonViewModel hdvm = listHDVM.get(index);
        BigDecimal newKM = BigDecimal.valueOf(0);
        if (lblTienDichVu1.getText().equals("+5.000.000 BH")) {
            newKM = BigDecimal.valueOf(5000000);
        } else if (lblTienDichVu1.getText().equals("+5.000.000 DKB")) {
            newKM = BigDecimal.valueOf(5000000);
        } else if (lblTienDichVu1.getText().equals("+10.000.000 BH + DKB")) {
            newKM = BigDecimal.valueOf(10000000);
        }
        for (int i = 0; i < cbbMaNV.getItemCount(); i++) {
            MaNhanVienVM m = cbbMaNV.getItemAt(i);
            if (m.getMaNV().equalsIgnoreCase(hdvm.getMaNV())) {
                cbbMaNV.setSelectedIndex(i);
            }
        }
        lbMauSac.setText(hdvm.getMauSac());
        lbMaHD.setText(hdvm.getMaHD());
        txtTenKH.setText(hdvm.getTenKH());
        lbMasp.setText(hdvm.getMaXe());
        lbTensp.setText(hdvm.getTenXe());
        lbDonGia.setText(formatTienTe.format(hdvm.getDonGia()));
        txtSoLuong.setText(String.valueOf(hdvm.getSoLuong()));
        txtKhachTra.setText(formatTienTe.format(Double.valueOf(hdvm.getKhachTra())));
        if (txaGhichu.getText().isEmpty()) {
            lbTongtienxe.setText(String.valueOf(BigDecimal.valueOf(hdvm.getSoLuong()).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam())));

        } else {
            lbTongtienxe.setText(String.valueOf(BigDecimal.valueOf(hdvm.getSoLuong()).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam()).add(newKM)));
        }
        lbGiaGiam.setText(String.valueOf(hdvm.getSoTienGiam()));

        try {
            if (hdvm.getKhachTra() - Double.parseDouble(hdvm.getThanhTien().toString()) > 0) {
                lbTienTraLai.setText(formatTienTe.format(hdvm.getKhachTra() - Double.parseDouble(hdvm.getThanhTien().toString())));
            }
        } catch (Exception e) {
            lbTienTraLai.setText(String.valueOf(0));
        }

        if (hdvm.getTrangThai() == 1) {

            rdoChoThanhToan.setSelected(true);
        } else {
            rdoThanhToan.setSelected(true);
        }

        //        if (cbBaoHiemXe.isSelected()) {
        //            hdvm.setGhiChu(baoHiem);
        //        } else if (cbDangKyBien.isSelected()) {
        //            hdvm.setGhiChu(lamBien);
        //        } else if (cbBaoHiemXe.isSelected() && cbDangKyBien.isSelected()) {
        //            hdvm.setGhiChu(baoHiem + lamBien);
        //        } else {
        hdvm.setGhiChu(hdvm.getGhiChu());

        txaGhichu.setText(hdvm.getGhiChu());
        lbXuatXu.setText(hdvm.getXuatXu());

        //        lbTongtienxe.setText(String.valueOf(soLuong.multiply(hdvm.getDonGia().subtract(hdvm.getSoTienGiam()))));
        //        int row = tblHoaDon.getSelectedRow();
        //        listHDVM = HDservice.getListHoaDon();
        //        fillToTableHoaDon(row);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonMouseEntered

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        listHDVM.clear();
        String ma = txtTimKiemHD.getText();
        listHDVM = HDservice.getOneHD(ma);
        JOptionPane.showMessageDialog(this, "Tim kiem thanh cong");
        dtmSearchHD = (DefaultTableModel) tblHoaDon.getModel();
        dtmSearchHD.setRowCount(0);
        for (HoaDonViewModel x : listHDVM) {
            dtmSearchHD.addRow(new Object[]{
                x.getMaNV(),
                x.getTenNV(),
                x.getTenKH(),
                x.getMaHD(),
                x.getMaXe(),
                x.getTenXe(),
                x.getSoLuong(),
                x.getDonGia(),
                x.getTrangThai() == 1 ? "Chua thanh toan" : "Da thanh toan",
                x.getSoTienGiam(),
                x.getThanhTien(),
                x.getKhachTra(),
                x.getNgayTaoHoaDon(),
                x.getNgayThanhToan(),
                x.getSdt(),
                x.getDiaChi(),
                x.getGhiChu()
            });
            System.out.println(listHDVM);
        }
    }//GEN-LAST:event_btnSearchHDActionPerformed

    private void btnHienThiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiHDActionPerformed
        listHDVM = HDservice.getListHoaDon();
        loadTableHoaDon();
    }//GEN-LAST:event_btnHienThiHDActionPerformed

    private void cbbSapXepHDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSapXepHDItemStateChanged
        String index = (String) cbbSapXepHD.getSelectedItem();
        if (index == "Sap xep theo ten NV A-->Z") {
            Collections.reverse(listHDVM);
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o1.getTenNV().compareToIgnoreCase(o2.getTenNV());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sap xep theo ten NV Z-->A") {
            Collections.reverse(listHDVM);
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o2.getTenNV().compareToIgnoreCase(o1.getTenNV());
                }
            });
            loadTableHoaDon();
            System.out.println(listHDVM);

        } else if (index == "Sap xep theo gia giam dan") {
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o1.getThanhTien().compareTo(o2.getThanhTien());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sap xep theo gia tang dan") {
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o2.getThanhTien().compareTo(o1.getThanhTien());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sap xep theo trang thai chua thanh toan") {
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return Integer.compare(o2.getTrangThai(), o1.getTrangThai());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sap xep theo trang thai da thanh toan") {
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return Integer.compare(o1.getTrangThai(), o2.getTrangThai());
                }
            });
            loadTableHoaDon();
        }
    }//GEN-LAST:event_cbbSapXepHDItemStateChanged

    private void cbbSapXepHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSapXepHDActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        listHDVM.clear();
        loadTableHoaDon();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtTimKiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHienThiHD;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbBaoHiemXe;
    private javax.swing.JCheckBox cbDangKyBien;
    private javax.swing.JCheckBox cbFullDV;
    private javax.swing.JComboBox<MaKhuyenMaiVM> cbbMaGG;
    private javax.swing.JComboBox<MaNhanVienVM> cbbMaNV;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbSapXepHD;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbGiaGiam;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbManv;
    private javax.swing.JLabel lbMasp;
    private javax.swing.JLabel lbMauSac;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTensp;
    private javax.swing.JLabel lbTienTraLai;
    private javax.swing.JLabel lbTongtienxe;
    private javax.swing.JLabel lbXuatXu;
    private javax.swing.JLabel lblTienDichVu1;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoThanhToan;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblLuachonsp;
    private javax.swing.JTable tbldanhsachsp;
    private javax.swing.JTextArea txaGhichu;
    private javax.swing.JTextField txtKhachTra;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemHD;
    // End of variables declaration//GEN-END:variables
}
