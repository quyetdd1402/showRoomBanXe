/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

 

/**
 *
 * @author pc
 */
public class TaiKhoan {

    private String ID;
    private String userName;
    private String password;
    private String email;
    private String comfirmPassword;
    private int vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String ID, String userName, String password, String email, String comfirmPassword, int vaiTro) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.comfirmPassword = comfirmPassword;
        this.vaiTro = vaiTro;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public Integer getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Integer vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "ID=" + ID + ", userName=" + userName + ", password=" + password + ", email=" + email + ", comfirmPassword=" + comfirmPassword + ", vaiTro=" + vaiTro + '}';
    }
    

    public Object[] toRowData() {
        return new Object[]{ID, userName, password, email,comfirmPassword, vaiTro == 0 ? "Quản lý":"Nhân Viên"};
    }

}
