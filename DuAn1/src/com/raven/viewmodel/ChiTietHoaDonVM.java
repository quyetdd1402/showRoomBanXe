/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonVM {

    private String ma, ten;
    private BigDecimal gia, tienThua;
    private int soluong, trangThai;
    private String mauSac, xuatXu;

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

    public ChiTietHoaDonVM() {
    }

    public ChiTietHoaDonVM(String ma, String ten, BigDecimal gia, BigDecimal tienThua, int soluong, int trangThai, String mauSac, String xuatXu) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.tienThua = tienThua;
        this.soluong = soluong;
        this.trangThai = trangThai;
        this.mauSac = mauSac;
        this.xuatXu = xuatXu;
    }

    public ChiTietHoaDonVM(String ma, String ten, BigDecimal gia, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soluong = soluong;
    }

    public ChiTietHoaDonVM(String ma, String ten, BigDecimal gia, BigDecimal tienThua, int soluong, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.tienThua = tienThua;
        this.soluong = soluong;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getTienThua() {
        return tienThua;
    }

    public void setTienThua(BigDecimal tienThua) {
        this.tienThua = tienThua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
