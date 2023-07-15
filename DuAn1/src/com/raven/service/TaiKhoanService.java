/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.TaiKhoan;
import java.util.List;
 

/**
 *
 * @author pc
 */
public interface TaiKhoanService {
    List<TaiKhoan> getAll();

    String Add(TaiKhoan tk);

    String delete(String username,String password);

    String update(TaiKhoan tk, String username,String password);

    TaiKhoan getOne(String username,String password);
    void exit();
    
}
