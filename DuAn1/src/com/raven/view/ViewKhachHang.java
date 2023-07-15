/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.raven.model.KhachHang;
import com.raven.service.KhachHangService;
import com.raven.service.impl.KhachHangImpl;

/**
 *
 * @author FPTSHOP
 */
public class ViewKhachHang extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<KhachHang> list = new ArrayList<>();
    private KhachHangService khachhangService = new KhachHangImpl();
    private KhachHangImpl khachhangImpl = new KhachHangImpl();

    public ViewKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        tblkhachHang.setModel(dtm);
        String[] hearder = {"ID", "Mã khách hàng", "Họ tên", "Ngày sinh", "Giới tính", "SDT", "Địa chỉ", "Quốc gia", "Trạng thái"};
        dtm.setColumnIdentifiers(hearder);
        list = khachhangService.getAll();

        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();

                    int hour = ca.get(Calendar.HOUR);
                    int minute = ca.get(Calendar.MINUTE);
                    int second = ca.get(Calendar.SECOND);
                    int PM_Am = ca.get(Calendar.AM_PM);

                    String day_night;
                    if (PM_Am == 1) {
                        day_night = "PM";

                    } else {
                        day_night = "AM";
                    }
                    String time = hour + ":" + minute + ":" + second + " " + day_night;

                    jtbDongHo.setText(time);
                }
            }
        }.start();
        ChuChay();
    }

    public void ChuChay() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String txt = lbChuChay.getText() + "  ";
                while (true) {
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(500);
                        //Uy tín-Chất Lượng-Giá Tốt
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbChuChay.setText(txt);
                }
            }
        };
        thread.start();
    }

    public void ShowData(List<KhachHang> listS) {
        dtm.setRowCount(0);
        listS.forEach(s -> dtm.addRow(s.toRowData()));

    }

    public void FillToTable(int index) {
        KhachHang kh = list.get(index);
//        System.out.println(kh.getMaKh());
        ID.setText(kh.getId());
        txtmaKH.setText(kh.getMaKh());
        txtHoTen.setText(kh.getHoTen());
        try {
            int row = tblkhachHang.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dtm.getValueAt(row, 3).toString());
            txtNgaysinh.setDate(date);
        } catch (Exception e) {
            
        }
        boolean gt = kh.isGioiTinh();
        if (gt == true) {
            rboNam.setSelected(true);

        } else {
            rboNu.setSelected(true);
        }
        txtSDT.setText(kh.getSdt());
        txtDiaChi.setText(kh.getDiaChi());
        txtQuocGia.setText(kh.getQuocGia());
        int trangThai = kh.getTrangThai();
        if (trangThai == 0) {
            cboTrangThai.setSelectedIndex(0);
        } else {
            cboTrangThai.setSelectedIndex(1);
        }
    }

    private boolean checkEmail(String txt) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+.+[A-Za-z0-9]+$");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    private boolean checkSo(String txt) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    public void lammoi() {
        ID.setText("ID");
        txtmaKH.setText("");
        txtHoTen.setText("");
//        txtNgaysinh.setDateFormatString("");
        rboNam.setSelected(rootPaneCheckingEnabled);
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtQuocGia.setText("");
        cboTrangThai.setSelectedIndex(0);
        txtTimKiem.setText("");
        JOptionPane.showMessageDialog(this, "Đã làm mới");
      
    }

    public void hienthi() {
        list = khachhangService.getAll();
        ShowData(list);
        JOptionPane.showMessageDialog(this, "Hiển thị thành công ");
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
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtQuocGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblkhachHang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        btnHienThi = new javax.swing.JButton();
        lbChuChay = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtbDongHo = new javax.swing.JLabel();
        btnSapXep = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        txtNgaysinh = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã khách hàng :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Họ tên khách hàng :");

        txtmaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtmaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaKHActionPerformed(evt);
            }
        });

        txtHoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Giới tính :");

        buttonGroup2.add(rboNam);
        rboNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rboNam.setSelected(true);
        rboNam.setText("Nam");
        rboNam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup2.add(rboNu);
        rboNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rboNu.setText("Nữ");
        rboNu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rboNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboNuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Số điện thoại :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Địa chỉ :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Quốc gia :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Trạng thái :");

        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDiaChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtQuocGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem.setBackground(new java.awt.Color(255, 255, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnThem.setText("Lưu");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemMouseMoved(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 0));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Nhập mã cần tìm :");

        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 0));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblkhachHang.setBackground(new java.awt.Color(255, 255, 204));
        tblkhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblkhachHang.setSelectionBackground(new java.awt.Color(51, 0, 204));
        tblkhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblkhachHang);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tìm Kiếm");

        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Offline" }));
        cboTrangThai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        btnHienThi.setBackground(new java.awt.Color(255, 255, 0));
        btnHienThi.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnHienThi.setText("Hiển thị");
        btnHienThi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        lbChuChay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbChuChay.setForeground(new java.awt.Color(255, 51, 51));
        lbChuChay.setText("Uy tín - Chất Lượng - Giá tốt");
        lbChuChay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHang/LogoView.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jtbDongHo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtbDongHo.setForeground(new java.awt.Color(255, 255, 255));
        jtbDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtbDongHo.setText("7:40:00 AM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btnSapXep.setBackground(new java.awt.Color(255, 255, 0));
        btnSapXep.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnSapXep.setForeground(new java.awt.Color(51, 0, 51));
        btnSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Numbered list.png"))); // NOI18N
        btnSapXep.setText("Sắp xếp");
        btnSapXep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("ID :");

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        ID.setText("ID");
        ID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNgaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(rboNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(230, 230, 230))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                                .addComponent(txtmaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSDT)
                                                .addComponent(txtDiaChi)
                                                .addComponent(txtQuocGia)
                                                .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(171, 171, 171)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbChuChay)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbChuChay, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rboNam)
                            .addComponent(rboNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách ", jPanel1);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Users.png"))); // NOI18N
        jLabel9.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String ma = txtmaKH.getText();
        JOptionPane.showMessageDialog(this, khachhangService.delete(ma));
        list = khachhangService.getAll();
        ShowData(list);
        lammoi();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

