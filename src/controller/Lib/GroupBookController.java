/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Lib;

import controller.BookController;
import controller.ConnectDB;
import model.BookModel;
import model.GroupBookModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// thêm, tìm kiếm groupBook
public class GroupBookController {

    public List<GroupBookModel> findAll() {
        List<GroupBookModel> GroupBookList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from GroupBook";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                GroupBookModel std = new GroupBookModel(
                        resultSet.getInt("GroupBookID"),
                        resultSet.getString("GroupBookName")
                );
                GroupBookList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupBookController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GroupBookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GroupBookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return GroupBookList;
    }

    public int FindGroupBookID(String GroupBookName) {
        int GroupBookID = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select GroupBookID from GroupBook where GroupBookName like ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, GroupBookName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GroupBookID = resultSet.getInt("GroupBookID");
                break;
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
        return GroupBookID;
    }

    public String FindGroupBookName(int GroupBookID) {
        String GroupBookName = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select GroupBookName from GroupBook where GroupBookID =?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, GroupBookID);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GroupBookName = resultSet.getString("GroupBookName");
                break;
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
        return GroupBookName;
    }

    public List<BookModel> findByGroupBook(int GroupBookID) {
        List<BookModel> BookList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Book  where GroupBookID = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, GroupBookID);
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

    public boolean addGrb(String groupBookString) {
        try {
            Connection connection = ConnectDB.getConnection();

            String sql = "Insert into GroupBook(GroupBookName) values(?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, groupBookString);
            pst.execute();

            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
}
