
package com.raven.service;

import com.raven.model.SanPham;
import com.raven.viewmodel.SanPhamVM;
import java.util.ArrayList;

public interface SanPhamService {
      public ArrayList<SanPhamVM> getListSP();
  
    public SanPhamVM getOneSP(String ma);

    public boolean Add(SanPham s);

    public boolean delete(String ma);

    public boolean update(SanPham s, String ma);
}
