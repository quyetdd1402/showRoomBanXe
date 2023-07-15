/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.raven.model.HoaDonCT;
import com.raven.uitlities.DBConnect;


/**
 *
 * @author vha74
 */
public class HoaDonCTRepository {

    public List<HoaDonCT> getAll(String ma) {
        String query = "select masp,tensp,donGia,soLuong,tienThua,(donGia*soLuong-tienThua),trangThai from hoadonct where idHoaDon =(select id from HOADON where maHD =?)";
        try ( java.sql.Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<HoaDonCT> listtk = new ArrayList<>();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getInt(5), rs.getLong(6),rs.getInt(7));
                listtk.add(hdct);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<HoaDonCT> lisst = new HoaDonCTRepository().getAll("ma1");
        for (HoaDonCT x : lisst) {
            System.out.println(x.toString());
        }
    }

}
