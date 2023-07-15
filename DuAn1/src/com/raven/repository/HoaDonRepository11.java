/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.uitlities.DBConnect;
import com.sun.jdi.connect.spi.Connection;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.raven.viewmodel.HoaDonViewModel;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepository11 {

    public List<HoaDonViewModel> getAll() {
        String query = "SELECT [maNV]\n"
                + "      ,[tenNV]\n"
                + "      ,[maHD]\n"
                + "      ,[maSp]\n"
                + "      ,[tenXe]\n"
                + "      ,[soLuong]\n"
                + "      ,[donGia]\n"
                + "      ,[tenKH]\n"
                + "      ,[soTienGiam]\n"
                + "      ,[tongTien]\n"
                + "      ,[khachTra]\n"
                + "      ,[ngayTao]\n"
                + "      ,[ngayThanhToan]\n"
                + "      ,[mauSac]\n"
                + "      ,[xuatXu]\n"
                + "      ,[SĐTNguoiNhan]\n"
                + "      ,[diaChi]\n"
                + "      ,[trangThai]\n"
                + "      ,[note]\n"
                + "  FROM [dbo].[HOADON]";
        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHoaDon = new ArrayList<>();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBigDecimal(7), rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getDouble(11), rs.getDate(12), rs.getDate(13),rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18), rs.getString(19));
                listHoaDon.add(hd);
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;

    }

    public List<HoaDonViewModel> getOneHD(String ma) {
        String query = "SELECT [maNV]\n"
                + "      ,[tenNV]\n"
                + "      ,[maHD]\n"
                + "      ,[maSp]\n"
                + "      ,[tenXe]\n"
                + "      ,[soLuong]\n"
                + "      ,[donGia]\n"
                + "      ,[tenKH]\n"
                + "      ,[soTienGiam]\n"
                + "      ,[tongTien]\n"
                + "      ,[khachTra]\n"
                + "      ,[ngayTao]\n"
                + "      ,[ngayThanhToan]\n"
                + "      ,[mauSac]\n"
                + "      ,[xuatXu]\n"
                + "      ,[SĐTNguoiNhan]\n"
                + "      ,[diaChi]\n"
                + "      ,[trangThai]\n"
                + "      ,[note]\n"
                + "  FROM [dbo].[HOADON] where maHD = ?";
        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHoaDon = new ArrayList<>();
            while (rs.next()) {

                  HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBigDecimal(7), rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getDouble(11), rs.getDate(12), rs.getDate(13),rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18), rs.getString(19));
                listHoaDon.add(hd);
                return listHoaDon;
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;

    }

    public boolean saveHoaDon(HoaDonViewModel hoaDon) {
        String query = "INSERT INTO [dbo].[HOADON] (maSP, tenXe, donGia, soLuong, ngayTao, trangThai, maHD, maNV,tenNV,tenKH,soTienGiam,mauSac,xuatXu ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getMaXe());
            ps.setObject(2, hoaDon.getTenXe());
            ps.setObject(3, hoaDon.getDonGia());
            ps.setObject(4, hoaDon.getSoLuong());
            ps.setObject(5, hoaDon.getNgayTaoHoaDon());
            ps.setObject(6, 1);
            ps.setObject(7, hoaDon.getMaHD());
            ps.setObject(8, hoaDon.getMaNV());
            ps.setObject(9, hoaDon.getTenNV());
            ps.setObject(10, hoaDon.getTenKH());
            ps.setObject(11, hoaDon.getSoTienGiam());
            ps.setObject(12, hoaDon.getMauSac());
            ps.setObject(13, hoaDon.getXuatXu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(HoaDonViewModel hoaDon, String ma) {
        String query = "UPDATE HOADON set trangThai=?,note =?,ngayThanhToan=?,khachTra=?,soTienGiam=?,tongTien=?,tenNV=?,maNV=? WHERE maHD=?";
        int check = 0;
        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getTrangThai());
            ps.setObject(2, hoaDon.getGhiChu());
            ps.setObject(3, hoaDon.getNgayThanhToan());
            ps.setObject(4, hoaDon.getKhachTra());
            ps.setObject(5, hoaDon.getSoTienGiam());
            ps.setObject(6, hoaDon.getThanhTien());
            ps.setObject(7, hoaDon.getTenNV());
            ps.setObject(8, hoaDon.getMaNV());

            
            ps.setObject(9, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return check > 0;

    }
//    public Boolean UpdateThanhTien(HoaDonViewModel hoaDon,String newPrice) throws SQLException {
//        String query = "ALTER TABLE HOADON ADD tongTien ?";
//        int check = 0;
//        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1,hoaDon.getThanhTien());
//            ps.setObject(2, newPrice);
//            check = ps.executeUpdate();
//        }catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return check >0;
//        
//    }

//    public static void main(String[] args) {
//        new HoaDonRepository11().Update(new HoaDonViewModel("maNV5", "Minh Văn Hà", BigDecimal.valueOf(309960), BigDecimal.valueOf(40000), 30996, new Date(), 1, "Không"), "HD06");
//        
//    }
  
}
