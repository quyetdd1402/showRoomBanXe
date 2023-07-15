/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.NhanVien;
import java.util.List;
 

/**
 *
 * @author PH22349
 */
public interface NhanVienService {
    List<NhanVien> getAll();
    boolean Add(NhanVien nv);
    String Delete(String maNv);
    String Update(NhanVien nv, String maNv);
    List<NhanVien> getOne(String maNv);
    List<NhanVien> listDangLV(List<NhanVien> listDangLV);  
    List<NhanVien> listQuanLy(List<NhanVien> listQuanLy); 
}
