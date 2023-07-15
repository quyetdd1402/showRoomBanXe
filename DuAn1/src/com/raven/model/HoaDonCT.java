/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author vha74
 */
public class HoaDonCT {

    private String maSP, tenSP;
    private long  donGia;
    private int soLuong, tienThua;
    private long tongTien;
    private int trangThai;

    public HoaDonCT() {
    }

    public HoaDonCT(String maSP, String tenSP, long donGia, int soLuong, int tienThua, long tongTien, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tienThua = tienThua;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDonCT(long tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDonCT(int soLuong) {
        this.soLuong = soLuong;
    }
     

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tongTien + "";
    }
    
    public int to(){
        return soLuong;
    }

   

}
