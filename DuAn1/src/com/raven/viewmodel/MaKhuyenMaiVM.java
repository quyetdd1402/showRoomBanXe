/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.viewmodel;

/**
 *
 * @author pc
 */
public class MaKhuyenMaiVM {
    public String maKM;

    public MaKhuyenMaiVM() {
    }

    public MaKhuyenMaiVM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    @Override
    public String toString() {
        return  maKM ;
    }
    
    
    
}
