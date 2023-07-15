/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.raven.model.KhachHang;
import com.raven.uitlities.DBConnect;
 

/**
 *
 * @author FPTSHOP
 */
public class KhachHangRepository {

    public List<KhachHang> getAll() {
        String query = "Select *from KHACHHANG";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> listkh = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                listkh.add(kh);
            }
            return listkh;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhachHang> getOne(String maKh) {
        String query = "SELECT [id]\n"
                + "      ,[maKH]\n"
                + "      ,[hoTenKH]\n"
                + "      ,[ngaySinh]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[SĐT]\n"
                + "      ,[diaChi]\n"
                + "      ,[quocGia]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[KHACHHANG]where maKH = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {      
            List<KhachHang> listkh = new ArrayList<>();         
            ps.setObject(1, maKh); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KHACHHANG]\n"
                + "           ([maKH]\n"
                + "           ,[hoTenKH]\n"
                + "           ,[ngaySinh]\n"
                + "           ,[gioiTinh]\n"
                + "           ,[SĐT]\n"
                + "           ,[diaChi]\n"
                + "           ,[quocGia]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kh.getMaKh());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.isGioiTinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(7, kh.getQuocGia());
            ps.setObject(8, kh.getTrangThai());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maKh) {
        String query = "DELETE FROM [dbo].[KHACHHANG]\n"
                + "      WHERE makh = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKh);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhachHang kh, String makh) {
        String query = "UPDATE [dbo].[KHACHHANG]\n"
                + "   SET [maKH] = ?\n"
                + "      ,[hoTenKH] = ? \n"
                + "      ,[ngaySinh] = ?\n"
                + "      ,[gioiTinh] = ?\n"
                + "      ,[SĐT] = ?\n"
                + "      ,[diaChi] = ?\n"
                + "      ,[quocGia] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE maKH=?";

        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMaKh());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.isGioiTinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(7, kh.getQuocGia());
            ps.setObject(8, kh.getTrangThai());
            ps.setObject(9, makh);

            check = ps.executeUpdate();

        } catch (Exception e) {
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<KhachHang> lisst = new KhachHangRepository().getAll();
//        for (KhachHang x : lisst) {
//            System.out.println(x.toString());
//        }
//        MauSac ms = new MauSac("maMs3", "Ten2");
//        System.out.println(new MauSacRepository().add(ms));
//        System.out.println(new KhachHangRepository().update(new KhachHang("maKH3", "NGu", "2003-11-09", true, "0984225285", "Phú Thọ", "Việt nam", 1), "maKH2"));
//          System.out.println(new KhachHangRepository().getOne("maKH1"));  
//        System.out.println(new KhachHangRepository().getOne("maKH2"));
//        System.out.println(new KhachHangRepository().delete("maKH2"));
    }

}
