/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

import java.util.Date;

/**
 *
 * @author PH22349
 */
public class NhanVienVM {
    private String id;
    private String maNV;
    private String hoTenNv;
    private String vaiTro;
    private String ngaySinh;
    private boolean gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String anh;
    private String luong;
    private int trangThai;

    public NhanVienVM() {
        
    }

    public NhanVienVM(String id, String maNV, String hoTenNv, String vaiTro, String ngaySinh, boolean gioiTinh, String sdt, String email, String diaChi, String anh, String luong, int trangThai) {
        this.id = id;
        this.maNV = maNV;
        this.hoTenNv = hoTenNv;
        this.vaiTro = vaiTro;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.anh = anh;
        this.luong = luong;
        this.trangThai = trangThai;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTenNv() {
        return hoTenNv;
    }

    public void setHoTenNv(String hoTenNv) {
        this.hoTenNv = hoTenNv;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVienVM{" + "id=" + id + ", maNV=" + maNV + ", hoTenNv=" + hoTenNv + ", vaiTro=" + vaiTro + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", anh=" + anh + ", luong=" + luong + ", trangThai=" + trangThai + '}';
    }

    
    public Object[] toRowData() {
        return new Object[]{id, maNV, hoTenNv,vaiTro, ngaySinh, gioiTinh == true ? "Nam" : "Nữ", sdt, email, diaChi,anh, luong ,trangThai == 1 ? "Đang làm việc" : "Nghỉ việc"};
    }
}
