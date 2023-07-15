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
import com.raven.model.HoaDon;
import com.raven.uitlities.DBConnect;

/**
 *
 * @author vha74
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "select maHD,tenXe,tenNV,tenKH,ngayTao,ngayThanhToan,khachTra,tongTien,soTienGiam,SĐTnguoiNhan,dichvu.baoHiem,dichvu.lamBien,trangThai,note from hoaDon join DichVu on hoaDon.id= dichVu.idHoaDon";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listhd = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getInt(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14));
                listhd.add(hd);
            }
            return listhd;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> sum() {
        String query = "SELECT COUNT(trangThai)\n"
                + "  FROM HOADON WHERE trangThai = 0";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listhd = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1));
                listhd.add(hd);
            }
            return listhd;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getOneSP(String ma) {
        String query = "select maHD,tenXe,tenNV,tenKH,ngayTao,ngayThanhToan,khachTra,tongTien,soTienGiam,SĐTnguoiNhan,dichvu.baoHiem,dichvu.lamBien,trangThai,note from hoaDon join DichVu on hoaDon.id= dichVu.idHoaDon where mahd=?";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getLong(7), rs.getInt(8), rs.getInt(9),
                        rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14));
                listHD.add(hd);
            }
            return listHD;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(String ma, HoaDon spct) {
        String query = "update DICHVU set baoHiem=?,lamBien=? where idHoaDon=(select id from HOADON where maHD=?)\n"
                + " update HOADON set tenXe=?,tenNV=?,tenKH=?,ngayTao=?,ngayThanhToan=?,khachTra=?,tongTien=?,soTienGiam=?,SĐTNguoiNhan=?,trangThai=?,note=?,maHD=? where maHD=? ";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, spct.getBaoHiem());
            ps.setInt(2, spct.getLamBien());
            ps.setString(3, ma);
            ps.setString(4, spct.getTenXe());
            ps.setString(5, spct.getTenNV());
            ps.setString(6, spct.getTenKH());
            ps.setString(7, spct.getNgayTao());
            ps.setString(8, spct.getNgayThanhToan());
            ps.setLong(9, spct.getKhachTra());
            ps.setLong(10, spct.getTongTien());
            ps.setInt(11, spct.getSoTienGiam());
            ps.setString(12, spct.getSdtNguoiNhan());
            ps.setInt(13, spct.getTrangThai());
            ps.setString(14, spct.getNote());
            ps.setString(15, spct.getMaHD());
            ps.setString(16, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String ma) {
        String query = "delete from DICHVU where idHoaDon=(select id from HOADON where ma=?)\n"
                + "delete from HOADON where ma=? ";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        List<HoaDon> lisst = new HoaDonRepository().sum();
        for (HoaDon x : lisst) {
            System.out.println(x.toString());
        }
    }
}
