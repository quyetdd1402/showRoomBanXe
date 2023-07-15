package com.raven.service.impl;

import com.raven.model.SanPham;
import com.raven.repository.SanPhamRepository;
import com.raven.service.SanPhamService;
import com.raven.viewmodel.SanPhamVM;
import java.util.ArrayList;

public class SanPhamImpl implements SanPhamService {

    private SanPhamRepository spRepo = new SanPhamRepository();

    @Override
    public ArrayList<SanPhamVM> getListSP() {
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
    public SanPhamVM getOneSP(String ma) {
        return spRepo.getOneSP(ma);
    }

    SanPham getSPByName(String tenSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
