/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author vha74
 */
public class HoaDon {
    private String maHD;
    private String tenXe;
    private String tenNV;
    private String tenKH;
    private String ngayTao;
    private String ngayThanhToan;
    private long khachTra;
    private long tongTien;
    private int soTienGiam;
    private String sdtNguoiNhan;
    private int baoHiem;
    private int lamBien;
    private int trangThai;
    private String note;

    public HoaDon() {
    }

    public HoaDon(int trangThai) {
        this.trangThai = trangThai;
    }
    
    

    public HoaDon(String maHD, String tenXe, String tenNV, String tenKH, String ngayTao, String ngayThanhToan, long khachTra, long tongTien, int soTienGiam, String sdtNguoiNhan, int baoHiem, int lamBien, int trangThai, String note) {
        this.maHD = maHD;
        this.tenXe = tenXe;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.khachTra = khachTra;
        this.tongTien = tongTien;
        this.soTienGiam = soTienGiam;
        this.sdtNguoiNhan = sdtNguoiNhan;
        this.baoHiem = baoHiem;
        this.lamBien = lamBien;
        this.trangThai = trangThai;
        this.note = note;
    }

    public HoaDon(String text, String text0, String text1, String text2, String format, String format0, int parseInt, Integer valueOf, String text3, int i, int i0, int trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public long getKhachTra() {
        return khachTra;
    }

    public void setKhachTra(long khachTra) {
        this.khachTra = khachTra;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(int soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public int getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(int baoHiem) {
        this.baoHiem = baoHiem;
    }

    public int getLamBien() {
        return lamBien;
    }

    public void setLamBien(int lamBien) {
        this.lamBien = lamBien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return trangThai + "";
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
