/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author pc
 */
public class HoaDonViewModel {

//    private String maNV, tenNV, tenKH, maHD, tenXe, maXe, ghiChu;
//    private int soLuong;
//    private double khachTra;
//    private BigDecimal donGia, thanhTien, soTienGiam;
//    private Date ngayTaoHoaDon, ngayThanhToan;
//    private String mauSac,xuatXu;
//    private String sdt, diaChi;
//    public int trangThai;
    private String maNV;
    private String tenNV;
    private String maHD;
    private String maXe;
    private String tenXe;
    private int soLuong;
    private BigDecimal donGia;
    private String tenKH;
    private BigDecimal soTienGiam;
    private BigDecimal thanhTien;
    private double khachTra;
    private Date ngayTaoHoaDon;
    private Date ngayThanhToan;
    private String mauSac;
    private String xuatXu;
    private String sdt;
    private String diaChi;
    public int trangThai;
    private String ghiChu;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maNV, String tenNV, BigDecimal soTienGiam, BigDecimal thanhTien, double khachTra, Date ngayThanhToan, int trangThai, String ghiChu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soTienGiam = soTienGiam;
        this.thanhTien = thanhTien;
        this.khachTra = khachTra;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    
    
    
    
    

//  public HoaDonViewModel(String maNV, String tenNV, String ghiChu, double khachTra, BigDecimal soTienGiam, Date ngayThanhToan, int trangThai) {
//        this.maNV = maNV;
//        this.tenNV = tenNV;
//        this.ghiChu = ghiChu;
//        this.khachTra = khachTra;
//        this.soTienGiam = soTienGiam;
//        this.ngayThanhToan = ngayThanhToan;
//        this.trangThai = trangThai;
//    }
    

    public HoaDonViewModel(String maNV, String tenNV, BigDecimal soTienGiam, double khachTra, Date ngayTaoHoaDon, int trangThai, String ghiChu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soTienGiam = soTienGiam;
        this.khachTra = khachTra;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public HoaDonViewModel(String maNV, String tenNV, String maHD, String maXe, String tenXe, int soLuong, BigDecimal donGia, String tenKH, BigDecimal soTienGiam, BigDecimal thanhTien, double khachTra, Date ngayTaoHoaDon, Date ngayThanhToan, String mauSac, String xuatXu, String sdt, String diaChi, int trangThai, String ghiChu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.maHD = maHD;
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tenKH = tenKH;
        this.soTienGiam = soTienGiam;
        this.thanhTien = thanhTien;
        this.khachTra = khachTra;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.ngayThanhToan = ngayThanhToan;
        this.mauSac = mauSac;
        this.xuatXu = xuatXu;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }
   
  

//    public HoaDonViewModel(String maNV, String tenNV, String tenKH, String maXe, String tenXe, BigDecimal donGia, int soLuong, BigDecimal soTienGiam, int trangThai,Date ngayTaoHoaDon, String maHD) {
//        this.maNV = maNV;
//        this.tenNV = tenNV;
//        this.tenKH = tenKH;
//        this.maXe = maXe;
//        this.tenXe = tenXe;
//        this.donGia = donGia;
//        this.soLuong = soLuong;
//        this.soTienGiam = soTienGiam;
//        this.trangThai = trangThai;
//        this.ngayTaoHoaDon = ngayTaoHoaDon;
//        this.maHD = maHD;
//        
//    }

    public HoaDonViewModel(String maNV, String tenNV, String maHD, String maXe, String tenXe, int soLuong, BigDecimal donGia, String tenKH, BigDecimal soTienGiam, Date ngayTaoHoaDon, int trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.maHD = maHD;
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tenKH = tenKH;
        this.soTienGiam = soTienGiam;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.trangThai = trangThai;
    }
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getKhachTra() {
        return khachTra;
    }

    public void setKhachTra(double khachCanTra) {
        this.khachTra = khachCanTra;
    }

    public BigDecimal getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(BigDecimal soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public Date getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int setTrangThai(int trangThai) {
       return trangThai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
    
    
     public Object getIdNhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getIdHTTT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getIdKhachHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getMa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
