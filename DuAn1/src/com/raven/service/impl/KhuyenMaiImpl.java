/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.raven.model.KhuyenMai;
import com.raven.repository.KhuyenMaiRepository;
import com.raven.service.KhuyenMaiService;
import com.raven.viewmodel.MaKhuyenMaiVM;
import java.util.logging.Level;
import java.util.logging.Logger;
 

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiImpl implements KhuyenMaiService{
     private KhuyenMaiRepository KMRP = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return KMRP.getAll();
    }

     @Override
    public String Add(KhuyenMai km) {
        boolean add = KMRP.add(km);
        if (add) {
            return "Add thành công";
        } else {
            return "Add lỗi";
        }
    }


   
    

    @Override
    public String update(KhuyenMai km, String ma) {
    boolean update = KMRP.update(km, ma);
        if (update) {
            return "Update thành công";
        } else {
            return "Update lỗi";
        }    }

    @Override
    public List<KhuyenMai> getTrangThai0(List<KhuyenMai> ListDangHoatDong) {
        List<KhuyenMai> list = new ArrayList<>();
        for (KhuyenMai nv : ListDangHoatDong) {
            if (nv.getTrangThai()== 1) {
                list.add(nv);
            }
        }
        return list;
    }

 
    @Override
    public String delete(String ma) {
 boolean update = KMRP.delete(ma);
        if (update) {
            return "Xóa thành công";
        } else {
            return "Xóa lỗi";
        }    }

    @Override
    public List<KhuyenMai> getListTrangThai() {
        return KMRP.getTrangThai();
    }

    @Override
    public List<KhuyenMai> getOne(String ma) {
        return KMRP.getOne(ma);
    }

     @Override
    public ArrayList<MaKhuyenMaiVM> getKM() {
         try {
            return (ArrayList<MaKhuyenMaiVM>) KMRP.getKM();
        } catch (Exception ex) {
           
        }
        return null;

}
}
