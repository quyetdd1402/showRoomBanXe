/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import com.raven.model.Login;
import com.raven.repository.LoginRepository;
import com.raven.service.LoginService;
import java.util.List;
 

/**
 *
 * @author pc
 */
public class LoginImpl implements LoginService{
    private LoginRepository lr = new LoginRepository();

    @Override
    public List<Login> getAll() {
        return lr.getAll() ;
    }

    @Override
    public Login getOne( String username, String password) {
        return lr.getOne(username, password);
    }
    
}
