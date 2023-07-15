package com.raven.main;

import com.raven.event.EventMenuSelected;
import com.raven.form.Form_BanHang;
import com.raven.form.Form_SanPhamCT;
import com.raven.form.Form_HoaDon;
import com.raven.form.Form_Home;
import com.raven.form.Form_KhachHang;
import com.raven.form.Form_KhuyenMai;
import com.raven.form.Form_NhanVien;
import com.raven.form.Form_ThongKe;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComponent;

public class Main extends javax.swing.JFrame {

    private Form_Home home;
    private Form_BanHang form1;
    private Form_SanPhamCT form2;
    private Form_HoaDon form3;
    private Form_KhuyenMai form4;
    private Form_ThongKe form5;
    private Form_NhanVien form6;
    private Form_KhachHang form7;

    public Main() {
        initComponents();
        setBackground(new Color(51, 255, 204));
        home = new Form_Home();
        form1 = new Form_BanHang();
        form2 = new Form_SanPhamCT();
        form3 = new Form_HoaDon();
        form4 = new Form_KhuyenMai();
        form5 = new Form_ThongKe();
        form6 = new Form_NhanVien();
        form7 = new Form_KhachHang();
        menu.initMoving(Main.this);
        ChuChay();
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(form1);
                } else if (index == 2) {
                    setForm(form2);
                } else if (index == 3) {
                    setForm(form3);
                } else if (index == 4) {
                    setForm(form4);
                } else if (index == 5) {
                    setForm(form5);
                } else if (index == 6) {
                    setForm(form6);
                } else if (index == 7) {
                    setForm(form7);
                }
            }
        });
        setForm(new Form_Home());
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

        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();

                    int hour = ca.get(Calendar.DATE);
                    int minute = ca.get(Calendar.MONTH);
                    int second = ca.get(Calendar.YEAR);

                    String time = hour + "/" + "12" + "/" + second;
                    lblNgayThang.setText(time);
                }
            }
        }.start();
    }

    public void ChuChay() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String txt = lbChuChay.getText() + " ";
                while (true) {
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(150);
                    } catch (InterruptedException ex) {
                    }
                    lbChuChay.setText(txt);
                }
            }
        };
        thread.start();
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        mainPanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lbChuChay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDongHo = new javax.swing.JLabel();
        lblNgayThang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        mainPanel.setBackground(new java.awt.Color(51, 255, 204));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbChuChay.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lbChuChay.setForeground(new java.awt.Color(255, 51, 51));
        lbChuChay.setText("CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI PHẦN MỀM BÁN Ô TÔ DEVCAR - CHÚC QUÝ KHÁCH MỘT NGÀY TỐT LÀNH");

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        lblDongHo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblDongHo.setForeground(new java.awt.Color(255, 0, 0));
        lblDongHo.setText("00:00:00");

        lblNgayThang.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNgayThang.setForeground(new java.awt.Color(255, 0, 0));
        lblNgayThang.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lblNgayThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDongHo))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lbChuChay, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lbChuChay, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu.getAccessibleContext().setAccessibleName("");
        menu.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 1482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbChuChay;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblNgayThang;
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
