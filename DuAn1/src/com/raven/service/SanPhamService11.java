package com.raven.service;

import com.raven.model.SanPham;
import java.util.ArrayList;
import java.util.List;
 
import com.raven.viewmodel.SanPhamVM2;
import com.raven.viewmodel.SanPhamVM2;

public interface SanPhamService11 {

    public ArrayList<SanPhamVM2> getListSP();
    
    void sortByNamr(ArrayList<SanPhamVM2> getSortByNameXe);
  
    public ArrayList<SanPhamVM2> getOneSP(String ma);
    
    public ArrayList<SanPhamVM2> getTenSP(String txt);

    public boolean Add(SanPham s);

    public boolean delete(String ma);

    public boolean update(SanPham s, String ma);
}
