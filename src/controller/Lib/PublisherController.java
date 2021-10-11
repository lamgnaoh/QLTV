/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Lib;
import controller.BookController;
import controller.ConnectDB;
import model.BookModel;
import model.PublisherModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PublisherController {
        public List<PublisherModel> findAll() {
        List<PublisherModel> PublisherList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "select * from Publisher";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                PublisherModel std = new PublisherModel( 
                        resultSet.getInt("PubID"),
                        resultSet.getString("PubName")
                        );
              PublisherList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return PublisherList;
    }
        
    public boolean addPub(String pub) {
        try{
            Connection connection = ConnectDB.getConnection();
            String sql="Insert into Publisher(PubName) values(?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,pub);
            pst.execute();
            return true;
            
         }catch(SQLException e){
             return false;
         }
    }
    public int  PubID(String PubName) {
        int PubID=0;
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection = ConnectDB.getConnection();
            
            //query
            String sql = "select PubID from Publisher where PubName like ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, PubName);
            
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {                
               PubID=resultSet.getInt("PubID");
               break;
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return PubID;
    }
    
     public String  PubName(int PubID) {
        String PubName="";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection = ConnectDB.getConnection();
            
            //query
            String sql = "select PubName from Publisher where PubID = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, PubID);
            
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {                
               PubName=resultSet.getString("PubName");
               break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PublisherController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return PubName;
    }
     
     public List<BookModel> findByPub(int PubID) {
        List<BookModel> BookList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "select * from Book  where PubID = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1,PubID);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
               BookModel std = new BookModel( resultSet.getInt("Date"),
                        resultSet.getInt("Count"),
                        resultSet.getInt("BookID"),
                        resultSet.getInt("GroupBookID"), 
                        resultSet.getInt("PubID"),
                        resultSet.getInt("CateID"),
                         resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                       resultSet.getInt("MaxNum")   
                        );
              BookList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return BookList;
    }
}
