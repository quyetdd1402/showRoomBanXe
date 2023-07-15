/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.view;

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

/**
 *
 * @author pc
 */
public class ViewBanHang extends javax.swing.JFrame {

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
    ArrayList<SanPhamVM2> listSPSS = new ArrayList();

    /**
     * Creates new form ViewKhachHang
     */
    public ViewBanHang() {
        initComponents();
        setLocationRelativeTo(null);
        this.pack();
        loadComboBoxMNV();
        loadcbbSapXep();
        loadcbbSapXepHD();
        loadComboBoxKM();
        loadMaGiamGiaFromLblGiamGia();
        loadGiaGiamFromCbb();
        listSpVMD = spImpl.getListSP();
        listHDVM = HDservice.getListHoaDon();
        loadTableLuaChonSp1();
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

    private void loadTableLuaChonSp1() {
        listSpVMD = spImpl.getListSP();
        DefaultTableModel dtm = (DefaultTableModel) tbldanhsachsp1.getModel();
        dtm.setRowCount(0);
        for (SanPhamVM2 x : listSpVMD) {

            dtm.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                x.getMauSac(),
                x.getGiaBan(),
                x.getNamSx(),
                x.getXuatXu(),
                x.getTrangThai() == 1 ? "Ngung kinh doanh" : "Dang kinh doanh",
                x.getPhanKhuc(),
                x.getChoNgoi(),
                x.getDongCo(),
                x.getDongXe(),
                x.getHopSo(),
                x.getNhienLieu(),
                x.getKieuDang(),});
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiem1 = new javax.swing.JTextField();
        btnSearch1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbldanhsachsp1 = new javax.swing.JTable();
        cbbSapXep1 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        lbTenSP1 = new javax.swing.JLabel();
        lbMaSP1 = new javax.swing.JLabel();
        lbMauSP1 = new javax.swing.JLabel();
        lbPhanKhucSP1 = new javax.swing.JLabel();
        lbChoNgoiSP1 = new javax.swing.JLabel();
        lbDongCoSP1 = new javax.swing.JLabel();
        lbDongXeSP1 = new javax.swing.JLabel();
        lbHopSoSP1 = new javax.swing.JLabel();
        lbNhienLieuSP1 = new javax.swing.JLabel();
        lbKieuDangSP1 = new javax.swing.JLabel();
        lbXuatXuSP1 = new javax.swing.JLabel();
        lbNamSXSP1 = new javax.swing.JLabel();
        lbGiaSP1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        lbTenSP2 = new javax.swing.JLabel();
        lbMaSP2 = new javax.swing.JLabel();
        lbMauSP2 = new javax.swing.JLabel();
        lbPhanKhucSP2 = new javax.swing.JLabel();
        lbChoNgoiSP2 = new javax.swing.JLabel();
        lbDongCoSP2 = new javax.swing.JLabel();
        lbDongXeSP2 = new javax.swing.JLabel();
        lbHopSoSP2 = new javax.swing.JLabel();
        lbNhienLieuSP2 = new javax.swing.JLabel();
        lbKieuDangSP2 = new javax.swing.JLabel();
        lbXuatXuSP2 = new javax.swing.JLabel();
        lbNamSXSP2 = new javax.swing.JLabel();
        lbGiaSP2 = new javax.swing.JLabel();
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
        jLabel23 = new javax.swing.JLabel();
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
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoThanhToan = new javax.swing.JRadioButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 872));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách sản phẩm");

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
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbldanhsachsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
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
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 153));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton7.setText("Hiển thị");
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Sản phẩm đã chọn");

        jPanel7.setBackground(new java.awt.Color(0, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblLuachonsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        jButton5.setText("Xóa khỏi lựa chọn");
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý bán hàng", jPanel1);

        jPanel8.setBackground(new java.awt.Color(0, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Danh Sách Hóa Đơn");

        jPanel9.setBackground(new java.awt.Color(0, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
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
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSearchHD.setBackground(new java.awt.Color(255, 255, 153));
        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearchHD.setText("Tìm Kiếm");
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        btnHienThiHD.setBackground(new java.awt.Color(255, 255, 153));
        btnHienThiHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnHienThiHD.setText("Hiển Thị");
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
        jLabel6.setText("Trạng thái ");

        btnRemove.setBackground(new java.awt.Color(255, 255, 153));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnRemove.setText("Làm mới");
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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbSapXepHD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHienThiHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHD)
                    .addComponent(btnHienThiHD)
                    .addComponent(cbbSapXepHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trạng thái hóa đơn", jPanel8);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiem1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiem1CaretUpdate(evt);
            }
        });
        txtTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem1ActionPerformed(evt);
            }
        });
        txtTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem1KeyReleased(evt);
            }
        });

        btnSearch1.setBackground(new java.awt.Color(255, 255, 153));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearch1.setText("Tim kiem");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        tbldanhsachsp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma san pham", "Ten san pham", "Mau Sac", "Gia Ban", "Nam SX", "Xuat Xu", "Trang Thai"
            }
        ));
        tbldanhsachsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachsp1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbldanhsachsp1);

        cbbSapXep1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSapXep1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSapXep1ItemStateChanged(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 153));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton8.setText("Thêm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimKiem1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch1)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch1)
                    .addComponent(cbbSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setText("Tên sản phẩm :");

        jLabel8.setText("Mã sản phẩm :");

        jLabel13.setText("Màu sắc : ");

        jLabel14.setText("Giá bán :");

        jLabel15.setText("Năm sản xuất : ");

        jLabel18.setText("Xuất xứ : ");

        jLabel21.setText("Phân khúc :");

        jLabel24.setText("Chỗ ngồi :");

        jLabel28.setText("Động cơ :");

        jLabel34.setText("Dòng xe :");

        jLabel35.setText("Hộp số :");

        jLabel36.setText("Nhiên liệu :");

        jLabel37.setText("Kiểu dáng :");

        jButton9.setBackground(new java.awt.Color(255, 255, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton9.setText("Thêm sản phẩm này");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 153));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton11.setText("Xóa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        lbMaSP1.setText("Tên sản phẩm :");

        lbMauSP1.setText("Tên sản phẩm :");

        lbPhanKhucSP1.setText("Tên sản phẩm :");

        lbChoNgoiSP1.setText("Tên sản phẩm :");

        lbDongCoSP1.setText("Tên sản phẩm :");

        lbDongXeSP1.setText("Tên sản phẩm :");

        lbHopSoSP1.setText("Tên sản phẩm :");

        lbNhienLieuSP1.setText("Tên sản phẩm :");

        lbKieuDangSP1.setText("Tên sản phẩm :");

        lbXuatXuSP1.setText("Tên sản phẩm :");

        lbNamSXSP1.setText("Tên sản phẩm :");

        lbGiaSP1.setText("Tên sản phẩm :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGiaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbXuatXuSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhanKhucSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMauSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChoNgoiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDongCoSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDongXeSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHopSoSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNhienLieuSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKieuDangSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNamSXSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTenSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbMaSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbMauSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbPhanKhucSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lbChoNgoiSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lbDongCoSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbDongXeSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lbHopSoSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lbNhienLieuSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lbKieuDangSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbXuatXuSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbNamSXSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbGiaSP1))
                .addGap(16, 16, 16))
        );

        jLabel38.setText("Tên sản phẩm :");

        jLabel39.setText("Mã sản phẩm :");

        jLabel40.setText("Màu sắc : ");

        jLabel41.setText("Giá bán :");

        jLabel42.setText("Năm sản xuất : ");

        jLabel43.setText("Xuất xứ : ");

        jLabel44.setText("Phân khúc :");

        jLabel45.setText("Chỗ ngồi :");

        jLabel46.setText("Động cơ :");

        jLabel47.setText("Dòng xe :");

        jLabel48.setText("Hộp số :");

        jLabel49.setText("Nhiên liệu :");

        jLabel50.setText("Kiểu dáng :");

        jButton12.setBackground(new java.awt.Color(255, 255, 153));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton12.setText("Thêm sản phẩm này");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 153));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton13.setText("Xóa");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        lbTenSP2.setText("Tên sản phẩm :");

        lbMaSP2.setText("Tên sản phẩm :");

        lbMauSP2.setText("Tên sản phẩm :");

        lbPhanKhucSP2.setText("Tên sản phẩm :");

        lbChoNgoiSP2.setText("Tên sản phẩm :");

        lbDongCoSP2.setText("Tên sản phẩm :");

        lbDongXeSP2.setText("Tên sản phẩm :");

        lbHopSoSP2.setText("Tên sản phẩm :");

        lbNhienLieuSP2.setText("Tên sản phẩm :");

        lbKieuDangSP2.setText("Tên sản phẩm :");

        lbXuatXuSP2.setText("Tên sản phẩm :");

        lbNamSXSP2.setText("Tên sản phẩm :");

        lbGiaSP2.setText("Tên sản phẩm :");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel43)
                    .addComponent(jLabel41))
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGiaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbXuatXuSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhanKhucSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMauSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChoNgoiSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDongCoSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDongXeSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHopSoSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNhienLieuSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKieuDangSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNamSXSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbTenSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lbMaSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lbMauSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(lbPhanKhucSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lbChoNgoiSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(lbDongCoSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(lbDongXeSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lbHopSoSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(lbNhienLieuSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(lbKieuDangSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(lbXuatXuSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lbNamSXSP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lbGiaSP2))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("So sánh sản phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(722, 800));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên nhân viên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã hóa đơn");

        jPanel5.setBackground(new java.awt.Color(0, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tổng tiền xe:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giảm giá:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Thuế VAT:");

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("VAT 10%");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Khách trả:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tiền trả lại:");

        txaGhichu.setColumns(20);
        txaGhichu.setRows(5);
        jScrollPane1.setViewportView(txaGhichu);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Trạng thái:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Ghi chú:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Dịch vụ");

        buttonGroup3.add(cbBaoHiemXe);
        cbBaoHiemXe.setText("Bảo hiểm xe");
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

        buttonGroup3.add(cbDangKyBien);
        cbDangKyBien.setText("Đăng ký biển số");
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
        btnCapNhat.setText("Thanh toán");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        lblTienDichVu1.setText("jLabel32");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mã giảm giá:");

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

        buttonGroup3.add(cbFullDV);
        cbFullDV.setText("Full dịch vụ");
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

        buttonGroup2.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chưa thanh toán");

        buttonGroup2.add(rdoThanhToan);
        rdoThanhToan.setText("Đã thanh toán");
        rdoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(lbGiaGiam)
                            .addComponent(txtKhachTra, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(lbTienTraLai)
                            .addComponent(cbDangKyBien)
                            .addComponent(cbFullDV)
                            .addComponent(cbbMaGG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbBaoHiemXe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(69, 69, 69)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTienDichVu1)
                                    .addComponent(lbTongtienxe)))
                            .addComponent(jLabel22)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(56, 56, 56)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoThanhToan)
                                    .addComponent(rdoChoThanhToan))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnCapNhat)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTongtienxe))
                .addGap(1, 1, 1)
                .addComponent(lblTienDichVu1)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbGiaGiam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTienTraLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(rdoChoThanhToan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbBaoHiemXe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbDangKyBien)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFullDV)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        jLabel31.setText("Tên khách hàng");

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
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDonGia)))
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
                                    .addComponent(lbTensp))))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbXuatXu)
                        .addGap(149, 149, 149))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMasp)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lbTensp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lbMauSac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lbXuatXu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbDonGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap())
        );

        lbMaHD.setText("ahsjudgfghujdsf");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã nhân viên");

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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTenNV))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbManv))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Hóa đơn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
        }

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tbldanhsachspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachspMouseClicked

        int res = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn chọn sản phẩm?", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Tìm kiếm thành công");
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

    private void cbbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaNVActionPerformed


    }//GEN-LAST:event_cbbMaNVActionPerformed

    private void tblLuachonspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLuachonspMouseClicked
        // TODO add your handling code here:

        int index = tblLuachonsp.getSelectedRow();
        lbMasp.setText(String.valueOf(tblLuachonsp.getValueAt(index, 0)));
        lbTensp.setText(String.valueOf(tblLuachonsp.getValueAt(index, 1)));
        lbDonGia.setText(String.valueOf(tblLuachonsp.getValueAt(index, 4)));
        lbMauSac.setText(String.valueOf(tblLuachonsp.getValueAt(index, 2)));
        lbXuatXu.setText(String.valueOf(tblLuachonsp.getValueAt(index, 3)));

    }//GEN-LAST:event_tblLuachonspMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        
        int row = tblHoaDon.getSelectedRow();
        listHDVM = HDservice.getListHoaDon();
        txaGhichu.setText("");
        String baoHiem = "Bao Hiem";
        String lamBien = "Lam Bien";

        DecimalFormat formatTienTe = new DecimalFormat("####,###,###,###,###");

        int index = tblHoaDon.getSelectedRow();
        HoaDonViewModel hdvm = listHDVM.get(index);
        BigDecimal newKM = BigDecimal.valueOf(0);
                hdvm.setGhiChu(hdvm.getGhiChu());

        txaGhichu.setText(hdvm.getGhiChu());
        lbXuatXu.setText(hdvm.getXuatXu());
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
            BigDecimal ttx = BigDecimal.valueOf(1.1).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam());
            lbTongtienxe.setText(String.valueOf(formatTienTe.format(ttx)));

        } else if (txaGhichu.getText().equals("Bao Hiem")) {
            BigDecimal ttx = BigDecimal.valueOf(1.1).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam()).add(newKM);
            lbTongtienxe.setText(String.valueOf(formatTienTe.format(ttx)));
        } else if (txaGhichu.getText().equals("Lam Bien")) {
            BigDecimal ttx = BigDecimal.valueOf(1.1).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam()).add(newKM);
            lbTongtienxe.setText(String.valueOf(formatTienTe.format(ttx)));

        } else if (txaGhichu.getText().equals("Bao Hiem + Lam Bien")) {
            BigDecimal ttx = BigDecimal.valueOf(1.1).multiply(hdvm.getDonGia()).subtract(hdvm.getSoTienGiam()).add(newKM);
            lbTongtienxe.setText(String.valueOf(formatTienTe.format(ttx)));
        }

        lbGiaGiam.setText(String.valueOf(hdvm.getSoTienGiam()));

        if (hdvm.getKhachTra() - Double.parseDouble(lbTongtienxe.getText().trim().replace(",", "")) > 0) {
            lbTienTraLai.setText(formatTienTe.format(hdvm.getKhachTra() - Double.parseDouble(lbTongtienxe.getText().trim().replace(",", ""))));

        } else {

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

        
//        lbTongtienxe.setText(String.valueOf(soLuong.multiply(hdvm.getDonGia().subtract(hdvm.getSoTienGiam()))));
//        int row = tblHoaDon.getSelectedRow();
//        listHDVM = HDservice.getListHoaDon();
//        fillToTableHoaDon(row);
    }//GEN-LAST:event_tblHoaDonMouseClicked

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

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed

        try {
            BigDecimal newKM = BigDecimal.valueOf(0);
            if (lblTienDichVu1.getText().equals("+5.000.000 BH")) {
                newKM = BigDecimal.valueOf(5000000);
                System.out.println("Không sửa 5 củ");
            } else if (lblTienDichVu1.getText().equals("+5.000.000 DKB")) {
                newKM = BigDecimal.valueOf(5000000);
                System.out.println("Không sửa 5 củ 2");
            } else if (lblTienDichVu1.getText().equals("+10.000.000 BH + DKB")) {
                newKM = BigDecimal.valueOf(10000000);
                System.out.println("Không sửa 10 củ");
                System.out.println(newKM);
            }
            String maHD = lbMaHD.getText();
            String soLuong = txtSoLuong.getText();

            HoaDonViewModel hoadon = new HoaDonViewModel();

            hoadon.setGhiChu(txaGhichu.getText());
            hoadon.setNgayThanhToan(new Date());
            hoadon.setKhachTra(Double.parseDouble(txtKhachTra.getText().trim().replace(",", "")));
            hoadon.setSoTienGiam(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText())));
            hoadon.setTenNV(lbTenNV.getText());
            hoadon.setMaNV(loadMaNvFromLblTenNV());
            if (txaGhichu.getText().isEmpty()) {
                System.out.println("th1");
                if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                    hoadon.setGhiChu("Bao Hiem");
                } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                    hoadon.setThanhTien((BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", "")))).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                    hoadon.setGhiChu("Lam Bien");
                } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                    hoadon.setThanhTien((BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", "")))).add(newKM).subtract(BigDecimal.valueOf(Double.valueOf(lbGiaGiam.getText()))));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                }
            } else if (txaGhichu.getText().trim().equals("Bao Hiem")) {
                System.out.println("th2");
                if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                    JOptionPane.showMessageDialog(this, "Hóa đơn này đã có bảo hiểm");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))));
                    hoadon.setGhiChu("Bao Hiem");
                } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM.subtract(BigDecimal.valueOf(5000000))));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                }
            } else if (txaGhichu.getText().trim().equals("Lam Bien")) {
                System.out.println("th3");
                if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM));
                } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                    JOptionPane.showMessageDialog(this, "Hóa đơn này đã có đăng kí biển");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM));
                    hoadon.setGhiChu("Lam Bien");
                } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))).add(newKM.subtract(BigDecimal.valueOf(5000000))));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                }
            } else if (txaGhichu.getText().trim().equals("Bao Hiem + Lam Bien")) {
                System.out.println("th4");
                if (lblTienDichVu1.getText().trim().equals("+5.000.000 BH")) {
                    JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))));
                } else if (lblTienDichVu1.getText().trim().equals("+5.000.000 DKB")) {
                    JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                } else if (lblTienDichVu1.getText().trim().equals("+10.000.000 BH + DKB")) {
                    JOptionPane.showMessageDialog(this, "Hóa đơn này đã có full dịch vụ");
                    hoadon.setThanhTien(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().replace(",", ""))));
                    hoadon.setGhiChu("Bao Hiem + Lam Bien");
                }
            }

            if (BigDecimal.valueOf(Double.valueOf(txtKhachTra.getText().trim().replace(",", ""))).compareTo(BigDecimal.valueOf(Double.valueOf(lbTongtienxe.getText().trim().replace(",", "")))) == -1) {
                JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ !");
            } else {
                if (Double.valueOf(txtKhachTra.getText()) > 0) {
                    if (rdoChoThanhToan.isSelected()) {
                        JOptionPane.showMessageDialog(this, HDservice.update(new HoaDonViewModel(hoadon.getMaNV(), hoadon.getTenNV(), hoadon.getSoTienGiam(), hoadon.getThanhTien(), hoadon.getKhachTra(), new Date(), hoadon.setTrangThai(1), hoadon.getGhiChu()), maHD));

                    } else {
                        JOptionPane.showMessageDialog(this, HDservice.update(new HoaDonViewModel(hoadon.getMaNV(), hoadon.getTenNV(), hoadon.getSoTienGiam(), hoadon.getThanhTien(), hoadon.getKhachTra(), new Date(), hoadon.setTrangThai(0), hoadon.getGhiChu()), maHD));

                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số tiền khách trả phải là số tự nhiên");
        }

        listHDVM.removeAll(listHDVM);
        listHDVM = HDservice.getListHoaDon();
        loadTableHoaDon();
        buttonGroup3.clearSelection();

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void cbbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSapXepItemStateChanged
        // TODO add your handling code here:
        String index = (String) cbbSapXep.getSelectedItem();
        System.out.println(index);
        if (index == "Sắp xếp theo tên A-Z") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o1.getTen().compareToIgnoreCase(o2.getTen());
                }
            });
            loadTable();
        } else if (index == "Sắp xếp theo tên Z-A") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return o2.getTen().compareToIgnoreCase(o1.getTen());
                }
            });
            loadTable();
        } else if (index == "Sắp xếp theo năm sản xuất tăng") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return Integer.compare(o1.getNamSx(), o2.getNamSx());
                }
            });
            loadTable();
        } else if (index == "Sắp xếp theo năm sản xuất giảm") {
            Collections.sort(listSpVMD, new Comparator<SanPhamVM2>() {
                @Override
                public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                    return Integer.compare(o2.getNamSx(), o1.getNamSx());
                }
            });
            loadTable();
        }
    }//GEN-LAST:event_cbbSapXepItemStateChanged

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        listHDVM.clear();
        String ma = txtTimKiemHD.getText();
        listHDVM = HDservice.getOneHD(ma);
        JOptionPane.showMessageDialog(this, "Tìm kiếm thành công");
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

    private void cbDangKyBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDangKyBienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDangKyBienActionPerformed

    private void cbbSapXepHDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSapXepHDItemStateChanged
        String index = (String) cbbSapXepHD.getSelectedItem();
        if (index == "Sắp xếp theo tên NV A-->Z") {
            Collections.reverse(listHDVM);
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o1.getTenNV().compareToIgnoreCase(o2.getTenNV());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sắp xếp theo tên NV Z-->A") {
            Collections.reverse(listHDVM);
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return o2.getTenNV().compareToIgnoreCase(o1.getTenNV());
                }
            });
            loadTableHoaDon();
            System.out.println(listHDVM);

        } else if (index == "Sắp xếp theo trạng thái chưa thanh toán") {
            Collections.sort(listHDVM, new Comparator<HoaDonViewModel>() {
                @Override
                public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                    return Integer.compare(o2.getTrangThai(), o1.getTrangThai());
                }
            });
            loadTableHoaDon();
        } else if (index == "Sắp xếp theo trạng thái đã thanh toán") {
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

    private void cbbMaNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaNVItemStateChanged

        loadTenNvFromCbb();
//       
    }//GEN-LAST:event_cbbMaNVItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        listSpVMD = spImpl.getListSP();
        loadTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbBaoHiemXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBaoHiemXeMouseClicked


    }//GEN-LAST:event_cbBaoHiemXeMouseClicked

    private void cbDangKyBienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDangKyBienMouseClicked
        if (cbDangKyBien.isSelected()) {
            lblTienDichVu1.setText("+5.000.000 DKB");
        } else {
            lblTienDichVu1.setText("");
        }


    }//GEN-LAST:event_cbDangKyBienMouseClicked

    private void cbbMaGGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaGGItemStateChanged
        // TODO add your handling code here:
        loadGiaGiamFromCbb();
    }//GEN-LAST:event_cbbMaGGItemStateChanged

    private void cbbMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaGGActionPerformed

    private void cbBaoHiemXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBaoHiemXeActionPerformed
        if (cbBaoHiemXe.isSelected()) {
            lblTienDichVu1.setText("+5.000.000 BH");
        } else {
            lblTienDichVu1.setText("");
        }
    }//GEN-LAST:event_cbBaoHiemXeActionPerformed

    private void tblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonMouseEntered

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

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        listHDVM.clear();
        loadTableHoaDon();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void rdoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoThanhToanActionPerformed

    private void txtTimKiem1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiem1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem1CaretUpdate

    private void txtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem1ActionPerformed

    private void txtTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem1KeyReleased

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void tbldanhsachsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachsp1MouseClicked
        int index = tbldanhsachsp1.getSelectedRow();
        SanPhamVM2 x = new SanPhamVM2();
        SanPhamVM2 spvm = listSpVMD.get(index);
        x.setTen(spvm.getTen());
        x.setMa(spvm.getMa());
        x.setMauSac(spvm.getMauSac());
        x.setPhanKhuc(spvm.getPhanKhuc());
        x.setChoNgoi(spvm.getChoNgoi());
        x.setDongCo(spvm.getDongCo());
        x.setDongXe(spvm.getDongXe());
        x.setHopSo(spvm.getHopSo());
        x.setNhienLieu(spvm.getNhienLieu());
        x.setKieuDang(spvm.getKieuDang());
        x.setXuatXu(spvm.getXuatXu());
        x.setNamSx(spvm.getNamSx());
        x.setGiaBan(spvm.getGiaBan());
        x.setTrangThai(spvm.getTrangThai());
        if (listSPSS.size() < 2) {
            listSPSS.add(spvm);
        } else {
            JOptionPane.showMessageDialog(this, "Chỉ có thể so sánh 2 sản phẩm với nhau, hãy xóa 1 sản phẩm để thực hiện tiếp");
        }
        for (int i = 0; i < 2; i++) {
            if (lbTenSP1.getText().isEmpty()) {
                lbTenSP1.setText(listSPSS.get(0).getTen());
                lbMaSP1.setText(listSPSS.get(0).getMa());
                lbMauSP1.setText(listSPSS.get(0).getMauSac());
                lbPhanKhucSP1.setText(listSPSS.get(0).getPhanKhuc());
                lbChoNgoiSP1.setText(listSPSS.get(0).getChoNgoi());
                lbDongCoSP1.setText(listSPSS.get(0).getDongCo());
                lbDongXeSP1.setText(listSPSS.get(0).getDongXe());
                lbHopSoSP1.setText(listSPSS.get(0).getHopSo());
                lbNhienLieuSP1.setText(listSPSS.get(0).getNhienLieu());
                lbKieuDangSP1.setText(listSPSS.get(0).getKieuDang());
                lbNamSXSP1.setText(listSPSS.get(0).getKieuDang());
                lbXuatXuSP1.setText(listSPSS.get(0).getXuatXu());
                lbNamSXSP1.setText(String.valueOf(listSPSS.get(0).getNamSx()));
                lbGiaSP1.setText(String.valueOf(listSPSS.get(0).getGiaBan()));
            } else {
                lbTenSP2.setText(listSPSS.get(1).getTen());
                lbMaSP2.setText(listSPSS.get(1).getMa());
                lbMauSP2.setText(listSPSS.get(1).getMauSac());
                lbPhanKhucSP2.setText(listSPSS.get(1).getPhanKhuc());
                lbChoNgoiSP2.setText(listSPSS.get(1).getChoNgoi());
                lbDongCoSP2.setText(listSPSS.get(1).getDongCo());
                lbDongXeSP2.setText(listSPSS.get(1).getDongXe());
                lbHopSoSP2.setText(listSPSS.get(1).getHopSo());
                lbNhienLieuSP2.setText(listSPSS.get(1).getNhienLieu());
                lbKieuDangSP2.setText(listSPSS.get(1).getKieuDang());
                lbNamSXSP2.setText(listSPSS.get(1).getKieuDang());
                lbXuatXuSP2.setText(listSPSS.get(1).getXuatXu());
                lbNamSXSP2.setText(String.valueOf(listSPSS.get(1).getNamSx()));
                lbGiaSP2.setText(String.valueOf(listSPSS.get(1).getGiaBan()));
            }

        }

    }//GEN-LAST:event_tbldanhsachsp1MouseClicked

    private void cbbSapXep1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSapXep1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSapXep1ItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DecimalFormat formatTienTe = new DecimalFormat("####,###,###,###,###");

        int res = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn chọn sản phẩm", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            ChiTietHoaDonVM chiTietHoaDonVM = new ChiTietHoaDonVM();
            int rowCTHD = tbldanhsachsp1.getSelectedRow();
            int soLuong = 1;

            if (listSPSS.get(0).getTrangThai() == 0) {
                chiTietHoaDonVM.setMa(lbMaSP1.getText());
                chiTietHoaDonVM.setTen(lbTenSP1.getText());
                chiTietHoaDonVM.setMauSac(lbMauSP1.getText());
                chiTietHoaDonVM.setXuatXu(lbXuatXuSP1.getText());
                chiTietHoaDonVM.setGia(BigDecimal.valueOf(Double.valueOf((lbGiaSP1.getText()))));

                chiTietHoaDonVM.setSoluong(soLuong);
                listCTHD.add(chiTietHoaDonVM);
                loadTableGH();
            } else {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã ngừng kinh doanh");
            }

        } else if (res == JOptionPane.NO_OPTION) {

        } else if (res == JOptionPane.CLOSED_OPTION) {

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        listSPSS.remove(0);
        lbTenSP1.setText("");
        lbMaSP1.setText("");
        lbMauSP1.setText("");
        lbPhanKhucSP1.setText("");
        lbChoNgoiSP1.setText("");
        lbDongCoSP1.setText("");
        lbDongXeSP1.setText("");
        lbHopSoSP1.setText("");
        lbNhienLieuSP1.setText("");
        lbKieuDangSP1.setText("");
        lbNamSXSP1.setText("");
        lbXuatXuSP1.setText("");
        lbNamSXSP1.setText("");
        lbGiaSP1.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DecimalFormat formatTienTe = new DecimalFormat("####,###,###,###,###");

        int res = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn chọn sản phẩm", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            ChiTietHoaDonVM chiTietHoaDonVM = new ChiTietHoaDonVM();
            int rowCTHD = tbldanhsachsp1.getSelectedRow();
            int soLuong = 1;

            if (listSPSS.get(1).getTrangThai() == 0) {
                chiTietHoaDonVM.setMa(lbMaSP2.getText());
                chiTietHoaDonVM.setTen(lbTenSP2.getText());
                chiTietHoaDonVM.setMauSac(lbMauSP2.getText());
                chiTietHoaDonVM.setXuatXu(lbXuatXuSP2.getText());
                chiTietHoaDonVM.setGia(BigDecimal.valueOf(Double.valueOf((lbGiaSP2.getText()))));

                chiTietHoaDonVM.setSoluong(soLuong);
                listCTHD.add(chiTietHoaDonVM);
                loadTableGH();
            } else {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã ngừng kinh doanh");
            }

        } else if (res == JOptionPane.NO_OPTION) {

        } else if (res == JOptionPane.CLOSED_OPTION) {

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        listSPSS.remove(1);
        lbTenSP2.setText("");
        lbMaSP2.setText("");
        lbMauSP2.setText("");
        lbPhanKhucSP2.setText("");
        lbChoNgoiSP2.setText("");
        lbDongCoSP2.setText("");
        lbDongXeSP2.setText("");
        lbHopSoSP2.setText("");
        lbNhienLieuSP2.setText("");
        lbKieuDangSP2.setText("");
        lbNamSXSP2.setText("");
        lbXuatXuSP2.setText("");
        lbNamSXSP2.setText("");
        lbGiaSP2.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSapXepActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHienThiHD;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JCheckBox cbBaoHiemXe;
    private javax.swing.JCheckBox cbDangKyBien;
    private javax.swing.JCheckBox cbFullDV;
    private javax.swing.JComboBox<MaKhuyenMaiVM> cbbMaGG;
    private javax.swing.JComboBox<MaNhanVienVM> cbbMaNV;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbSapXep1;
    private javax.swing.JComboBox<String> cbbSapXepHD;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbChoNgoiSP1;
    private javax.swing.JLabel lbChoNgoiSP2;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbDongCoSP1;
    private javax.swing.JLabel lbDongCoSP2;
    private javax.swing.JLabel lbDongXeSP1;
    private javax.swing.JLabel lbDongXeSP2;
    private javax.swing.JLabel lbGiaGiam;
    private javax.swing.JLabel lbGiaSP1;
    private javax.swing.JLabel lbGiaSP2;
    private javax.swing.JLabel lbHopSoSP1;
    private javax.swing.JLabel lbHopSoSP2;
    private javax.swing.JLabel lbKieuDangSP1;
    private javax.swing.JLabel lbKieuDangSP2;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaSP1;
    private javax.swing.JLabel lbMaSP2;
    private javax.swing.JLabel lbManv;
    private javax.swing.JLabel lbMasp;
    private javax.swing.JLabel lbMauSP1;
    private javax.swing.JLabel lbMauSP2;
    private javax.swing.JLabel lbMauSac;
    private javax.swing.JLabel lbNamSXSP1;
    private javax.swing.JLabel lbNamSXSP2;
    private javax.swing.JLabel lbNhienLieuSP1;
    private javax.swing.JLabel lbNhienLieuSP2;
    private javax.swing.JLabel lbPhanKhucSP1;
    private javax.swing.JLabel lbPhanKhucSP2;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTenSP1;
    private javax.swing.JLabel lbTenSP2;
    private javax.swing.JLabel lbTensp;
    private javax.swing.JLabel lbTienTraLai;
    private javax.swing.JLabel lbTongtienxe;
    private javax.swing.JLabel lbXuatXu;
    private javax.swing.JLabel lbXuatXuSP1;
    private javax.swing.JLabel lbXuatXuSP2;
    private javax.swing.JLabel lblTienDichVu1;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoThanhToan;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblLuachonsp;
    private javax.swing.JTable tbldanhsachsp;
    private javax.swing.JTable tbldanhsachsp1;
    private javax.swing.JTextArea txaGhichu;
    private javax.swing.JTextField txtKhachTra;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiemHD;
    // End of variables declaration//GEN-END:variables

    private void loadcbbSapXep() {
        cbbSapXep.removeAllItems();
        cbbSapXep.addItem("Sắp xếp theo tên A-Z");
        cbbSapXep.addItem("Sắp xếp theo tên Z-A");
        cbbSapXep.addItem("Sắp xếp theo năm sản xuất tăng");
        cbbSapXep.addItem("Sắp xếp theo năm sản xuất giảm");
    }

    private void loadcbbSapXepHD() {
        cbbSapXepHD.removeAllItems();
        cbbSapXepHD.addItem("Sắp xếp theo tên NV A-->Z");
        cbbSapXepHD.addItem("Sắp xếp theo tên NV Z-->A");
        cbbSapXepHD.addItem("Sắp xếp theo trạng thái chưa thanh toán");
        cbbSapXepHD.addItem("Sắp xếp theo trạng thái đã thanh toán");
    }

}
