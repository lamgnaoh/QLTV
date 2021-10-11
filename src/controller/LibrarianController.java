/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.LibrarianModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Query DB thực hiện tìm , thêm , xóa Thủ thư
public class LibrarianController {
     public static List<LibrarianModel> findAll() {
        List<LibrarianModel> LibrarianList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "select * from Librarian";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                LibrarianModel std = new LibrarianModel( 
                        resultSet.getInt("AccID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                         resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                         resultSet.getString("PhoneNum")
                                
                        );
              LibrarianList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return LibrarianList;
    }
      
     public static void AddLibrarian(LibrarianModel std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "insert into Librarian( NameAcc, PassAcc,  NameUser, Email, PhoneNum) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, std.getNameAcc());
            statement.setString(2, std.getPassAcc());
            statement.setString(3, std.getNameUser());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNum());
           
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
     
       public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection = ConnectDB.getConnection();
            
            //query
            String sql = "delete from Librarian where NameAcc = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
}
