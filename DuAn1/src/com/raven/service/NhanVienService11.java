/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.NhanVien;
import java.util.List;
 
import com.raven.viewmodel.MaNhanVienVM;

/**
 *
 * @author PH22349
 */
public interface NhanVienService11 {
    List<NhanVien> getAll();
    List<MaNhanVienVM> getNV();
//    List<MaNhanVienVM> getTenNV(String maNV);
    boolean Add(NhanVien nv);
    String Delete(String maNv);
    String Update(NhanVien nv, String maNv);
    List<NhanVien> getOne(String maNv);
    List<NhanVien> listDangLV(List<NhanVien> listDangLV);  
    List<NhanVien> listQuanLy(List<NhanVien> listQuanLy); 
}
