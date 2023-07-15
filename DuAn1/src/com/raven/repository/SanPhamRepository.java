
package com.raven.repository;

import com.raven.model.SanPham;
import com.raven.uitlities.DBConnect;
import com.raven.viewmodel.SanPhamVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPhamVM> getAll() {
        String query = "SELECT * FROM SANPHAM ";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            ArrayList<SanPhamVM> listms = new ArrayList<>();
            while (rs.next()) {
                SanPhamVM sp = new SanPhamVM(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listms.add(sp);
            }
            return listms;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public SanPhamVM getOneSP(String ma) {
        String query = "SELECT * FROM SANPHAM  WHERE id = ?";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            ArrayList<SanPhamVM> listsp = new ArrayList<>();
            while (rs.next()) {
               SanPhamVM sp = new SanPhamVM(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listsp.add(sp);
            }
            return null;

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
}
