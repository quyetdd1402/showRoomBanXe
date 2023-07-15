/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import com.raven.model.ChiTietSP;
import com.raven.model.HoaDonCT;
import com.raven.repository.UserReponsitory;
import com.raven.service.UserService;
import java.util.List;
 
import com.raven.viewmodel.User;
 
/**
 *
 * @author PH22349
 */
public class UserImpl implements UserService{
 
    UserReponsitory userRp = new UserReponsitory();
    
    @Override
    public List<User> getAll() {
        return userRp.getAll();
    }

    @Override
    public String update(User user, String name) {
                boolean update = userRp.update(user, name);
        if (update) {
            return "Đổi mật khẩu thành công";
        } else {
            return "Tài khoản không tồn tại";
        }
    }

    @Override
    public boolean Add(User user) {
        return userRp.add(user);
    }

    @Override
    public List<ChiTietSP> sum() {
        return userRp.sum();
    }

    @Override
    public List<HoaDonCT> sum2() {
        return userRp.sum2();
    }

    @Override
    public List<HoaDonCT> sum3() {
        return userRp.sum3();
    }

    
    
}
