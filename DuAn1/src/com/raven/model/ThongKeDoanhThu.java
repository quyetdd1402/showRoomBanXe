 
package com.raven.model;

 
public class ThongKeDoanhThu {

    
    private String thoiGian;
    private Long doanhThu;
    private Long tongDoanhThu;
    private Long doanhThuThangNhieu;
    private Long doanhThuThangIt;
    private int  soHoaDon, tbDoanhThu, thangNhieu, thangIt, nam;

    
    public ThongKeDoanhThu(String thoiGian, long doanhThu, int soHoaDon) {
        this.thoiGian = thoiGian;
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
    }
    
    

    public ThongKeDoanhThu(int nam) {
        this.nam = nam;
    }

    public ThongKeDoanhThu(Long tongDoanhThu, int tbDoanhThu, int thangNhieu, int thangIt, Long doanhThuThangNhieu, Long doanhThuThangIt, int nam) {
        this.tongDoanhThu = tongDoanhThu;
        this.tbDoanhThu = tbDoanhThu;
        this.thangNhieu = thangNhieu;
        this.thangIt = thangIt;
        this.doanhThuThangNhieu = doanhThuThangNhieu;
        this.doanhThuThangIt = doanhThuThangIt;
        this.nam = nam;
    }

    public ThongKeDoanhThu() {
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Long getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(Long doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Long getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(Long tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public int getTbDoanhThu() {
        return tbDoanhThu;
    }

    public void setTbDoanhThu(int tbDoanhThu) {
        this.tbDoanhThu = tbDoanhThu;
    }

    public int getThangNhieu() {
        return thangNhieu;
    }

    public void setThangNhieu(int thangNhieu) {
        this.thangNhieu = thangNhieu;
    }

    public int getThangIt() {
        return thangIt;
    }

    public void setThangIt(int thangIt) {
        this.thangIt = thangIt;
    }

    public Long getDoanhThuThangNhieu() {
        return doanhThuThangNhieu;
    }

    public void setDoanhThuThangNhieu(Long doanhThuThangNhieu) {
        this.doanhThuThangNhieu = doanhThuThangNhieu;
    }

    public Long getDoanhThuThangIt() {
        return doanhThuThangIt;
    }

    public void setDoanhThuThangIt(Long doanhThuThangIt) {
        this.doanhThuThangIt = doanhThuThangIt;
    }

}
