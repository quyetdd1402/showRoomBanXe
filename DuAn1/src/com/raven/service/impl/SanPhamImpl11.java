package com.raven.service.impl;

import com.raven.model.SanPham;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
import com.raven.repository.SanPhamRepository11;
import com.raven.service.SanPhamService11;

import com.raven.viewmodel.SanPhamVM2;
import java.math.BigDecimal;
 

public class SanPhamImpl11 implements SanPhamService11 {
    
    private SanPhamRepository11 spRepo = new SanPhamRepository11();
    
    @Override
    public ArrayList<SanPhamVM2> getListSP() {
        return spRepo.getAll();
    }
    
    @Override
    public boolean Add(SanPham s) {
        return spRepo.add(s);
    }
    
    @Override
    public boolean delete(String ma) {
        return spRepo.delete(ma);
    }
    
    @Override
    public boolean update(SanPham s, String ma) {
        return spRepo.update(s, ma);
    }
    
    @Override
    public ArrayList<SanPhamVM2> getOneSP(String ma) {
        return spRepo.getOneSP(ma);
    }

    @Override
    public void sortByNamr(ArrayList<SanPhamVM2> getSortByNameXe) {
  Collections.sort(getSortByNameXe,new Comparator<SanPhamVM2>(){
            @Override
            public int compare(SanPhamVM2 o1, SanPhamVM2 o2) {
                return o1.getTen().compareToIgnoreCase(o2.getTen());
            }            
        });
    }

    @Override
    public ArrayList<SanPhamVM2> getTenSP(String txt) {
   ArrayList<SanPhamVM2> list = new ArrayList<>();
   var listtim = spRepo.getTensp(txt);
   for(SanPhamVM2 x : listtim){
       list.add(new SanPhamVM2(x.getId(), x.getMa(), x.getTen(), x.getMauSac(), x.getGiaBan(), x.getNamSx(),x.getXuatXu(), x.getTrangThai()));
       
   }
   return list;
    }
    
}
