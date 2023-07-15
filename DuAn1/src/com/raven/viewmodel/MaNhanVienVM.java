/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

/**
 *
 * @author ADMIN
 */
public class MaNhanVienVM {
    private String maNV;

    public MaNhanVienVM() {
    }

    public MaNhanVienVM(String maNV) {
        this.maNV = maNV;
    }
    

//    public MaNhanVienVM(String maNV,String tenNV) {
//        this.maNV = maNV;
//        this.tenNV = tenNV;
//    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

//    public String getTenNV() {
//        return tenNV;
//    }
//
//    public void setTenNV(String tenNV) {
//        this.tenNV = tenNV;
//    }
//
    @Override
    public String toString() {
        return maNV;
    }

    
    
}
