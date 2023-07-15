/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.ChiTietSP;
import com.raven.model.HoaDonCT;
import com.raven.viewmodel.User;
import java.util.List;
 

/**
 *
 * @author PH22349
 */
public interface UserService {
    List<User> getAll();
    List<ChiTietSP> sum();
    List<HoaDonCT> sum2();
    List<HoaDonCT> sum3();
    String update(User user, String name);
    boolean Add(User user);
}
