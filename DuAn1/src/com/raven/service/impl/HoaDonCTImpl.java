/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.List;
import com.raven.model.HoaDonCT;
import com.raven.repository.HoaDonCTRepository;
import com.raven.service.HoaDonCTService;

/**
 *
 * @author vha74
 */
public class HoaDonCTImpl implements HoaDonCTService {

    HoaDonCTRepository hdctRepo = new HoaDonCTRepository();

    @Override
    public List<HoaDonCT> getAll(String ma) {
        return hdctRepo.getAll(ma);

    }

}
