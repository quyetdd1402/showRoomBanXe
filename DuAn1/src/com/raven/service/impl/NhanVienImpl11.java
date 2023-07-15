/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import com.raven.model.NhanVien;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import com.raven.repository.NhanVienRepository11;
import com.raven.service.NhanVienService11;
import com.raven.viewmodel.MaNhanVienVM;
 

/**
 *
 * @author PH22349
 */
public class NhanVienImpl11 implements NhanVienService11 {

    NhanVienRepository11 nhanVienRp = new NhanVienRepository11();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRp.getAll();
    }

    @Override
    public String Update(NhanVien nv, String maNv) {
        boolean update = nhanVienRp.update(nv, maNv);
        if (update) {
            return "Update thành công";
        } else {
            return "update lỗi";
        }
    }

    @Override
    public String Delete(String maNv) {
        boolean Delete = nhanVienRp.delete(maNv);
        if (Delete) {
            return "Delete thành công";
        } else {
            return "Delete lỗi";
        }
    }

    @Override
    public List<NhanVien> getOne(String maNv) {
        return nhanVienRp.getOne(maNv);
    }

    @Override
    public boolean Add(NhanVien nv) {
        return nhanVienRp.add(nv);
    }

    @Override
    public List<NhanVien> listDangLV(List<NhanVien> listDangLV) {
        List<NhanVien> list = new ArrayList<>();
        for (NhanVien nv : listDangLV) {
            if (nv.getTrangThai() == 0) {
                list.add(nv);
            }
        }
        return list;
    }

    @Override
    public List<NhanVien> listQuanLy(List<NhanVien> listQuanLy) {
        List<NhanVien> list = new ArrayList<>();
        for (NhanVien nv : listQuanLy) {
            if (nv.getVaiTro() == 0) {
                list.add(nv);
            }
        }
        return list;
    }

    @Override
    public List<MaNhanVienVM> getNV() {
        try {
            return nhanVienRp.getNV();
        } catch (Exception ex) {
           
        }
        return null;
    }

//    @Override
//    public List<MaNhanVienVM> getTenNV(String maNV) {
//        return nhanVienRp.getOneNV(maNV);
//    }
}
