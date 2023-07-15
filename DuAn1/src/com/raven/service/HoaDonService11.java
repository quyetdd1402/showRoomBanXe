/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import java.util.ArrayList;
 
import com.raven.viewmodel.HoaDonViewModel;

/**
 *
 * @author ADMIN
 */
public interface HoaDonService11 {
    Boolean saveHoaDon(HoaDonViewModel hoaDon);
    public ArrayList<HoaDonViewModel> getListHoaDon();
    public ArrayList<HoaDonViewModel> getOneHD(String ma);
    boolean update(HoaDonViewModel hoaDon, String ma);
    
    
}
