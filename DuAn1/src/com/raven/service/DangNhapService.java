/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.Login;
import java.util.List;
 

/**
 *
 * @author pc
 */
public interface DangNhapService {
    void exit();
    
    List<Login> getAll();
}
