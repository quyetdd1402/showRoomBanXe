/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.raven.model.NhanVien;
import com.raven.uitlities.DBConnect;
 

/**
 *
 * @author PH22349
 */
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[maNV]\n"
                + "      ,[hoTenNv]\n"
                + "      ,[vaiTro]\n"
                + "      ,[ngaySinh]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[SĐT]\n"
                + "      ,[email]\n"
                + "      ,[diaChi]\n"
                + "      ,[anh]\n"
                + "      ,[luong]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[NHANVIEN]";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NhanVien> listNv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
                listNv.add(nv);
            }
            return listNv;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhanVien nv) {
        String query = "INSERT INTO [dbo].[NHANVIEN]\n"
                + "           ([maNV]\n"
                + "           ,[hoTenNv]\n"
                + "           ,[vaiTro]\n"
                + "           ,[ngaySinh]\n"
                + "           ,[gioiTinh]\n"
                + "           ,[SĐT]\n"
                + "           ,[email]\n"
                + "           ,[diaChi]\n"
                + "           ,[anh]\n"
                + "           ,[luong]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getVaiTro());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.isGioiTinh());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getAnh());
            ps.setObject(10, nv.getLuong());
            ps.setObject(11, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<NhanVien> getOne(String maNv) {
        String query = "SELECT [id]\n"
                + "      ,[maNV]\n"
                + "      ,[hoTenNv]\n"
                + "      ,[vaiTro]\n"
                + "      ,[ngaySinh]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[SĐT]\n"
                + "      ,[email]\n"
                + "      ,[diaChi]\n"
                + "      ,[anh]\n"
                + "      ,[luong]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[NHANVIEN] WHERE maNV = ? ";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<NhanVien> listnv = new ArrayList<>();
            ps.setObject(1, maNv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean delete(String maNv) {
        String query = "DELETE FROM [dbo].[NHANVIEN]\n"
                + "      WHERE maNV = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNv);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVien nv, String maNv) {
        String query = "UPDATE [dbo].[NHANVIEN]\n"
                + "   SET [maNV] = ?\n"
                + "      ,[hoTenNv] = ?\n"
                + "      ,[vaiTro] = ?\n"
                + "      ,[ngaySinh] = ?\n"
                + "      ,[gioiTinh] = ?\n"
                + "      ,[SĐT] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[diaChi] = ?\n"
                + "      ,[anh] = ?\n"
                + "      ,[luong] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE id = ?";

        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getVaiTro());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.isGioiTinh());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getAnh());
            ps.setObject(10, nv.getLuong());
            ps.setObject(11, nv.getTrangThai());
            ps.setObject(12, maNv);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    


    public static void main(String[] args) {
//        List<NhanVien> lisst = new NhanVienRepository().getAll();
//        for (NhanVien x : lisst) {
//            System.out.println(x.toString());
//        }
//        NhanVien ms = new NhanVien("MaNv2", "Duy Phạm", "Nhân Viên", "2022-01-01", true, "093837242", "duy@fpt", "Thái Bình", "1.jpg", "9", 0);
//        System.out.println(new NhanVienRepository().add(ms));
          System.out.println(new NhanVienRepository().update(new NhanVien("MaNv10", "Duy", 0, "2022-01-01", true, "093837242", "duy@fpt", "Thái Bình", "1.jpg", "9", 0), "fd6e04fe-5814-4b3b-aa41-00ce816f202f"));
//        System.out.println(new NhanVienRepository().getOne("maNv3"));
    }
}
