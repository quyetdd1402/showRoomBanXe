/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import com.raven.model.TaiKhoan;
import com.raven.repository.TaiKhoanRepository;
import com.raven.service.TaiKhoanService;
 
import java.util.List;
 

/**
 *
 * @author pc
 */
public class TaiKhoanimpl implements TaiKhoanService{
    private TaiKhoanRepository tkr = new TaiKhoanRepository();

    @Override
    public List<TaiKhoan> getAll() {
       return tkr.getAll();
    }

    @Override
    public String Add(TaiKhoan tk) {
        boolean add = tkr.add(tk);
        if(add){
            return "Add thành công";
        }else{
            return "Add lỗi";
        }
    }

    @Override
    public String delete(String username,String password) {
 boolean delete = tkr.delete(username, password);
        if(delete){
            return "delete thành công";
        }else{
            return "delete lỗi";
        }    }

    @Override
    public String update(TaiKhoan tk, String username,String password) {
 boolean update = tkr.update(tk, username, password);
        if(update){
            return "update thành công";
        }else{
            return "update lỗi";
        }
    }

    @Override
    public TaiKhoan getOne(String username,String password) {
        return tkr.getOne(username, password);
    }

    @Override
    public void exit() {
System.exit(0);    }
    
}
