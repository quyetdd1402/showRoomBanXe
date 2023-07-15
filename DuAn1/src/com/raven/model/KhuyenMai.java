/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author PH22349
 */
public class KhuyenMai {
    private String id;
    private String ma;
    private String ten;
    private String giamGia;
    private String ngayBD;
    private String ngayKT;
    private int trangThai;

    public KhuyenMai() {
    }
    
    public KhuyenMai(String id, String ma, String ten, String giamGia, String ngayBD, String ngayKT, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giamGia = giamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
    }
    
    public KhuyenMai(String ma, String ten, String giamGia, String ngayBD, String ngayKT, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.giamGia = giamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
    }
    public KhuyenMai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   
    @Override
    public String toString() {
        return "KhuyenMai{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", giamGia=" + giamGia + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", trangThai=" + trangThai + '}';
    }

    
    
    public Object[] toRowData(){
        return new Object[]{id, ma, ten, giamGia, ngayBD, ngayKT, trangThai== 1 ?"Đang hoạt động": "Không hoạt động"};
    }
}
