package com.raven.repository;

import com.raven.model.SanPham;
import com.raven.uitlities.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Spring;

import com.raven.viewmodel.SanPhamVM2;
import java.math.BigDecimal;

public class SanPhamRepository11 {

    public ArrayList<SanPhamVM2> getAll() {
        String query = "SELECT        dbo.SANPHAM.ma, dbo.SANPHAM.ten, dbo.CHITIETSP.MauSac, dbo.CHITIETSP.PhanKhuc, dbo.CHITIETSP.ChoNgoi, dbo.CHITIETSP.DongCo, dbo.CHITIETSP.DongXe, dbo.CHITIETSP.HopSo, dbo.CHITIETSP.NhienLieu, \n"
                + "                         dbo.CHITIETSP.KieuDang, dbo.CHITIETSP.XuatXu, dbo.CHITIETSP.NamSX, dbo.CHITIETSP.GiaBan\n"
                + "FROM            dbo.CHITIETSP INNER JOIN\n"
                + "                         dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            ArrayList<SanPhamVM2> listms = new ArrayList<>();
            while (rs.next()) {
                SanPhamVM2 sp = new SanPhamVM2(rs.getString("ma"), rs.getString("ten"), rs.getString("MauSac"), rs.getString("PhanKhuc"), rs.getString("ChoNgoi"), rs.getString("DongCo"), rs.getString("DongXe"), rs.getString("HopSo"), rs.getString("NhienLieu"), rs.getString("KieuDang"), rs.getBigDecimal("GiaBan"), rs.getInt("NamSX"), rs.getString("XuatXu"));

                listms.add(sp);
            }
            return listms;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ArrayList<SanPhamVM2> getOneSP(String ma) {
        String query = "SELECT        dbo.CHITIETSP.id, dbo.SANPHAM.ma, dbo.SANPHAM.ten,dbo.CHITIETSP.MauSac, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.NamSX, dbo.CHITIETSP.XuatXu,  dbo.CHITIETSP.trangThai\n"
                + "FROM            dbo.CHITIETSP INNER JOIN\n"
                + "                         dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id where ten = ? ";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            ArrayList<SanPhamVM2> listsp = new ArrayList<>();
            while (rs.next()) {
                SanPhamVM2 sp = new SanPhamVM2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                listsp.add(sp);
                return listsp;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public boolean add(SanPham s) {
        String query = "INSERT INTO [dbo].[SANPHAM] ([ma], [ten], [anh]) VALUES(?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, s.getMa());
            ps.setObject(2, s.getTen());

            ps.setObject(3, s.getAnh());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SANPHAM]\n"
                + "      WHERE ma = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPham s, String ma) {
        String query = "UPDATE SANPHAM SET ten = ?, anh=? WHERE ma = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, s.getTen());

            ps.setObject(2, s.getAnh());
            ps.setObject(3, s.getMa());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public ArrayList<SanPhamVM2> getTensp(String txt) {
        String query = "SELECT        dbo.CHITIETSP.id, dbo.SANPHAM.ma, dbo.SANPHAM.ten,dbo.CHITIETSP.MauSac, dbo.CHITIETSP.GiaBan, dbo.CHITIETSP.NamSX, dbo.CHITIETSP.XuatXu,  dbo.CHITIETSP.trangThai\n"
                + "FROM            dbo.CHITIETSP INNER JOIN\n"
                + "                         dbo.SANPHAM ON dbo.CHITIETSP.idSP = dbo.SANPHAM.id where ten like N'%'+?+'%' ";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, txt);
            ResultSet rs = ps.executeQuery();
            ArrayList<SanPhamVM2> listsp = new ArrayList<>();
            while (rs.next()) {
                SanPhamVM2 sp = new SanPhamVM2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                listsp.add(sp);
            }
            return listsp;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public static void main(String[] args) {
//        ArrayList<SanPhamVM2> lisst = (ArrayList<SanPhamVM2>) new SanPhamRepository11().getOneSP("ma2");
////        for (SanPhamVM2 x : lisst) {
////            System.out.println(x.toString());
////        }

        System.out.println(new SanPhamRepository11().getTensp(""));

    }
}
