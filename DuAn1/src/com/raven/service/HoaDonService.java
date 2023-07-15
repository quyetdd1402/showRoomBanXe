/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import java.util.List;
import com.raven.model.HoaDon;

/**
 *
 * @author vha74
 */
public interface HoaDonService {

    List<HoaDon> getAll();
    
    List<HoaDon> sum();

    public List<HoaDon> getOneSP(String ma);

    public boolean update(String ma, HoaDon hd);

    public boolean delete(String id);

}
