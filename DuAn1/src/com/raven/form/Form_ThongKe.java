/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

/**
 *
 * @author LENOVO
 */
import com.raven.model.ThongKe;
import com.raven.model.ThongKeDoanhThu;
import com.raven.service.ThongKeService;
import com.raven.service.impl.ThongKeImpl;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

public class Form_ThongKe extends javax.swing.JPanel {

    ThongKe tk = new ThongKe();
    DefaultTableModel model = new DefaultTableModel();
    private ThongKeService tkSer = new ThongKeImpl();
    List<ThongKe> listTk = new ArrayList<>();
    List<ThongKeDoanhThu> list = new ArrayList<>();
    List<ThongKeDoanhThu> list1 = new ArrayList<>();
    List<ThongKeDoanhThu> list2 = new ArrayList<>();

    /**
     * Creates new form Form_ThongKe
     */
    public Form_ThongKe() {
        initComponents();
        list = tkSer.getAllThoiGian();
        loadTable1(list);
        loadTable();
        list1 = tkSer.namTK();
        for (ThongKeDoanhThu lk : list1) {
            list2.add(tkSer.getDoanhThuNam(String.valueOf(lk.getNam()))) ;
        }
        listTk = tkSer.getAll();
        loadTable3(list2);
        thongKeSp1(jPanel3);
        thongKeSp2(jPanel7);
    }

