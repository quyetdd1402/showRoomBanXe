
package com.raven.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.raven.model.KhuyenMai;
import com.raven.service.impl.KhuyenMaiImpl;

public class ViewKhuyenMai extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    private List<KhuyenMai> listKhuyenMai;
    private KhuyenMaiImpl khuyenmaiimpl = new KhuyenMaiImpl();    
//    DefaultComboBoxModel dcb = new DefaultComboBoxModel();
//    private List<KhuyenMai> listTrangThai;
    
    public ViewKhuyenMai() {
        initComponents();
        setLocationRelativeTo(null);
        listKhuyenMai = new ArrayList<>();
        listKhuyenMai = khuyenmaiimpl.getAll();
        dtm = (DefaultTableModel) tblKM.getModel();
//        dcb = (DefaultComboBoxModel) (new DefaultComboBoxModel<>(listTrangThai.toArray()));
//        cbbTrangThai.setModel(dcb);
        showData();
//        listTrangThai = khuyenmaiimpl.getListTrangThai();
    }
    
    private void showData() {
        dtm.setRowCount(0);
        for (KhuyenMai khuyenMai : listKhuyenMai) {
            dtm.addRow(new Object[]{khuyenMai.getId(),khuyenMai.getMa(),khuyenMai.getTen(),khuyenMai.getGiamGia(),khuyenMai.getNgayBD(),khuyenMai.getNgayKT(),khuyenMai.getTrangThai()==0?"Đang hoạt động":"Dừng hoạt động"});
        }
        
    }
//     private KhuyenMai findCategoryBoxByName(String categoryName) {
//        for (int i = 0; i < listTrangThai.size(); i++) {
//            KhuyenMai category = cbbTrangThai.getItemAt(i);
//            if (categoryName.equalsIgnoreCase(category.getTrangThai()==0?"Đang hoạt động":"Không hoạt động")) {
//                return category;
//            }
//        }
//        return null;
//    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
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
        cbbTrangThai = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
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

        rdbHoatDong.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup3.add(rdbHoatDong);
        rdbHoatDong.setText("Đang hoạt động");

        rdbKHoatDong.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup3.add(rdbKHoatDong);
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

        buttonGroup2.add(rdb100);
        rdb100.setText("%");
        rdb100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb100ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbVND);
        rdbVND.setText("VND");

        jLabel4.setText("ID :");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdb100)
                                .addGap(31, 31, 31)
                                .addComponent(rdbVND))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTen))
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblID)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txtKetThuc))
                        .addGap(148, 148, 148))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(rdbHoatDong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbKHoatDong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdb100)
                            .addComponent(rdbVND))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tìm kiếm theo mã");

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Mã", "Tăng giá", "Giảm giá" }));

        jLabel11.setText("Trạng thái");

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

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                    .addComponent(jLabel11)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
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
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbKHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbKHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbKHoatDongActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

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
        showData();
    }//GEN-LAST:event_btnAddActionPerformed

    private void rdb100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb100ActionPerformed

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
        showData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void sapxeptheoten(){
        Collections.sort(listKhuyenMai, (s1,s2)-> (s1.getTen().compareTo(s2.getTen())));
        showData();
    }
   
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    txtMa.setText("");
    txtTen.setText("");
    txtBatDau.setText("");
    txtKetThuc.setText("");
    txtGiamGia.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
        showData();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
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
