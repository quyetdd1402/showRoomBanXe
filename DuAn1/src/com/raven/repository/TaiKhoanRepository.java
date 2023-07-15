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
import com.raven.model.TaiKhoan;
import com.raven.uitlities.DBConnect;

/**
 *
 * @author pc
 */
public class TaiKhoanRepository {

    public List<TaiKhoan> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[userName]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[comfirmPassword]\n"
                + "      ,[vaiTro]\n"
                + "  FROM [dbo].[USERNAME]";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<TaiKhoan> listTK = new ArrayList<>();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                listTK.add(tk);
            }
            return listTK;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public TaiKhoan getOne(String username, String password) {
        String query = "SELECT [id]\n"
                + "      ,[userName]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[comfirmPassword]\n"
                + "      ,[vaiTro]\n"
                + "  FROM [dbo].[USERNAME]"
                + "  where [userName] = ? and [password] = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {
            List<TaiKhoan> listTK = new ArrayList<>();
            ps.setObject(1, username);
            ps.setObject(2, password);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                return tk;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(TaiKhoan tk) {
        String query = "INSERT INTO [dbo].[USERNAME]\n"
                + "           ([userName]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[comfirmPassword]\n"
                + "           ,[vaiTro])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tk.getUserName());
            ps.setObject(2, tk.getPassword());
            ps.setObject(3, tk.getEmail());
            ps.setObject(4, tk.getComfirmPassword());
            ps.setObject(5, tk.getVaiTro());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String username, String password) {
        String query = "DELETE FROM [dbo].[USERNAME]\n"
                + "      WHERE [userName] = ? and [password] = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, username);
            ps.setObject(2, password);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(TaiKhoan tk, String username, String password) {
        String query = "UPDATE [dbo].[USERNAME]\n"
                + "   SET [userName] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[comfirmPassword] = ?\n"
                + "      ,[vaiTro] = ?"
                + " where [userName] = ? and [password] = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, tk.getUserName());
            ps.setObject(2, tk.getPassword());
            ps.setObject(3, tk.getEmail());
            ps.setObject(4, tk.getComfirmPassword());
            ps.setObject(5, tk.getVaiTro());
            ps.setObject(6, username);
            ps.setObject(7, password);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<TaiKhoan> lisst = new TaiKhoanRepository().getAll();
//        for (TaiKhoan x : lisst) {
//            System.out.println(x.toString());
//        }
//        MauSac ms = new MauSac("maMs3", "Ten2");
//        System.out.println(new MauSacRepository().add(ms));
//        System.out.println(new MauSacRepository().update(new MauSac("maMs2", "Ten2"), "maMs2"));
    }
}