//        txtmaKH.setText("");
//        txtHoTen.setText("");
//        txtngaySinh.setText("");
//        rboNam.setSelected(rootPaneCheckingEnabled);
//        txtSDT.setText("");
//        txtDiaChi.setText("");
//        txtQuocGia.setText("");
//        cboTrangThai.setSelectedIndex(0);
//        txtTimKiem.setText("");
//        JOptionPane.showMessageDialog(this, "Đã làm mới");
        lammoi();

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
//        list = khachhangService.getAll();
//        ShowData(list);
//        JOptionPane.showMessageDialog(this, "Hiển thị thành công ");
        hienthi();
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void tblkhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachHangMouseClicked
        int row = tblkhachHang.getSelectedRow();
        khachhangService.getAll();
        FillToTable(row);
    }//GEN-LAST:event_tblkhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        String makh = txtmaKH.getText();
        String hoTen = txtHoTen.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String ngaysinh = dateFormat.format(txtNgaysinh.getDate());
        boolean gioitinh = rboNam.isSelected();
        String diaChi = txtDiaChi.getText();
        String quocGia = txtQuocGia.getText();
        String sdt = txtSDT.getText();
        int trangThai = cboTrangThai.getSelectedIndex();
        if (makh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (quocGia.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Quốc gia không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            KhachHang nv = new KhachHang(makh, hoTen, ngaysinh, gioitinh, sdt, diaChi, quocGia, trangThai);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(nv)) {
                    JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại", "Invalidation", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            boolean addNv = khachhangImpl.Add(nv);
            if(addNv == true){
                JOptionPane.showMessageDialog(this, "Add thành công");      
                list = khachhangImpl.getAll();
                ShowData(list);
                return;
            }else{
                JOptionPane.showMessageDialog(this, "Add thất bại");
                return;
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        String makh = txtmaKH.getText();
        String hoTen = txtHoTen.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String ngaysinh = dateFormat.format(txtNgaysinh.getDate());
        boolean gioitinh = rboNam.isSelected();
        String diaChi = txtDiaChi.getText();
        String quocGia = txtQuocGia.getText();
        String sdt = txtSDT.getText();
        int trangThai = cboTrangThai.getSelectedIndex();
        if (makh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (quocGia.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Quốc gia không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            KhachHang kh = new KhachHang(makh, hoTen, ngaysinh, gioitinh, sdt, diaChi, quocGia, trangThai);
            JOptionPane.showMessageDialog(this, khachhangImpl.update(kh, makh));
            list = khachhangImpl.getAll();
            ShowData(list);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String maKh = txtTimKiem.getText();
        if (maKh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            list = khachhangImpl.getOne(maKh);
            ShowData(list);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Collections.sort(list, (s1, s2) -> (s1.getMaKh().compareTo(s2.getMaKh())));
        ShowData(list);
        JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void txtmaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaKHActionPerformed

    private void rboNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboNuActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void btnThemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseMoved
        // TODO add your handling codưe here:
    }//GEN-LAST:event_btnThemMouseMoved

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
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHienThi;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jtbDongHo;
    private javax.swing.JLabel lbChuChay;
    private javax.swing.JRadioButton rboNam;
    private javax.swing.JRadioButton rboNu;
    private javax.swing.JTable tblkhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgaysinh;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtmaKH;
    // End of variables declaration//GEN-END:variables
}
