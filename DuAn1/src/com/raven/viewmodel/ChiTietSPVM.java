
package com.raven.viewmodel;

import com.raven.model.SanPham;
import java.math.BigDecimal;

public class ChiTietSPVM {
     private String id;
    private SanPham sanPham;
    private String hangSP;
    private String kieudang;
    private String mausac;
    private String nhienlieu;
    private String dongxe;
    private String hopso;
    private String dongco;
    private String chongoi;
    private String phankhuc;
    private String xuatxu;
    private int namSX;
    private int soLuongTon;
    private BigDecimal dongia;
    private String moTa;
    private int trangthai;

    public ChiTietSPVM() {
    }

    public ChiTietSPVM(String id, SanPham sanPham, String hangSP, String kieudang, String mausac, String nhienlieu, String dongxe, String hopso, String dongco, String chongoi, String phankhuc, String xuatxu, int namSX, int soLuongTon, BigDecimal dongia, String moTa, int trangthai) {
        this.id = id;
        this.sanPham = sanPham;
        this.hangSP = hangSP;
        this.kieudang = kieudang;
        this.mausac = mausac;
        this.nhienlieu = nhienlieu;
        this.dongxe = dongxe;
        this.hopso = hopso;
        this.dongco = dongco;
        this.chongoi = chongoi;
        this.phankhuc = phankhuc;
        this.xuatxu = xuatxu;
        this.namSX = namSX;
        this.soLuongTon = soLuongTon;
        this.dongia = dongia;
        this.moTa = moTa;
        this.trangthai = trangthai;
    }

    public ChiTietSPVM(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getHangSP() {
        return hangSP;
    }

    public void setHangSP(String hangSP) {
        this.hangSP = hangSP;
    }

    public String getKieudang() {
        return kieudang;
    }

    public void setKieudang(String kieudang) {
        this.kieudang = kieudang;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getNhienlieu() {
        return nhienlieu;
    }

    public void setNhienlieu(String nhienlieu) {
        this.nhienlieu = nhienlieu;
    }

    public String getDongxe() {
        return dongxe;
    }

    public void setDongxe(String dongxe) {
        this.dongxe = dongxe;
    }

    public String getHopso() {
        return hopso;
    }

    public void setHopso(String hopso) {
        this.hopso = hopso;
    }

    public String getDongco() {
        return dongco;
    }

    public void setDongco(String dongco) {
        this.dongco = dongco;
    }

    public String getChongoi() {
        return chongoi;
    }

    public void setChongoi(String chongoi) {
        this.chongoi = chongoi;
    }

    public String getPhankhuc() {
        return phankhuc;
    }

    public void setPhankhuc(String phankhuc) {
        this.phankhuc = phankhuc;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "ChiTietSPVM{" + "id=" + id + ", sanPham=" + sanPham + ", hangSP=" + hangSP + ", kieudang=" + kieudang + ", mausac=" + mausac + ", nhienlieu=" + nhienlieu + ", dongxe=" + dongxe + ", hopso=" + hopso + ", dongco=" + dongco + ", chongoi=" + chongoi + ", phankhuc=" + phankhuc + ", xuatxu=" + xuatxu + ", namSX=" + namSX + ", soLuongTon=" + soLuongTon + ", dongia=" + dongia + ", moTa=" + moTa + ", trangthai=" + trangthai + '}';
    }
}
