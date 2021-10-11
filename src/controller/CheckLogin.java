/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// check login
public class CheckLogin {
    
    // return id của Nhân Viên Đăng nhập
    public int staffLogin (String nameAcc, String passAcc) {
        try{
            Connection connection = ConnectDB.getConnection();
            PreparedStatement pst = connection.prepareStatement("select*from StaffLib where NameAcc=? and PassAcc =?");
            pst.setInt(1, Integer.parseInt(nameAcc));
            pst.setString(2, passAcc);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               int idStaff = rs.getInt("AccId");
               return idStaff;
            }
            connection.close();
        }catch(NumberFormatException | SQLException e){
            return 0;
        }
        return 0;
    }
    
    // return id của thủ thư Đăng nhập
    public int librarianLogin(String nameAcc, String passAcc) {
        try{
            Connection connection = ConnectDB.getConnection();
            PreparedStatement pst=connection.prepareStatement("select*from Librarian where NameAcc=? and PassAcc =?");
            pst.setInt(1, Integer.parseInt(nameAcc));
            pst.setString(2, passAcc);
            ResultSet rs=pst.executeQuery();

            if(rs.next()){
               int idLib = rs.getInt("AccId");
               return idLib;
            }
            connection.close();
        }catch(NumberFormatException | SQLException e){
            System.out.println(""+e);
            return 0;
        }
        return 0;
    }
    
    public boolean adminLogin(String nameAcc, String passAcc) {
        try{
            Connection connection = ConnectDB.getConnection();
            PreparedStatement pst = connection.prepareStatement("select*from Admin where AdminName=? and AdminPass =?");
            pst.setString(1, nameAcc);
            pst.setString(2, passAcc);
            ResultSet rs=pst.executeQuery();

            if(rs.next()){
               return true;
            }
            connection.close();
        }catch(NumberFormatException | SQLException e){
            System.out.println(""+e);
            return false;
        }
        return false;
    }
    
    // return id của Reader Đăng nhập
    public int readerLogin (String nameAcc, String passAcc) {
        try{
            Connection connection = ConnectDB.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from Reader where NameAcc=? and PassAcc =? and StatusReader=1");
            pst.setInt(1, Integer.parseInt(nameAcc));
            pst.setString(2, passAcc);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               int idReader = rs.getInt("AccId");
               return idReader;
            }
            connection.close();
        }catch(NumberFormatException | SQLException e){
            return 0;
        }
        return 0;
    }
    
    
}
