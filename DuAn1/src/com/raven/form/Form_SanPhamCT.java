package com.raven.form;

import com.raven.model.SanPham;
import com.raven.service.CTSPService;
import com.raven.service.SanPhamService;
import com.raven.service.impl.ChiTietSPImpl;
import com.raven.service.impl.SanPhamImpl;
import com.raven.viewmodel.ChiTietSPVM;
import com.raven.viewmodel.SanPhamVM;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Form_SanPhamCT extends javax.swing.JPanel {

    private ChiTietSPImpl cTSPService = new ChiTietSPImpl();
    private SanPhamImpl spsv = new SanPhamImpl();
    private ArrayList<ChiTietSPVM> lst_SP;
 

    public Form_SanPhamCT() {
        initComponents();
        lst_SP = new ArrayList<>();
        lst_SP = cTSPService.getList();
        loadTable(lst_SP);
        loadCbbSP(spsv.getListSP());
        rdoHD.setSelected(true);
    }

    private void loadTable(ArrayList<ChiTietSPVM> lst) {
        DefaultTableModel dtm = (DefaultTableModel) tblCTSanPham.getModel();
        dtm.setRowCount(0);
        for (ChiTietSPVM x : lst) {
            ChiTietSPVM ct = (ChiTietSPVM) x;
            dtm.addRow(new Object[]{
                ct.getId(),
                ct.getSanPham(),
                ct.getHangSP(),
                ct.getKieudang(),
                ct.getMausac(),
                ct.getNhienlieu(),
                ct.getDongxe(),
                ct.getHopso(),
                ct.getDongco(),
                ct.getChongoi(),
                ct.getPhankhuc(),
                ct.getXuatxu(),
                ct.getNamSX(),
                ct.getSoLuongTon(),
                ct.getDongia(),
                ct.getMoTa(),
                ct.getTrangthai() == 1 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });

        }
    }

    private void loadCbbSP(ArrayList<SanPhamVM> lstL) {
        for (SanPhamVM q : lstL) {
            cbbTenSP.addItem(q);
        }
    }

    private ChiTietSPVM getFormData() {

        SanPhamVM s = (SanPhamVM) cbbTenSP.getSelectedItem();
        String hang = cbbHang.getSelectedItem().toString();
        String kieudang = cbbKieuDang.getSelectedItem().toString();
        String mausac = cbbMauSac.getSelectedItem().toString();
        String nhienlieu = cbbNhienLieu.getSelectedItem().toString();
        String dongxe = cbbDongxe.getSelectedItem().toString();
        String hopso = cbbHopso.getSelectedItem().toString();
        String dongco = cbbDongco.getSelectedItem().toString();
        String chongoi = cbbChoNgoi.getSelectedItem().toString();
        String phankhuc = cbbPhanKhuc.getSelectedItem().toString();
        String xuatxu = txtXuatXu.getText().trim();
        String namSXStr = txtNamSX.getText().trim();
        String slTonStr = txtSLton.getText().trim();
        String giaBanStr = txtDonGia.getText().trim();
        String moTa = txtMota.getText().trim();
        int trangThai = rdoHD.isSelected() == true ? 1 : 0;

        if (namSXStr.length() == 0 || slTonStr.length() == 0 || giaBanStr.length() == 0 || moTa.length() == 0) {
            JOptionPane.showMessageDialog(this, "Phải nhập đủ thông tin");
            return null;
        } else if (!checkSo(slTonStr)) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
            return null;
        } else if (!checkSo(namSXStr)) {
            JOptionPane.showMessageDialog(this, "Năm sản xuất phải là số nguyên");
            return null;
        } else if (Integer.parseInt(namSXStr) == 0) {
            JOptionPane.showMessageDialog(this, "Năm sản xuất phải lớn hơn 0");
            return null;
        }

        double giaBan = -1;
        try {
            giaBan = Double.parseDouble(giaBanStr);
            if (giaBan <= 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
            return null;
        }

        SanPham sp = new SanPham(s.getId(), s.getMa(), s.getTen(), s.getAnh());
        ChiTietSPVM ct = new ChiTietSPVM("", sp, hang, kieudang, mausac, nhienlieu, dongxe, hopso, dongco, chongoi, phankhuc, xuatxu, Integer.parseInt(namSXStr), Integer.parseInt(slTonStr), BigDecimal.valueOf(giaBan), moTa, trangThai);
        return ct;
    }

    private boolean checkSo(String txt) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    public void sortName() {
        Collections.sort(lst_SP, new Comparator<ChiTietSPVM>() {
            @Override
            public int compare(ChiTietSPVM s1, ChiTietSPVM s2) {
                return s1.getSanPham().getTen().compareTo(s2.getSanPham().getTen());
            }
        });
        loadTable(lst_SP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cbbSeachTT = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbbSapXep = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCTSanPham = new javax.swing.JTable();
        btnXuatFlie = new javax.swing.JButton();
        locTheoGia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbbHang1 = new javax.swing.JComboBox<>();
        cbbDongxe1 = new javax.swing.JComboBox<>();
        cbbPhanKhuc1 = new javax.swing.JComboBox<>();
        cbbHopso1 = new javax.swing.JComboBox<>();
        cbbDongco1 = new javax.swing.JComboBox<>();
        cbbChoNgoi1 = new javax.swing.JComboBox<>();
        cbbKieuDang1 = new javax.swing.JComboBox<>();
        cbbMauSac1 = new javax.swing.JComboBox<>();
        cbbNhienLieu1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtSeach_txt = new javax.swing.JTextField();
        btnSeach = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        cbbPhanKhuc = new javax.swing.JComboBox<>();
        cbbHang = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbbDongco = new javax.swing.JComboBox<>();
        cbbDongxe = new javax.swing.JComboBox<>();
        cbbHopso = new javax.swing.JComboBox<>();
        cbbKieuDang = new javax.swing.JComboBox<>();
        cbbChoNgoi = new javax.swing.JComboBox<>();
        rdoKHD = new javax.swing.JRadioButton();
        rdoHD = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        cbbMauSac = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbNhienLieu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        cbbTenSP = new javax.swing.JComboBox<SanPhamVM>();
        jLabel7 = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        txtSLton = new javax.swing.JTextField();
        txtNamSX = new javax.swing.JTextField();
        txtXuatXu = new javax.swing.JTextField();
        txtMota = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();

        setBackground(new java.awt.Color(242, 242, 242));

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 204));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(0, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel22.setText("Sắp xếp");

        cbbSeachTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang kinh doanh", "Ngừng kinh doanh" }));
        cbbSeachTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSeachTTMouseClicked(evt);
            }
        });
        cbbSeachTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSeachTTActionPerformed(evt);
            }
        });

        jLabel3.setText("Lọc theo trạng thái");

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên A-->Z", "Top 2 SP có SL tồn nhiều nhất", "Giá bán tăng dần", "Giá bán giảm dần ", " ", " " }));
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        tblCTSanPham.setBackground(new java.awt.Color(0, 255, 255));
        tblCTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên SP", "Hãng SP", "Kiểu dáng", "Màu sắc", "Nhiên liệu", "Dòng xe", "Hộp số", "Động cơ", "Chỗ ngồi", "Phân khúc", "Xuất xứ", "Năm SX", "SL tồn", "Giá bán", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCTSanPham);

        btnXuatFlie.setText("Xuất file excel");
        btnXuatFlie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFlieActionPerformed(evt);
            }
        });

        locTheoGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ 200-300 triệu", "Từ 300 - 500 triệu", "Từ 500 - 600 triệu", "Từ 600-800 triệu", "Từ 800-900 triệu", "Từ 900-1 tỷ", "Từ 1 tỷ - 1,5 tỷ", "Trên 1,5 tỷ " }));
        locTheoGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                locTheoGiaItemStateChanged(evt);
            }
        });
        locTheoGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locTheoGiaActionPerformed(evt);
            }
        });

        jLabel1.setText("Lọc theo khoảng giá");

        cbbHang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Honda", "Chevrolet", "Ford", "Hyundai", " ", " " }));
        cbbHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHang1ActionPerformed(evt);
            }
        });

        cbbDongxe1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "SUV", "Crossover", "MPV", "Limousine", " " }));
        cbbDongxe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDongxe1ActionPerformed(evt);
            }
        });

        cbbPhanKhuc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hạng A", "Hạng B", "Hạng C", "Hạng D", "Hạng E", "Hạng F", "Hạng M" }));
        cbbPhanKhuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhanKhuc1ActionPerformed(evt);
            }
        });

        cbbHopso1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hộp số sàn", "Hộp số tự động", "Hộp số tự động vô cấp CVT ", "Hộp số ly hợp kép DCT", "Hộp số bán tự động", "Hộp số sang số trực tiếp DSG " }));
        cbbHopso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHopso1ActionPerformed(evt);
            }
        });

        cbbDongco1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Động cơ xăng", "Động cơ điện", "Động cơ dầu", "Động cơ hydro", " " }));
        cbbDongco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDongco1ActionPerformed(evt);
            }
        });

        cbbChoNgoi1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 chỗ", "7 chỗ", "9 chỗ", "16 chỗ", "25 chỗ" }));
        cbbChoNgoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChoNgoi1ActionPerformed(evt);
            }
        });

        cbbKieuDang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe mui trần", "Xe thể thao", "Xe đa dụng", "Xe bán tải" }));
        cbbKieuDang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKieuDang1ActionPerformed(evt);
            }
        });

        cbbMauSac1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xanh", "Đỏ", "Tím ", "Vàng", "Đen", " " }));
        cbbMauSac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSac1ActionPerformed(evt);
            }
        });

        cbbNhienLieu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xăng ", "Dầu", "Hơi nước", "Điện" }));
        cbbNhienLieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhienLieu1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Hãng ô tô");

        jLabel26.setText("Dòng xe");

        jLabel27.setText("Phân khúc");

        jLabel28.setText("Hộp số");

        jLabel29.setText("Chỗ ngồi");

        jLabel30.setText("Kiểu dáng");

        jLabel31.setText("Màu sắc");

        jLabel32.setText("Động cơ");

        jLabel33.setText("Nhiên liệu");

        txtSeach_txt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeach_txtCaretUpdate(evt);
            }
        });
        txtSeach_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeach_txtActionPerformed(evt);
            }
        });

        btnSeach.setText("Tìm kiếm");
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        jButton2.setText("Hiển Thị");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Nhập file excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatFlie)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButton2))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(cbbSeachTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(locTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addComponent(cbbHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbDongxe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbPhanKhuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbChoNgoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbKieuDang1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDongco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHopso1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbNhienLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtSeach_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeach)))
                        .addContainerGap(55, Short.MAX_VALUE))))
            .addComponent(jScrollPane4)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeach)
                    .addComponent(txtSeach_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbDongxe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbPhanKhuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbChoNgoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbKieuDang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbDongco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHopso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbNhienLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSeachTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(8, 8, 8)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatFlie)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel1);

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Id");

        jLabel13.setText("Hãng ô tô:");

        jLabel14.setText("Tên ô tô :");

        jLabel15.setText("Kiểu dáng:");

        jLabel16.setText("Màu sắc:");

        lbId.setBackground(new java.awt.Color(255, 255, 153));
        lbId.setText("-");

        cbbPhanKhuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hạng A", "Hạng B", "Hạng C", "Hạng D", "Hạng E", "Hạng F", "Hạng M" }));

        cbbHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Honda", "Chevrolet", "Ford", "Hyundai", " ", " " }));

        jLabel17.setText("Nhiên liệu:");

        jLabel18.setText("Chỗ ngồi:");

        jLabel20.setText("Động cơ:");

        jLabel21.setText("Trạng thái:");

        jLabel23.setText("Hộp số:");

        jLabel24.setText("Dòng xe:");

        cbbDongco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Động cơ xăng", "Động cơ điện", "Động cơ dầu", "Động cơ hydro", " " }));

        cbbDongxe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "SUV", "Crossover", "MPV", "Limousine", " " }));

        cbbHopso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hộp số sàn", "Hộp số tự động", "Hộp số tự động vô cấp CVT ", "Hộp số ly hợp kép DCT", "Hộp số bán tự động", "Hộp số sang số trực tiếp DSG " }));

        cbbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe mui trần", "Xe thể thao", "Xe đa dụng", "Xe bán tải" }));

        cbbChoNgoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 chỗ", "7 chỗ", "9 chỗ", "16 chỗ", "25 chỗ" }));

        rdoKHD.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdoKHD);
        rdoKHD.setText("Ngừng kinh doanh");

        rdoHD.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdoHD);
        rdoHD.setText("Đang kinh doanh");

        jLabel25.setText("Phân khúc:");

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xanh", "Đỏ", "Tím ", "Vàng", "Đen", " " }));

        jLabel2.setText("Xuất xứ");

        jLabel4.setText("Năm SX");

        cbbNhienLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xăng ", "Dầu", "Hơi nước", "Điện" }));

        jLabel5.setText("SL tồn:");

        jLabel6.setText("Mô tả");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Accept.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnNew.setText("Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        cbbTenSP.setModel(new javax.swing.DefaultComboBoxModel<SanPhamVM>());

        jLabel7.setText("Đơn giá");

        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        txtSLton.setBackground(new java.awt.Color(238, 238, 238));
        txtSLton.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSLton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 0)));
        txtSLton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLtonActionPerformed(evt);
            }
        });

        txtNamSX.setBackground(new java.awt.Color(238, 238, 238));
        txtNamSX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNamSX.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 0)));
        txtNamSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamSXActionPerformed(evt);
            }
        });

        txtXuatXu.setBackground(new java.awt.Color(238, 238, 238));
        txtXuatXu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtXuatXu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 0)));
        txtXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXuatXuActionPerformed(evt);
            }
        });

        txtMota.setBackground(new java.awt.Color(238, 238, 238));
        txtMota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMota.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 0)));
        txtMota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotaActionPerformed(evt);
            }
        });

        txtDonGia.setBackground(new java.awt.Color(238, 238, 238));
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDonGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 0)));
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
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
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNhienLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                            .addComponent(txtNamSX))))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMota))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(393, 393, 393))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPhanKhuc, 0, 184, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChoNgoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbTenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHopso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbDongco, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbDongxe, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSLton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(98, 98, 98)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdoHD)
                                .addGap(30, 30, 30)
                                .addComponent(rdoKHD)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel24))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHopso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPhanKhuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbDongxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem))
                        .addGap(54, 54, 54)
                        .addComponent(cbbDongco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbChoNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21)
                            .addComponent(jLabel5))))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNhienLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoHD)
                    .addComponent(rdoKHD)
                    .addComponent(txtSLton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhật", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbSeachTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSeachTTMouseClicked

    }//GEN-LAST:event_cbbSeachTTMouseClicked

    private void cbbSeachTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSeachTTActionPerformed
        if (cbbSeachTT.getSelectedIndex() == 0) {
            loadTable(cTSPService.getList());
        } else if (cbbSeachTT.getSelectedIndex() == 1) {
            ArrayList<ChiTietSPVM> lst = cTSPService.getLocTrangThai(1);
            loadTable(lst);
        } else if (cbbSeachTT.getSelectedIndex() == 2) {
            ArrayList<ChiTietSPVM> lst = cTSPService.getLocTrangThai(0);
            loadTable(lst);
        }
    }//GEN-LAST:event_cbbSeachTTActionPerformed

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
        if (cbbSapXep.getSelectedIndex() == 0) {
            sortName();
        } else if (cbbSapXep.getSelectedIndex() == 1) {
            ArrayList<ChiTietSPVM> list = cTSPService.getTop2_SL();
            loadTable(list);
        } else if (cbbSapXep.getSelectedIndex() == 2) {
            ArrayList<ChiTietSPVM> list = cTSPService.getSX_GiaBan_Tang();
            loadTable(list);
        } else if (cbbSapXep.getSelectedIndex() == 3) {
            ArrayList<ChiTietSPVM> list = cTSPService.getSX_GiaBan_Giam();
            loadTable(list);
        }
    }//GEN-LAST:event_cbbSapXepActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChiTietSPVM ctSP = this.getFormData();
        if (ctSP == null) {
            return;
        }
        cTSPService.insert(ctSP);
        loadTable(cTSPService.getList());
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = this.tblCTSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn một dòng trên table");
            return;
        }
        ChiTietSPVM ctSP = this.getFormData();
        if (ctSP == null) {
            return;
        }
        String id = this.tblCTSanPham.getValueAt(row, 0).toString();
        cTSPService.update(id, ctSP);
        loadTable(cTSPService.getList());
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblCTSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn môt dòng trên table");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String id = (String) tblCTSanPham.getValueAt(row, 0);
        cTSPService.delete(id);
        loadTable(cTSPService.getList());
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lbId.setText("-");
        txtDonGia.setText("");
        txtMota.setText("");
        txtNamSX.setText("");
        txtXuatXu.setText("");
        txtSLton.setText("");

        cbbTenSP.setSelectedIndex(0);
        cbbDongco.setSelectedIndex(0);
        cbbChoNgoi.setSelectedIndex(0);
        cbbDongxe.setSelectedIndex(0);
        cbbHang.setSelectedIndex(0);
        cbbHopso.setSelectedIndex(0);
        cbbKieuDang.setSelectedIndex(0);
        cbbNhienLieu.setSelectedIndex(0);
        cbbPhanKhuc.setSelectedIndex(0);
        rdoHD.setSelected(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        Form_SanPham c = new Form_SanPham();
        c.setVisible(true);
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblCTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSanPhamMouseClicked
        int row = tblCTSanPham.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = tblCTSanPham.getValueAt(row, 0).toString();
        SanPham sp = (SanPham) tblCTSanPham.getValueAt(row, 1);
        String hang = tblCTSanPham.getValueAt(row, 2).toString();
        String kieudang = tblCTSanPham.getValueAt(row, 3).toString();
        String mausac = tblCTSanPham.getValueAt(row, 4).toString();
        String nhienlieu = tblCTSanPham.getValueAt(row, 5).toString();
        String dongxe = tblCTSanPham.getValueAt(row, 6).toString();
        String hopso = tblCTSanPham.getValueAt(row, 7).toString();
        String dongco = tblCTSanPham.getValueAt(row, 8).toString();
        String chongoi = tblCTSanPham.getValueAt(row, 9).toString();
        String phankhuc = tblCTSanPham.getValueAt(row, 10).toString();
        String xuatxu = tblCTSanPham.getValueAt(row, 11).toString();
        String namSX = tblCTSanPham.getValueAt(row, 12).toString();
        String slTon = tblCTSanPham.getValueAt(row, 13).toString();
        String giaBan = tblCTSanPham.getValueAt(row, 14).toString();
        String moTa = tblCTSanPham.getValueAt(row, 15).toString();
        String trangThai = tblCTSanPham.getValueAt(row, 16).toString();

        lbId.setText(id);
        cbbHang.setSelectedItem(hang);
        cbbKieuDang.setSelectedItem(kieudang);
        cbbMauSac.setSelectedItem(mausac);
        cbbNhienLieu.setSelectedItem(nhienlieu);
        cbbDongxe.setSelectedItem(dongxe);
        cbbHopso.setSelectedItem(hopso);
        cbbDongco.setSelectedItem(dongco);
        cbbChoNgoi.setSelectedItem(chongoi);
        cbbPhanKhuc.setSelectedItem(phankhuc);
        txtXuatXu.setText(xuatxu);
        txtNamSX.setText(namSX);
        txtSLton.setText(slTon);
        txtDonGia.setText(giaBan);
        txtMota.setText(moTa);
        if (trangThai.equalsIgnoreCase("Đang kinh doanh")) {
            rdoHD.setSelected(true);
        } else {
            rdoKHD.setSelected(true);
        }
        int slSP = cbbTenSP.getItemCount();
        for (int i = 0; i < slSP; i++) {
            SanPhamVM qlsp = cbbTenSP.getItemAt(i);
            if (qlsp.getId().equals(sp.getId())) {
                cbbTenSP.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tblCTSanPhamMouseClicked

    private void btnXuatFlieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFlieActionPerformed
        JFileChooser fileChooser = new JFileChooser("D:\\Excel");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Excel (.xls)", "xlsx");
        fileChooser.setFileFilter(filter);
        int x = fileChooser.showSaveDialog(this);
        FileOutputStream fos = null;
        File files = fileChooser.getSelectedFile();
        if (!(x == JFileChooser.APPROVE_OPTION)) {
            return;
        }
        if (cTSPService.xuatDS(files)) {
            JOptionPane.showMessageDialog(this, "Xuất danh sách thành công", "Export", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Thành công", "Export", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXuatFlieActionPerformed

    private void cbbHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHang1ActionPerformed
        String cbbsearch = this.cbbHang1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoHang(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbHang1ActionPerformed

    private void cbbDongxe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDongxe1ActionPerformed
        String cbbsearch = this.cbbDongxe1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoDongXe(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbDongxe1ActionPerformed

    private void cbbPhanKhuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhanKhuc1ActionPerformed
        String cbbsearch = this.cbbPhanKhuc1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoPhanKhuc(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbPhanKhuc1ActionPerformed

    private void cbbChoNgoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChoNgoi1ActionPerformed
        String cbbsearch = this.cbbChoNgoi1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoChoNgoi(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbChoNgoi1ActionPerformed

    private void cbbKieuDang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKieuDang1ActionPerformed
        String cbbsearch = this.cbbKieuDang1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoKieuDang(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbKieuDang1ActionPerformed

    private void cbbDongco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDongco1ActionPerformed
        String cbbsearch = this.cbbDongco1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoDongco(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbDongco1ActionPerformed

    private void cbbHopso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHopso1ActionPerformed
        String cbbsearch = this.cbbHopso1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoHopso(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbHopso1ActionPerformed

    private void cbbNhienLieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhienLieu1ActionPerformed
        String cbbsearch = this.cbbNhienLieu1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoNhienlieu(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbNhienLieu1ActionPerformed

    private void cbbMauSac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSac1ActionPerformed
        String cbbsearch = this.cbbMauSac1.getSelectedItem().toString();
        ArrayList<ChiTietSPVM> list = this.cTSPService.getLocTheoMausac(cbbsearch);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp");
            return;
        } else {
            loadTable(list);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_cbbMauSac1ActionPerformed

    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        String ten = txtSeach_txt.getText().trim();
        lst_SP = cTSPService.getSeach(ten);
        if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập sản phẩm cần tìm");
            return;
        }
        if (lst_SP.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        } else {
            loadTable(lst_SP);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_btnSeachActionPerformed

    private void locTheoGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locTheoGiaActionPerformed
        if (locTheoGia.getSelectedIndex() == 0) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(200000000), BigDecimal.valueOf(300000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 1) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(300000000), BigDecimal.valueOf(500000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 2) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(500000000), BigDecimal.valueOf(600000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 3) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(600000000), BigDecimal.valueOf(700000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 4) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(800000000), BigDecimal.valueOf(900000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 5) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(900000000), BigDecimal.valueOf(1000000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 6) {
            lst_SP = cTSPService.getLocTheoGia(BigDecimal.valueOf(1000000000), BigDecimal.valueOf(1500000000));
            loadTable(lst_SP);
        } else if (locTheoGia.getSelectedIndex() == 7) {
            lst_SP = cTSPService.getLocTheoGiaT(BigDecimal.valueOf(1500000000));
            loadTable(lst_SP);
        }
    }//GEN-LAST:event_locTheoGiaActionPerformed

    private void locTheoGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_locTheoGiaItemStateChanged

    }//GEN-LAST:event_locTheoGiaItemStateChanged

    private void txtSLtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLtonActionPerformed

    private void txtNamSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamSXActionPerformed

    private void txtXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXuatXuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXuatXuActionPerformed

    private void txtMotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotaActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lst_SP = cTSPService.getList();
        loadTable(lst_SP);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser("E:\\Excel\\fileimport");//thay đường dẫn
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Excel (.xls)", "xlsx");
        fileChooser.setFileFilter(filter);
        int x = fileChooser.showSaveDialog(this);
        FileInputStream fis = null;
        File file = fileChooser.getSelectedFile();
        if (!(x == JFileChooser.APPROVE_OPTION)) {
            return;
        }
        try {
            lst_SP = cTSPService.readExcel(file);
            ChiTietSPVM ct = getFormData();
            if (ct == null) {
                return;
            }
            for (ChiTietSPVM chiTietSPVM : lst_SP) {
                cTSPService.insert(chiTietSPVM);
            }
            lst_SP = cTSPService.getList();
            loadTable(lst_SP);
            JOptionPane.showMessageDialog(this, "Import danh sách thành công", "Import", JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thất bại", "Export", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSeach_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeach_txtActionPerformed
         String ten = txtSeach_txt.getText().trim();
        lst_SP = cTSPService.getSeach(ten);
        if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập sản phẩm cần tìm");
            return;
        }
        if (lst_SP.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        } else {
            loadTable(lst_SP);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            return;
        }
    }//GEN-LAST:event_txtSeach_txtActionPerformed

    private void txtSeach_txtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeach_txtCaretUpdate
      
        try {
            this.loadTable(cTSPService.getSeach(txtSeach_txt.getText().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSeach_txtCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSeach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFlie;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChoNgoi;
    private javax.swing.JComboBox<String> cbbChoNgoi1;
    private javax.swing.JComboBox<String> cbbDongco;
    private javax.swing.JComboBox<String> cbbDongco1;
    private javax.swing.JComboBox<String> cbbDongxe;
    private javax.swing.JComboBox<String> cbbDongxe1;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbHang1;
    private javax.swing.JComboBox<String> cbbHopso;
    private javax.swing.JComboBox<String> cbbHopso1;
    private javax.swing.JComboBox<String> cbbKieuDang;
    private javax.swing.JComboBox<String> cbbKieuDang1;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbMauSac1;
    private javax.swing.JComboBox<String> cbbNhienLieu;
    private javax.swing.JComboBox<String> cbbNhienLieu1;
    private javax.swing.JComboBox<String> cbbPhanKhuc;
    private javax.swing.JComboBox<String> cbbPhanKhuc1;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbSeachTT;
    private javax.swing.JComboBox<SanPhamVM> cbbTenSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JComboBox<String> locTheoGia;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKHD;
    private javax.swing.JTable tblCTSanPham;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtNamSX;
    private javax.swing.JTextField txtSLton;
    private javax.swing.JTextField txtSeach_txt;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
