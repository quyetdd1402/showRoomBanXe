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
import com.raven.model.Login;
import com.raven.uitlities.DBConnect;
 

/**
 *
 * @author pc
 */
public class LoginRepository {
    public List<Login> getAll() {
        String query = "SELECT [userName]\n" +
"      ,[password]\n" +
"  FROM [dbo].[USERNAME]";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Login> listL = new ArrayList<>();
            while (rs.next()) {
                Login login = new Login(rs.getString(1), rs.getString(2));
                listL.add(login);
            }
            return listL;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Login getOne(String username, String password) {
        String query = "SELECT [userName]\n" +
"      ,[password]\n" +
"  FROM [dbo].[USERNAME]\n" +
"  where userName= ? and password = ?";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);){
           ps.setObject(1, username);
            ps.setObject(2, password);  
                ResultSet rs = ps.executeQuery(); 
          
             List<Login> listTK = new ArrayList<>();
            while (rs.next()) {
               Login loginn = new Login(rs.getString(1), rs.getString(2));
               return loginn;
            }
            

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//     public static void main(String[] args) {
//         System.out.println(new LoginRepository().getOne("a1", "1"));
//       
//}
}
