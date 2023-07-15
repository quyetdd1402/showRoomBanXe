/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.ArrayList;
 
import com.raven.repository.HoaDonRepository11;
import com.raven.service.HoaDonService11;
import com.raven.viewmodel.HoaDonViewModel;
 

/**
 *
 * @author ADMIN
 */
public class HoaDonImpl11 implements HoaDonService11 {

    private HoaDonRepository11 HDrepo = new HoaDonRepository11();

    @Override
    public ArrayList<HoaDonViewModel> getListHoaDon() {
        return (ArrayList<HoaDonViewModel>) HDrepo.getAll();
    }

    @Override
    public Boolean saveHoaDon(HoaDonViewModel hoaDon) {
        return HDrepo.saveHoaDon(hoaDon);
    }

    @Override
    public boolean update(HoaDonViewModel hoaDon, String ma) {
       return HDrepo.Update(hoaDon, ma) ;
           
        
    }

    @Override
    public ArrayList<HoaDonViewModel> getOneHD(String ma) {
      return (ArrayList<HoaDonViewModel>) HDrepo.getOneHD(ma);
    }

}
