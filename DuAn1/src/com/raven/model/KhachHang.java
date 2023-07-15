/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author PH22349
 */
public class KhachHang {

    private String id;
    private String maKh;  
    private String hoTen;
    private String ngaySinh;
    private boolean gioiTinh;
    private String sdt;
    private String diaChi;
    private String quocGia;
    private int trangThai;
    

    public KhachHang() {
    }

    public KhachHang(String id, String maKh, String hoTen, String ngaySinh, boolean gioiTinh, String sdt, String diaChi, String quocGia, int trangThai) {
        this.id = id;
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public KhachHang(String maKh, String hoTen, String ngaySinh, boolean gioiTinh, String sdt, String diaChi, String quocGia, int trangThai) {
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", maKh=" + maKh + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", quocGia=" + quocGia + ", trangThai=" + trangThai + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KhachHang) {
            KhachHang nv = (KhachHang) obj;
            if (this.maKh.equals(nv.maKh)) {
                return true;
            }
        }
        return false;
    }

    
    
    public Object[] toRowData(){
        return new Object[]{id, maKh,hoTen,ngaySinh, gioiTinh == true ? "Nam":"Nữ", sdt, diaChi, quocGia, trangThai == 0 ? "Mới": "Cũ"};
    }
    
}


