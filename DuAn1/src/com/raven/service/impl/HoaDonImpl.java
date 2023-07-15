/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.List;
import com.raven.model.HoaDon;
import com.raven.repository.HoaDonRepository;
import com.raven.service.HoaDonService;

/**
 *
 * @author vha74
 */
public class HoaDonImpl implements HoaDonService {

    private HoaDonRepository hdRepo = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hdRepo.getAll();
    }

    @Override
    public boolean update(String ma, HoaDon hd) {
        return hdRepo.update(ma, hd);
    }

    @Override
    public boolean delete(String ma) {
        return hdRepo.delete(ma);
    }

    @Override
    public List<HoaDon> getOneSP(String ma) {
        return hdRepo.getOneSP(ma);
    }

    @Override
    public List<HoaDon> sum() {
        return hdRepo.sum();
    }

}
