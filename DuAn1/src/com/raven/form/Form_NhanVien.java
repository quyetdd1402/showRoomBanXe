
package com.raven.form;

import com.raven.model.NhanVien;
import com.raven.service.impl.NhanVienImpl;
import java.awt.Image;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigestSpi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

public class Form_NhanVien extends javax.swing.JPanel {

    private List<NhanVien> listNhanVien;
    private List<String> listCbb = new ArrayList<>();
    private List<String> listCbb2 = new ArrayList<>();
    private NhanVienImpl nhanVienImpl = new NhanVienImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel dtcm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dtcmChucVu = new DefaultComboBoxModel();
    private String hinhAnh = null;

    public Form_NhanVien() {
        initComponents();
        tblNhanVienDLM.setModel(dtm);
        listNhanVien = new ArrayList<>();
        String[] header = {"ID", "Mã Nv", "Tên Nv", "Vai Trò", "Ngày Sinh", "Giới Tính", "Số ĐT", "Email", "Địa Chỉ", "Ảnh", "Lương", "Trạng Thái"};
        dtm.setColumnIdentifiers(header);
        cbbTrangThai.setModel(dtcm);
        cbbVaiTro.setModel(dtcmChucVu);
        loadCbb();
        loadCbb2();
        dtcmChucVu.addAll(listCbb2);
        dtcm.addAll(listCbb);
        dtcm.setSelectedItem("Đang làm việc");
        dtcmChucVu.setSelectedItem("Quản lý");
        listNhanVien = nhanVienImpl.getAll();
        showData(listNhanVien);

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
                    lblDongHo.setText(time);
                }
            }
        }.start();

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

    public void showData(List<NhanVien> listNhanViens) {
        dtm.setRowCount(0);
        listNhanViens.forEach(s -> dtm.addRow(s.toRowData()));
    }

    public void loadCbb() {
        listCbb.add(String.valueOf("Đang làm việc"));
        listCbb.add(String.valueOf("Nghỉ việc"));
    }

    public void loadCbb2() {
        listCbb2.add(String.valueOf("Quản lý"));
        listCbb2.add(String.valueOf("Nhân viên"));
    }

    public void fillData(int i) {
        NhanVien nv = listNhanVien.get(i);
        lblID.setText(nv.getId());
        txtMaNv.setText(nv.getMaNV());
        txtTenNV.setText(nv.getTen());
        try {
            int row = tblNhanVienDLM.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtm.getValueAt(row, 4).toString());
            jDate.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        txtEmail.setText(nv.getEmail());
        txtSdt.setText(nv.getSdt());
        txtDiaChi.setText(nv.getDiaChi());
        txtLuong.setText(nv.getLuong());
        if (nv.getAnh().equalsIgnoreCase("No avata")) {
            lblImage.setText("No avata");
            lblImage.setIcon(null);
        } else {
            lblImage.setText("");
            try {
                Image avartarImg = ImageIO.read(new File("E:\\Nhom4\\DuAn1Nhom4\\DuAn1\\src\\image\\" + nv.getAnh()));
                ImageIcon icon = new ImageIcon(avartarImg.getScaledInstance(128, 175, Image.SCALE_SMOOTH));
                this.lblImage.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }

            boolean gioiTinh = nv.isGioiTinh();
            if (gioiTinh == true) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }

            int vaiTro = nv.getVaiTro();
            if (vaiTro == 0) {
                cbbVaiTro.setSelectedIndex(0);
            } else {
                cbbVaiTro.setSelectedIndex(1);
            }

            int trangThai = nv.getTrangThai();
            if (trangThai == 0) {
                cbbTrangThai.setSelectedIndex(0);
            } else {
                cbbTrangThai.setSelectedIndex(1);
            }
        }
    }

    public void clearFrom() {
        lblID.setText("");
    
        txtTenNV.setText("");
        txtMaNv.setText("");
        cbbVaiTro.setSelectedIndex(0);
        txtEmail.setText("");
        txtSdt.setText("");
        txtDiaChi.setText("");
        txtLuong.setText("");
        rdoNam.setSelected(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/User.png"));
        lblImage.setIcon(icon);
        cbbTrangThai.setSelectedIndex(0);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void sortName() {
        Collections.sort(listNhanVien, (s1, s2) -> (s1.getTen().compareTo(s2.getTen())));
        showData(listNhanVien);
    }

    public void sortLuong() {
        Collections.sort(listNhanVien, (s1, s2) -> (s1.getLuong().compareTo(s2.getLuong())));
        showData(listNhanVien);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaNv = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        cbbVaiTro = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVienDLM = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbbSapXep = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Mã nv");

        jLabel3.setText("Tên nv");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Giới Tính");

        jLabel6.setText("SĐT");

        jLabel7.setText("Email");

        jLabel8.setText("Trạng Thái");

        jLabel9.setText("Địa Chỉ");

        txtMaNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNvActionPerformed(evt);
            }
        });

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        rdoNam.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(255, 255, 0));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel13.setText("Vai trò");

        btnDelete.setBackground(new java.awt.Color(255, 255, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Lương");

        btnBrowse.setBackground(new java.awt.Color(255, 255, 0));
        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Documents.png"))); // NOI18N
        btnBrowse.setText("Mở Hình");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User.png"))); // NOI18N
        lblImage.setText("Anh");
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setText("ID nv");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel13)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNv)
                            .addComponent(txtTenNV)
                            .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbVaiTro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtLuong)
                                        .addComponent(cbbTrangThai, 0, 245, Short.MAX_VALUE)))))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnNew)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(lblID))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNew)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnBrowse)))
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 204));

        tblNhanVienDLM.setBackground(new java.awt.Color(0, 255, 255));
        tblNhanVienDLM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Nv", "Tên Nv", "Vai Trò", "Ngày Sinh", "Giới Tính", "Số ĐT", "Email", "Địa Chỉ", "Ảnh", "Lương", "Trạng Thái"
            }
        ));
        tblNhanVienDLM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienDLMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVienDLM);

        jTabbedPane1.addTab("Thông tin nhân viên", jScrollPane1);

        btnSearch.setBackground(new java.awt.Color(255, 255, 0));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel10.setText("Tìm kiếm theo mã");

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Lương", " " }));
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        jLabel12.setText("Sắp xếp");

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print preview.png"))); // NOI18N
        jButton3.setText("Đang làm việc");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User.png"))); // NOI18N
        jButton4.setText("Quản Lý");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Hiển thị");

        jLabel16.setText("Hiển thị");

        lblDongHo.setText("00:00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSearch)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblDongHo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNvActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed

    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String maNv = txtMaNv.getText();
        String tenNv = txtTenNV.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDate.getDate());
        int vaiTro = cbbVaiTro.getSelectedIndex();
        String email = txtEmail.getText();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        boolean gioiTinh = rdoNam.isSelected();
        String anh = lblImage.getText();
        String luong = txtLuong.getText();
        int trangThai = cbbTrangThai.getSelectedIndex();
        if (maNv.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (tenNv.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (date.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(luong)) {
            JOptionPane.showMessageDialog(this, "Lương phải là số", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (luong.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email phải đúng định dạng có @ và dấu chấm", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            NhanVien nv = new NhanVien(maNv, tenNv, vaiTro, date, gioiTinh, sdt, email, diaChi, anh, luong, trangThai);
            for (int i = 0; i < listNhanVien.size(); i++) {
                if (listNhanVien.get(i).equals(nv)) {
                    JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại", "Invalidation", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            boolean addNv = nhanVienImpl.Add(nv);
            if (addNv == true) {
                JOptionPane.showMessageDialog(this, "Add thành công");
                listNhanVien = nhanVienImpl.getAll();
                showData(listNhanVien);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Add thất bại");
                return;
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = this.tblNhanVienDLM.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng tên Table");
            return;
        }
        String id = lblID.getText();
        String maNv = txtMaNv.getText();
        String tenNv = txtTenNV.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDate.getDate());
        int vaiTro = cbbVaiTro.getSelectedIndex();
        String email = txtEmail.getText();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        boolean gioiTinh = rdoNam.isSelected();
        String anh = lblImage.getText();
        String luong = txtLuong.getText();
        int trangThai = cbbTrangThai.getSelectedIndex();
        if (maNv.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (tenNv.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (date.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(luong)) {
            JOptionPane.showMessageDialog(this, "Lương phải là số", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (luong.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email phải đúng định dạng có @ và dấu chấm", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            NhanVien nv = new NhanVien(maNv, tenNv, vaiTro, date, gioiTinh, sdt, email, diaChi, anh, luong, trangThai);
            JOptionPane.showMessageDialog(this, nhanVienImpl.Update(nv, id));
            listNhanVien = nhanVienImpl.getAll();
            showData(listNhanVien);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearFrom();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = this.tblNhanVienDLM.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng tên Table");
            return;
        }
        String maNv = txtMaNv.getText();
        JOptionPane.showMessageDialog(this, nhanVienImpl.Delete(maNv));
        listNhanVien = nhanVienImpl.getAll();
        showData(listNhanVien);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showData(listNhanVien);
        txtSearch.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        try {
            JFileChooser j = new JFileChooser("E:\\Nhom4\\DuAn1Nhom4\\DuAn1\\src\\image\\");
            j.showOpenDialog(null);
            File file = j.getSelectedFile();
            Image img = ImageIO.read(file);
            hinhAnh = file.getName();
            lblImage.setText("");
            lblImage.setText(hinhAnh);
            int wight = lblImage.getWidth();
            int height = lblImage.getHeight();
            lblImage.setIcon(new ImageIcon(img.getScaledInstance(wight, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //            JFileChooser f = new JFileChooser("C:\\Users\\admin\\OneDrive\\Tài liệu\\image");
        //            f.setFileFilter(new FileFilter() {
        //                @Override
        //                public boolean accept(File file) {
        //                    if(file.isDirectory()){
        //                        return true;
        //                    }else{
        //                        return file.getName().toLowerCase().endsWith(".jpg");
        //                    }
        //                }
        //
        //                @Override
        //                public String getDescription() {
        //                    return "Image File (*.jpg)";
        //                }
        //            });
        //            if(f.showOpenDialog(jPanel1) == JFileChooser.CANCEL_OPTION){
        //                return;
        //            }
        //            File f2 = f.getSelectedFile();
        //            try {
        //            ImageIcon icon  = new ImageIcon(f2.getPath());
        //            Image img = ImageHelper.resize(icon.getImage(), 140, 160);
        //            ImageIcon resizedIcon = new ImageIcon(img);
        //            lblImage.setIcon(resizedIcon);
        //            personalImage = ImageHelper.toByteArray(img, "jpg");
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //        try {
        //
        //            f.setDialogTitle("Mở file");
        //            f.showOpenDialog(null);
        //            File ftenAnh = f.getSelectedFile();
        //            duongDanAnh = ftenAnh.getAbsolutePath();
        //            lblImage.setIcon(ResizeImage(String.valueOf(duongDanAnh)));
        //
        //            System.out.println(duongDanAnh);
        //
        //        } catch (Exception e) {
        //            System.out.println("Bạn chưa chọn ảnh");
        //            System.out.println(duongDanAnh);
        //        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        try {
            JFileChooser j = new JFileChooser("E:\\Nhom4\\DuAn1Nhom4\\DuAn1\\src\\image\\");
            j.showOpenDialog(null);
            File file = j.getSelectedFile();
            Image img = ImageIO.read(file);
            hinhAnh = file.getName();
            lblImage.setText("");
            int wight = lblImage.getWidth();
            int height = lblImage.getHeight();
            lblImage.setIcon(new ImageIcon(img.getScaledInstance(wight, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void tblNhanVienDLMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienDLMMouseClicked
        int row = tblNhanVienDLM.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tblNhanVienDLMMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String maNv = txtSearch.getText();
        NhanVien nv = new NhanVien();
        if (maNv.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            List<NhanVien> seach = nhanVienImpl.getOne(maNv);
            showData(seach);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
        if (cbbSapXep.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortName();
        } else if (cbbSapXep.getSelectedIndex() == 1)  {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortLuong();
        }
    }//GEN-LAST:event_cbbSapXepActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<NhanVien> dv = nhanVienImpl.listDangLV(listNhanVien);
        showData(dv);
        JOptionPane.showMessageDialog(this, "Hiển thị thành công");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        List<NhanVien> dv = nhanVienImpl.listQuanLy(listNhanVien);
        showData(dv);
        JOptionPane.showMessageDialog(this, "Hiển thị thành công");
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbVaiTro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVienDLM;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
