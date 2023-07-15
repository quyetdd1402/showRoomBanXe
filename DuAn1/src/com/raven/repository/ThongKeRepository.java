/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.model.ThongKe;
import com.raven.model.ThongKe;
import com.raven.model.ThongKeDoanhThu;
import com.raven.model.ThongKeDoanhThu;
import com.raven.uitlities.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vha74
 */
public class ThongKeRepository {

    public List<ThongKe> getAll() {
        String query = "select a.ma, a.ten, b.NamSX,b.SoLuongTon,b.GiaBan, c.soLuong  from SANPHAM a join  CHITIETSP b on a.id = b.idSP join HOADONCT c on b.id = c.idCTSanPham";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKe> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getLong(5), rs.getInt(6));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> getAllThoiGian() {
        String query = "select ngayThanhToan,sum(tongTien-soTienGiam),count(id) from HOADON where trangThai=1 group by ngayThanhToan";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getString(1), rs.getLong(2), rs.getInt(3));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> sreachThoiGian(String ngayBatDau, String ngayKetThuc) {
        String query = "select ngayThanhToan,sum(tongTien-soTienGiam),count(id) from HOADON where trangThai=1 and ?<=ngayThanhToan and ngayThanhToan<=? group by ngayThanhToan";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getString(1), rs.getInt(2), rs.getInt(3));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> namTK() {
        String query = "select year(ngaythanhtoan) from HOADON group by year(ngayThanhToan)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getInt(1));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ThongKeDoanhThu getDoanhThuNam(String nam) {
        String query = "select year(ngaythanhtoan) ,sum(tongTien-soTienGiam) ,sum(tongTien-soTienGiam)/12 ,"
                + "(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) desc ) "
                + ",(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) asc ) "
                + ",(select top 1 sum(tongTien-soTienGiam) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) asc )"
                + ",(select top 1 sum(tongTien-soTienGiam) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien-soTienGiam) desc )"
                + " from HOADON where year(ngaythanhtoan) =? group by year(ngayThanhToan)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nam);
            ps.setObject(2, nam);
            ps.setObject(3, nam);
            ps.setObject(4, nam);
            ps.setObject(5, nam);
            ResultSet rs = ps.executeQuery();
            ThongKeDoanhThu listtk = new ThongKeDoanhThu();
            while (rs.next()) {
                listtk = new ThongKeDoanhThu(rs.getLong(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getLong(7), rs.getLong(6), rs.getInt(1));
               
            }
            return listtk ;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<ThongKe> lisst = new ThongKeRepository().getAll();
        for (ThongKe x : lisst) {
            System.out.println(x.toString());
        }
    }
}
