/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Lib;

import controller.BookController;
import controller.ConnectDB;
import model.BookModel;
import model.CategoryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CategoryController {

    public List<CategoryModel> findAll() {
        List<CategoryModel> CategoryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Category";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                CategoryModel std = new CategoryModel(
                        resultSet.getInt("CateID"),
                        resultSet.getString("CateName")
                );
                CategoryList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return CategoryList;
    }

    public int CateID(String CateName) {
        int CateID = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select CateID from Category where CateName like ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, CateName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CateID = resultSet.getInt("CateID");
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return CateID;
    }

    public String CateName(int CateID) {
        String CateName = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select CateName from Category where CateID = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, CateID);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CateName = resultSet.getString("CateName");
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return CateName;
    }

    public List<BookModel> findByCate(int CateID) {
        List<BookModel> BookList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Book  where CateID = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, CateID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookModel std = new BookModel(resultSet.getInt("Date"),
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
            if (statement != null) {
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
    
    public boolean addCategory(String nameCategory) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "Insert into Category(CateName) values(?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nameCategory);
            pst.execute();

            pst.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
