/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.ThongKe;
import com.raven.model.ThongKeDoanhThu;
import java.util.List;

/**
 *
 * @author vha74
 */
public interface ThongKeService {

    List<ThongKe> getAll();

    List<ThongKeDoanhThu> getAllThoiGian();

    List<ThongKeDoanhThu> getAllThoiGian(String ngayBatDau, String ngạyKetThuc);

    List<ThongKeDoanhThu> namTK();

    ThongKeDoanhThu getDoanhThuNam(String nam);
}
