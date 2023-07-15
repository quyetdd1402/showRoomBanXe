package com.raven.viewmodel;

public class SanPhamVM {

    private String id;
    private String ma;
    private String ten;
    private String anh;

    public SanPhamVM() {
    }

    public SanPhamVM(String id, String ma, String ten, String anh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.anh = anh;
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

//    public String getGia() {
//        return gia;
//    }
//
//    public void setGia(String gia) {
//        this.gia = gia;
//    }
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return ten;
    }
}
