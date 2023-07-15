/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import java.util.List;
import com.raven.model.KhuyenMai;
import com.raven.viewmodel.MaKhuyenMaiVM;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface KhuyenMaiService {
      List<KhuyenMai> getAll();

    String Add(KhuyenMai km);

    String update(KhuyenMai km, String ma);
    
    String delete(String ma);
    
    List<KhuyenMai> getListTrangThai();

    List<KhuyenMai> getOne(String ma);
    
    List<KhuyenMai> getTrangThai0(List<KhuyenMai> ListDangHoatDong);
    
    ArrayList<MaKhuyenMaiVM> getKM();
 
    
}
