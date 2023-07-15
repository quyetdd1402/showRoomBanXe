/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.List;
import com.raven.model.KhachHang;
import com.raven.repository.KhachHangRepository;
import com.raven.service.KhachHangService;

/**
 *
 * @author FPTSHOP
 */
public class KhachHangImpl implements KhachHangService{
    
    private KhachHangRepository khachhangRp = new KhachHangRepository();
 
    @Override
    public List<KhachHang> getAll() {
        return khachhangRp.getAll();
    }

    @Override
    public boolean Add(KhachHang kh) {
        return khachhangRp.add(kh);
        
    }

    @Override
    public String delete(String makh) {
        boolean delete = khachhangRp.delete(makh);
        if(delete){
            return "delete thành công";
        }else{
            return "delete lỗi";
        }
    }

    @Override
    public String update(KhachHang kh, String maKh) {
        boolean update = khachhangRp.update(kh, maKh);
        if(update){
            return "update thành công";
        }else{
            return "update lỗi";
        }
    }

    @Override
    public List<KhachHang> getOne(String maKh) {
        return khachhangRp.getOne(maKh);
    }
    
    
}
