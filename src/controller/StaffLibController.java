/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.StaffModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Query DB thực hiện tìm , thêm , xóa Nhân viên
public class StaffLibController {

    public List<StaffModel> findAll() {
        List<StaffModel> StaffLibList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from StaffLib";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                StaffModel std = new StaffModel(
                        resultSet.getInt("AccID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                        resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNum")
                );
                StaffLibList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return StaffLibList;
    }

    public boolean AddStaff(StaffModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            String sql = "insert into StaffLib( NameAcc, PassAcc,  NameUser, Email, PhoneNum) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, std.getNameAcc());
            statement.setString(2, std.getPassAcc());
            statement.setString(3, std.getNameUser());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNum());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StaffLibController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffLibController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffLibController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public String findNameStaffById(int idStaff1) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "select * from StaffLib where AccID = ?";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1,idStaff1);
            ResultSet resultSet = preparedStatement.executeQuery();
          String nameUser = "";
             while (resultSet.next()) {
                nameUser = resultSet.getString("NameUser");
                break;
            }
            connection.close();
            return nameUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "delete from StaffLib where NameAcc = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

}
