/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import com.raven.model.ThongKe;
import com.raven.model.ThongKeDoanhThu;
 
import com.raven.repository.ThongKeRepository;
import com.raven.service.ThongKeService;
import com.raven.service.ThongKeService;
import java.util.List;


/**
 *
 * @author vha74
 */
public class ThongKeImpl implements ThongKeService {

    private ThongKeRepository thongkeRp = new ThongKeRepository();

    @Override
    public List<ThongKe> getAll() {
        return thongkeRp.getAll();
    }

    @Override
    public List<ThongKeDoanhThu> getAllThoiGian() {
        return thongkeRp.getAllThoiGian();
    }

    public List<ThongKeDoanhThu> getAllThoiGian(String ngayBatDau, String ngạyKetThuc) {
        return thongkeRp.sreachThoiGian(ngayBatDau, ngạyKetThuc);
    }

    public List<ThongKeDoanhThu> namTK() {
        return thongkeRp.namTK();
    }

    @Override
    public ThongKeDoanhThu getDoanhThuNam(String nam) {
        return thongkeRp.getDoanhThuNam(nam);
    }

     

}
