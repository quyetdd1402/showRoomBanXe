/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.raven.model.KhuyenMai;
import com.raven.service.impl.KhuyenMaiImpl;


public class Form_KhuyenMai extends javax.swing.JPanel {

    DefaultTableModel dtm = new DefaultTableModel();
    private List<KhuyenMai> listKhuyenMai;
    private KhuyenMaiImpl khuyenmaiimpl = new KhuyenMaiImpl();   
    
    public Form_KhuyenMai() {
        initComponents();
        listKhuyenMai = new ArrayList<>();
        listKhuyenMai = khuyenmaiimpl.getAll();
        dtm = (DefaultTableModel) tblKM.getModel();
        showData(listKhuyenMai);
    }
    
    public void showData(List<KhuyenMai> listKhuyenMaii) {
        dtm.setRowCount(0);
        listKhuyenMaii.forEach(s -> dtm.addRow(s.toRowData()));
    }

    
    public void sortName() {
        Collections.sort(listKhuyenMai, (s1, s2) -> (s1.getTen().compareTo(s2.getTen())));
        showData(listKhuyenMai);
    }

    public void sortMa() {
        Collections.sort(listKhuyenMai, (s1, s2) -> (s1.getMa().compareTo(s2.getMa())));
        showData(listKhuyenMai);
    }
    public void sortTangGia() {
        Collections.sort(listKhuyenMai, (s1, s2) -> (s1.getGiamGia().compareTo(s2.getGiamGia())));
        showData(listKhuyenMai);
    }
    public void sortGiamGia() {
        Collections.sort(listKhuyenMai, (s1, s2) -> (s2.getGiamGia().compareTo(s1.getGiamGia())));
        showData(listKhuyenMai);
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtBatDau = new javax.swing.JTextField();
        txtKetThuc = new javax.swing.JTextField();
        rdbHoatDong = new javax.swing.JRadioButton();
        rdbKHoatDong = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        rdb100 = new javax.swing.JRadioButton();
        rdbVND = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbbSapXep = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Mã khuyến mãi :");

        jLabel3.setText("Tên khuyến mãi :");

        jLabel6.setText("Kết thúc :");

        jLabel7.setText("Bắt đầu :");

        jLabel8.setText("Trạng Thái :");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        rdbHoatDong.setBackground(new java.awt.Color(0, 255, 255));
        rdbHoatDong.setText("Đang hoạt động");

        rdbKHoatDong.setBackground(new java.awt.Color(0, 255, 255));
        rdbKHoatDong.setText("Không hoạt động");
        rdbKHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbKHoatDongActionPerformed(evt);
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

        jLabel13.setText("Giảm giá :");

        rdb100.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdb100);
        rdb100.setText("%");
        rdb100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb100ActionPerformed(evt);
            }
        });

        rdbVND.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdbVND);
        rdbVND.setText("VND");

        jLabel4.setText("ID :");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(54, 54, 54)
                        .addComponent(txtGiamGia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblID))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdb100)
                                .addGap(18, 18, 18)
                                .addComponent(rdbVND))
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbHoatDong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbKHoatDong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(txtKetThuc))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rdbHoatDong)
                            .addComponent(rdbKHoatDong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdb100)
                            .addComponent(rdbVND))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tìm kiếm theo mã");

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Mã", "Tang giảm giá", "Giảm giảm giá" }));
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        jLabel11.setText("Hiển thị");

        jLabel12.setText("Sắp xếp");

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã khuyến mãi", "Tên khuyến mãi", "Giảm giá", "Bắt đầu", "Kết thúc", "Trạng thái"
            }
        ));
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKM);

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Hiển Thị");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Đang hoạt động");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton2)))
                .addGap(43, 43, 43))
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField7)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void rdbKHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbKHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbKHoatDongActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtMa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không được để trống");
        }else if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
        }else if (rdbVND.isSelected()==false && rdb100.isSelected()==false) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn kiểu giảm giá");
        }
        else if (txtGiamGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá không được để trống");
        }else if (txtBatDau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
        }else if (txtKetThuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống");
        }
        JOptionPane.showMessageDialog(this, khuyenmaiimpl.Add(new KhuyenMai(txtMa.getText(), txtTen.getText(), txtGiamGia.getText(), txtBatDau.getText(), txtKetThuc.getText(), rdbHoatDong.isSelected()?0:1)));
        listKhuyenMai = khuyenmaiimpl.getAll();
        showData(listKhuyenMai);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtMa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không được để trống");
        }else if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
        }else if (rdbVND.isSelected()==false && rdb100.isSelected()==false) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn kiểu giảm giá");
        }
        else if (txtGiamGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá không được để trống");
        }else if (txtBatDau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
        }else if (txtKetThuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống");
        }
        JOptionPane.showMessageDialog(this, khuyenmaiimpl.update(new KhuyenMai(txtMa.getText(), txtTen.getText(), txtGiamGia.getText(), txtBatDau.getText(), txtKetThuc.getText(), rdbHoatDong.isSelected()?0:1), lblID.getText()) );
        listKhuyenMai = khuyenmaiimpl.getAll();
        showData(listKhuyenMai);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtBatDau.setText("");
        txtKetThuc.setText("");
        txtGiamGia.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtMa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không được để trống");
        }else if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
        }else if (rdbVND.isSelected()==false && rdb100.isSelected()==false) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn kiểu giảm giá");
        }
        else if (txtGiamGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá không được để trống");
        }else if (txtBatDau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống");
        }else if (txtKetThuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống");
        }
        JOptionPane.showMessageDialog(this, khuyenmaiimpl.delete(txtMa.getText()));
        listKhuyenMai = khuyenmaiimpl.getAll();
        showData(listKhuyenMai);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String ma = jTextField7.getText();
          if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            List<KhuyenMai> seach = khuyenmaiimpl.getOne(ma);
            showData(seach);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked
        int index = tblKM.getSelectedRow();
        if (index == -1) {
            return;
        }
        txtMa.setText(tblKM.getValueAt(index, 1).toString());
        txtTen.setText(tblKM.getValueAt(index, 2).toString());
        txtGiamGia.setText(tblKM.getValueAt(index, 3).toString());
        if (tblKM.getValueAt(index, 3).toString().equalsIgnoreCase("%")) {
            rdb100.setSelected(true);
        }else{ rdbVND.setSelected(true);}
        txtBatDau.setText(tblKM.getValueAt(index, 4).toString());
        txtKetThuc.setText(tblKM.getValueAt(index, 5).toString());
        if (tblKM.getValueAt(index, 6).equals("Dừng hoạt động") ) {
            rdbKHoatDong.setSelected(true);
        }else {rdbHoatDong.setSelected(true);}
        lblID.setText(tblKM.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tblKMMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showData(listKhuyenMai);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
         if (cbbSapXep.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortName();
        } else if (cbbSapXep.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortMa();
        }else if (cbbSapXep.getSelectedIndex() == 2) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortTangGia();
        }else if (cbbSapXep.getSelectedIndex() == 3) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortGiamGia();
        }
    }//GEN-LAST:event_cbbSapXepActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<KhuyenMai> dv = khuyenmaiimpl.getTrangThai0(listKhuyenMai);
        showData(dv);
        JOptionPane.showMessageDialog(this, "Hiển thị thành công");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rdb100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb100ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblID;
    private javax.swing.JRadioButton rdb100;
    private javax.swing.JRadioButton rdbHoatDong;
    private javax.swing.JRadioButton rdbKHoatDong;
    private javax.swing.JRadioButton rdbVND;
    private javax.swing.JTable tblKM;
    private javax.swing.JTextField txtBatDau;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtKetThuc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
