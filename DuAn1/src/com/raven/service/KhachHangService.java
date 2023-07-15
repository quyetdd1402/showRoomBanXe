/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import java.util.List;

import com.raven.model.KhachHang;

/**
 *
 * @author FPTSHOP
 */
public interface KhachHangService {
    List<KhachHang> getAll();

    boolean Add(KhachHang kh);

    String delete(String makh);

    String update(KhachHang kh, String makh);

    List<KhachHang> getOne(String makh);
    
}
