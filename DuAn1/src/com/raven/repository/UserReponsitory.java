/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.model.ChiTietSP;
import com.raven.model.HoaDonCT;
import com.raven.uitlities.DBConnect;
import com.raven.viewmodel.User;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PH22349
 */
public class UserReponsitory {

    public List<User> getAll() {
        String query = "SELECT [userName]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "  FROM [dbo].[USERNAME]";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<User> listUser = new ArrayList<>();
            while (rs.next()) {
                User nv = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                listUser.add(nv);
            }
            return listUser;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<ChiTietSP> sum(){
        String query = "SELECT sum(SoLuongTon) FROM CHITIETSP ";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
           List<ChiTietSP> listnv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSP ct = new ChiTietSP(rs.getInt(1));
                listnv.add(ct);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<HoaDonCT> sum2(){
        String query = "SELECT SUM(donGia*soLuong-tienThua) FROM HOADONCT";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
           List<HoaDonCT> listnv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT ct = new HoaDonCT(rs.getLong(1));
                listnv.add(ct);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<HoaDonCT> sum3(){
        String query = "SELECT SUM(soLuong) FROM HOADONCT";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
           List<HoaDonCT> listnv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT ct = new HoaDonCT(rs.getInt(1));
                listnv.add(ct);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(User user) {
        String query = "INSERT INTO [dbo].[USERNAME]\n"
                + "           ([userName]\n"
                + "           ,[password])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, user.getUsername());
            ps.setObject(2, user.getPassword());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(User use, String name) {
        String query = "UPDATE [dbo].[USERNAME]\n"
                + "   SET [userName] = ?\n"
                + "      ,[password] = ?\n"
                + " WHERE userName = ?";

        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, use.getUsername());
            ps.setObject(2, use.getPassword());
            ps.setObject(3, name);

            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDonCT> lisst = new UserReponsitory().sum3();
        for (HoaDonCT x : lisst) {
            System.out.println(x.to());
        }
    }
}
