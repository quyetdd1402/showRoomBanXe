/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author pc
 */
public class SanPhamVM2 {

    private String id;
    private String ma;
    private String ten;
    private String mauSac;
    private String phanKhuc;
    private String choNgoi;
    private String dongCo;
    private String dongXe;
    private String hopSo;
    private String nhienLieu;
    private String kieuDang;
    private BigDecimal giaBan;
    private int namSx;
    private int trangThai;
    private String xuatXu;

    public SanPhamVM2() {
    }

    public SanPhamVM2(String ma, String ten, String mauSac, String phanKhuc, String choNgoi, String dongCo, String dongXe, String hopSo, String nhienLieu, String kieuDang, BigDecimal giaBan, int namSx, String xuatXu) {
        this.ma = ma;
        this.ten = ten;
        this.mauSac = mauSac;
        this.phanKhuc = phanKhuc;
        this.choNgoi = choNgoi;
        this.dongCo = dongCo;
        this.dongXe = dongXe;
        this.hopSo = hopSo;
        this.nhienLieu = nhienLieu;
        this.kieuDang = kieuDang;
        this.giaBan = giaBan;
        this.namSx = namSx;
        this.xuatXu = xuatXu;
    }
    

    public SanPhamVM2(String id, String ma, String ten, String mauSac, BigDecimal giaBan, int namSx, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.namSx = namSx;
        this.trangThai = trangThai;
    }

    public SanPhamVM2(String id, String ma, String ten, String mauSac, BigDecimal giaBan, int namSx,String xuatXu, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.namSx = namSx;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
    }

    public String getPhanKhuc() {
        return phanKhuc;
    }

    public void setPhanKhuc(String phanKhuc) {
        this.phanKhuc = phanKhuc;
    }

    public String getChoNgoi() {
        return choNgoi;
    }

    public void setChoNgoi(String choNgoi) {
        this.choNgoi = choNgoi;
    }

    public String getDongCo() {
        return dongCo;
    }

    public void setDongCo(String dongCo) {
        this.dongCo = dongCo;
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }

    public String getHopSo() {
        return hopSo;
    }

    public void setHopSo(String hopSo) {
        this.hopSo = hopSo;
    }

    public String getNhienLieu() {
        return nhienLieu;
    }

    public void setNhienLieu(String nhienLieu) {
        this.nhienLieu = nhienLieu;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
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

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getNamSx() {
        return namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamVM{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", giaBan=" + giaBan + ", namSx=" + namSx + ", trangThai=" + trangThai + '}';
    }

    public Object[] toRowData() {
        return new Object[]{id, ma, ten, giaBan, namSx, trangThai == 0 ? "Dang kinh doanh" : "Ngung kinh doanh"};
    }
public Object[] toRowData1(){
    return new Object[]{ ma, ten, mauSac,giaBan,namSx,xuatXu,trangThai == 0 ? "Dang kinh doanh" : "Ngung kinh doanh"};
}
}
