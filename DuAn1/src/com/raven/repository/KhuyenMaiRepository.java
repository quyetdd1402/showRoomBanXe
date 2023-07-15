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
import com.raven.model.KhuyenMai;
import com.raven.uitlities.DBConnect;
import com.raven.viewmodel.MaKhuyenMaiVM;
 

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> getAll() {
        String query = "SELECT id,ma,ten,giamGia,ngayBD,ngayKT,trangThai FROM KHUYENMAI";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhuyenMai> listkm = new ArrayList<>();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString("id"), rs.getString("ma"), rs.getString("ten"), rs.getString("giamGia"), rs.getString("ngayBD"), rs.getString("ngayKT"), rs.getInt("trangThai"));
                listkm.add(km);
            }
            rs.close();
            return listkm;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<KhuyenMai> getTrangThai() {
        String query = "SELECT trangThai FROM KHUYENMAI";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhuyenMai> listkm = new ArrayList<>();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt("trangThai"));
                listkm.add(km);
            }
            rs.close();
            return listkm;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<KhuyenMai> getOne(String maNv) {
        String query = "SELECT * FROM KHUYENMAI WHERE ma = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<KhuyenMai> listnv = new ArrayList<>();
            ps.setObject(1, maNv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai nv = new KhuyenMai(rs.getString("id"), rs.getString("ma"), rs.getString("ten"), rs.getString("giamGia"), rs.getString("ngayBD"), rs.getString("ngayKT"), rs.getInt("trangThai"));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(KhuyenMai km) {
        String query = "INSERT INTO KHUYENMAI (ma,ten,giamGia,ngayBD,ngayKT,trangThai) values(?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, km.getMa());
            ps.setString(2, km.getTen());
            ps.setString(3, km.getGiamGia());
            ps.setString(4, km.getNgayBD());
            ps.setString(5, km.getNgayKT());
            ps.setInt(6, km.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE  FROM KHUYENMAI  WHERE ma = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean update(KhuyenMai km, String ma) {
        String query = "UPDATE KHUYENMAI set ma=?, ten=?, giamGia = ?,ngayBD = ?, ngayKT = ?, trangThai = ?"
                + " WHERE id = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, km.getMa());
            ps.setString(2, km.getTen());
            ps.setString(3, km.getGiamGia());
            ps.setString(4, km.getNgayBD());
            ps.setString(5, km.getNgayKT());
            ps.setInt(6, km.getTrangThai());
            ps.setString(7, ma);

            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     public List<MaKhuyenMaiVM> getKM() throws Exception{
        String query = "SELECT ten FROM [dbo].[KHUYENMAI]";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<MaKhuyenMaiVM> listMNV = new ArrayList<>();
            while (rs.next()) {
                MaKhuyenMaiVM mnv = new MaKhuyenMaiVM(rs.getString(1));
                listMNV.add(mnv);
            }
            return listMNV;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
                System.out.println(new KhuyenMaiRepository().getOne("ma1"));
    }

   
}