    public void loadTable3(List<ThongKeDoanhThu> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblNam.getModel();
        dtm.setRowCount(0);
        for (ThongKeDoanhThu tk : list) {
            Object rowData[] = {
                tk.getNam(),
                tk.getTongDoanhThu(),
                "Tháng " + tk.getThangNhieu()+ " Doanh thu tháng : " + tk.getDoanhThuThangNhieu(),
                "Tháng " + tk.getThangIt() + " Doanh thu tháng : " + tk.getDoanhThuThangIt(),
                tk.getTbDoanhThu()
            };
            dtm.addRow(rowData);
        }
    }

    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblTkSP.getModel();
        dtm.setRowCount(0);
        for (ThongKe tk : tkSer.getAll()) {
            Object rowData[] = {
                tk.getMaSP(),
                tk.getTenSP(),
                tk.getNamSX(),
                tk.getSoLuonTon(),
                tk.getGiaBan(),
                tk.getSoLuongBan(),
                tk.doanhThu()
            };
            dtm.addRow(rowData);
        }
    }

    public void loadTable1(List<ThongKeDoanhThu> List) {
        DefaultTableModel dtm = (DefaultTableModel) tabThoiGian.getModel();
        dtm.setRowCount(0);
        for (ThongKeDoanhThu tk : List) {
            Object rowData[] = {
                tk.getThoiGian(),
                tk.getDoanhThu(),
                tk.getSoHoaDon()
            };
            dtm.addRow(rowData);
        }
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void thongKeSp1(JPanel jpanItem) {
        List<ThongKe> list = tkSer.getAll();
        if (list != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ThongKe thongKe : list) {
                dataset.addValue(thongKe.getSoLuongBan(), "Tên Xe", thongKe.getTenSP());
            }
            JFreeChart tree = ChartFactory.createBarChart("THỐNG KÊ SẢN PHẨM", "Tên Sản Phẩm", "Số lượng bán", dataset, PlotOrientation.VERTICAL, true, true, true);
            ChartPanel chartPanel = new ChartPanel(tree);
            chartPanel.setPreferredSize(new Dimension(500, 360));

            jpanItem.removeAll();
            jpanItem.setLayout(new CardLayout());
            jpanItem.add(chartPanel);
            jpanItem.validate();
            jpanItem.repaint();
        }
    }

    public void thongKeSp2(JPanel jpnItem) {
        List<ThongKe> listItem = tkSer.getAll();

        TaskSeriesCollection ds = new TaskSeriesCollection();
        JFreeChart ganttChart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ THEO DÕI HOẠT ĐỘNG ",
                "Tên sản phẩm", "Số lương bán", ds, true, true, true
        );

        TaskSeries taskSeries;
        Task task;

        if (listItem != null) {
            for (ThongKe item : listItem) {
                taskSeries = new TaskSeries(item.getTenSP());
                task = new Task(item.getTenSP(), new SimpleTimePeriod( item.getSoLuongBan(),item.getSoLuonTon()));
                taskSeries.add(task);
                ds.add(taskSeries);
            }
        }
        ChartPanel chartPanel = new ChartPanel(ganttChart);
        chartPanel.setPreferredSize(new Dimension(500, 360));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        excelSp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTkSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNam = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabThoiGian = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnExcel1 = new javax.swing.JButton();
        btnExcel2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("DANH SÁCH THỐNG KÊ SẢN PHẨM");

        excelSp.setText("Export to Excel");
        excelSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelSpActionPerformed(evt);
            }
        });

        tblTkSP.setBackground(new java.awt.Color(0, 255, 255));
        tblTkSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Năm sản xuất", "Xe còn tồn", "Giá bán(TRIỆU)", "Số lượng đã bán", "Doanh thu(TRIỆU)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTkSP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(228, 228, 228)
                .addComponent(excelSp)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excelSp)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tblNam.setBackground(new java.awt.Color(0, 255, 255));
        tblNam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Năm", "Tổng doanh thu", "Tháng có doanh thu cao nhất", "Tháng có doanh thu thấp nhất", "Doanh thu trung bình tháng"
            }
        ));
        jScrollPane2.setViewportView(tblNam);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tabThoiGian.setBackground(new java.awt.Color(0, 255, 255));
        tabThoiGian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Thời Gian", "Doanh thu", "Số hóa đơn thanh toán"
            }
        ));
        jScrollPane3.setViewportView(tabThoiGian);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Từ");

        jLabel5.setText("Đến");

        btnExcel1.setText("Export to Excel");
        btnExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel1ActionPerformed(evt);
            }
        });

        btnExcel2.setText("Export to Excel");
        btnExcel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add to basket.png"))); // NOI18N
        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
                .addComponent(btnExcel2)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcel1)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnExcel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcel2)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Doanh thu", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void excelSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelSpActionPerformed

        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MÃ SẢN PHẨM");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("TÊN SẢN PHẨM");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("NĂM SẢN XUẤT");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("SỐ LƯỢNG TỒN");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("GIÁ BÁN");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("SỐ LƯỢNG BÁN");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("DOANH THU");
            System.out.println(listTk);
            for (int i = 0; i < listTk.size(); i++) {
                row = sheet.createRow(4 + i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listTk.get(i).getMaSP());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listTk.get(i).getTenSP());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(listTk.get(i).getNamSX());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(listTk.get(i).getSoLuonTon());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(listTk.get(i).getGiaBan());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(listTk.get(i).getSoLuongBan());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(listTk.get(i).doanhThu());

            }
            File file = new File("D:\\Duan1_Excel\\danhsach.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Xuất true");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_excelSpActionPerformed

    private void btnExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel1ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("NĂM");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("TỔNG DOANH THU");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("THÁNG CÓ DOANH THU CAO NHẤT");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("THÁNG CÓ DOANH THU THẤP NHẤT");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("DOANH THU TRUNG BÌNH THÁNG");
            System.out.println(list2);
            for (int i = 0; i < list2.size(); i++) {
                row = sheet.createRow(4 + i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list2.get(i).getNam());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list2.get(i).getTongDoanhThu());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Tháng" + list2.get(i).getThangNhieu() + " DOANH THU " + list2.get(i).getDoanhThuThangNhieu());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("THÁNG" + list2.get(i).getThangIt() + " DOANH THU " + list2.get(i).getDoanhThuThangIt());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(list2.get(i).getTbDoanhThu());

            }
            File file = new File("D:\\Duan1_Excel\\doanhthunam.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Xuất true");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnExcel1ActionPerformed

    private void btnExcel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel2ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("THỜI GIAN");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("DOANH THU");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("SỐ HÓA ĐƠN THANH TOÁN");
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(4 + i);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getThoiGian());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getDoanhThu());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(list.get(i).getSoHoaDon());

            }
            File file = new File("D:\\Duan1_Excel\\doanhthusearch.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Xuất true");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnExcel2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        list.clear();
        SimpleDateFormat dateFM = new SimpleDateFormat("YYYY-MM-dd");
        list = tkSer.getAllThoiGian(dateFM.format(txtNgayBatDau.getDate()), dateFM.format(txtNgayKetThuc.getDate()));
        loadTable1(list);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel1;
    private javax.swing.JButton btnExcel2;
    private javax.swing.JButton excelSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabThoiGian;
    private javax.swing.JTable tblNam;
    private javax.swing.JTable tblTkSP;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    // End of variables declaration//GEN-END:variables
}
