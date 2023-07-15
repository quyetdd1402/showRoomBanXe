/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author vha74
 */
public class ThongKe {

    private String maSP;
    private String tenSP;

    private int namSX;
    private int soLuonTon;
   
    private long giaBan;
    private int soLuongBan;

    public ThongKe() {
    }

    public ThongKe(String maSP, String tenSP, int namSX, int soLuonTon, long giaBan, int soLuongBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.namSX = namSX;
        this.soLuonTon = soLuonTon;
        this.giaBan = giaBan;
        this.soLuongBan = soLuongBan;
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

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public int getSoLuonTon() {
        return soLuonTon;
    }

    public void setSoLuonTon(int soLuonTon) {
        this.soLuonTon = soLuonTon;
    }

    

    

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    
public Long doanhThu(){
    return giaBan*soLuongBan;
}
}
