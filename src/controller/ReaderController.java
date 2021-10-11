/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ReaderModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// tim kiem, them, sua , xoa reader 
public class ReaderController {

    public List<ReaderModel> findAll() {
        List<ReaderModel> ReaderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Reader";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ReaderModel std = new ReaderModel(
                        resultSet.getInt("ReaderID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                        resultSet.getInt("MaxBook"),
                        resultSet.getInt("BookBorrow"),
                        resultSet.getDate("DateReader"),
                        resultSet.getInt("StatusReader"),
                        resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNum"),
                        resultSet.getInt("Remain")
                );
                ReaderList.add(std);
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

        return ReaderList;
    }

    public void addReader(ReaderModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "insert into Reader(NameAcc,PassAcc,NameUser,Email,PhoneNum,MaxBook,BookBorrow,DateReader,StatusReader,Remain) values(?, ?, ?, ?, ?,?,?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, std.getNameAcc());
            statement.setString(2, std.getPassAcc());
            statement.setString(3, std.getNameUser());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNum());
            statement.setInt(6, std.getMaxBook());
            statement.setInt(7, std.getBookBorrow());
            statement.setDate(8, (Date) std.getDateReader());
            statement.setInt(9, std.getStatusReader());
            statement.setInt(10, std.getRemain());
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

    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "delete from Reader where NameAcc = ?";
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

    public List<ReaderModel> findReaderID(int ReaderID) {
        List<ReaderModel> ReaderList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Reader where NameAcc= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, ReaderID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReaderModel std = new ReaderModel(
                        resultSet.getInt("ReaderID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                        resultSet.getInt("MaxBook"),
                        resultSet.getInt("BookBorrow"),
                        resultSet.getDate("DateReader"),
                        resultSet.getInt("StatusReader"),
                        resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNum"),
                        resultSet.getInt("Remain")
                );
                ReaderList.add(std);
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

        return ReaderList;
    }

    public void Update(ReaderModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "Update  Reader set PassAcc=?,NameUser=?,Email=?,PhoneNum=?,StatusReader=? where ReaderID=?  ";
            statement = connection.prepareCall(sql);

            // statement.setInt(1,std.getNameAcc());
            statement.setString(1, std.getPassAcc());
            statement.setString(2, std.getNameUser());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getPhoneNum());
            // statement.setInt(5,std.getMaxBook());
            //  statement.setInt(6,std.getBookBorrow());
            //  statement.setInt(7,  std.getDateReader());
            statement.setInt(5, std.getStatusReader());
            statement.setInt(6, std.getReaderID());

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

    public void Date(ReaderModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "Update  Reader set Remain=? where ReaderID=?  ";
            statement = connection.prepareCall(sql);

            // statement.setInt(1,std.getNameAcc());
            statement.setInt(1, std.getRemain());

            statement.setInt(2, std.getReaderID());

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

    public String NameByReaderID(int ReaderID) {
        String name = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select NameUser from Reader where ReaderID = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, ReaderID);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("NameUser");
                break;
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
        return name;
    }

    public static Date selectDateReader(int NameAcc) {
        Date d = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select DateReader from Reader where NameAcc= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, NameAcc);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                d = resultSet.getDate("DateReader");
                break;
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
        return d;
    }

    public ReaderModel findReader(int NameAcc) {
        ReaderModel Reader = new ReaderModel();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Reader where NameAcc= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, NameAcc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reader = new ReaderModel(
                        resultSet.getInt("ReaderID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                        resultSet.getInt("MaxBook"),
                        resultSet.getInt("BookBorrow"),
                        resultSet.getDate("DateReader"),
                        resultSet.getInt("StatusReader"),
                        resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNum"),
                        resultSet.getInt("Remain")
                );
                break;
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

        return Reader;
    }

    public int checkDateReader(int NameAcc) {
        ReaderModel r = findReader(NameAcc);
        Date old = ReaderController.selectDateReader(NameAcc);
        java.util.Date date = new java.util.Date(); // your date 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int old_year = (int) old.getYear();
        int old_month = (int) old.getMonth();
        int old_day = (int) old.getDate();
        int sum = ((int) sqlDate.getYear() - old_year) * 365 + ((int) sqlDate.getMonth() - old_month) * 30 + (int) sqlDate.getDate() - old_day;
        if (sum < r.getRemain()) {
            return 1;
        } else {
            return 0;
        }

    }

    public ReaderModel findReaderbyID(int ReaderID) {
        ReaderModel Reader = new ReaderModel();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Reader where ReaderID= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, ReaderID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reader = new ReaderModel(
                        resultSet.getInt("ReaderID"),
                        resultSet.getInt("NameAcc"),
                        resultSet.getString("PassAcc"),
                        resultSet.getInt("MaxBook"),
                        resultSet.getInt("BookBorrow"),
                        resultSet.getDate("DateReader"),
                        resultSet.getInt("StatusReader"),
                        resultSet.getString("NameUser"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNum"),
                        resultSet.getInt("Remain")
                );
                break;
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

        return Reader;
    }

    public void Borrow(ReaderModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "Update  Reader set BookBorrow=?, MaxBook=?  where ReaderID=?  ";
            statement = connection.prepareCall(sql);

            // statement.setInt(1,std.getNameAcc());
            statement.setInt(1, std.getBookBorrow());
            statement.setInt(2, std.getMaxBook());
            statement.setInt(3, std.getReaderID());

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
    }

    public int DateReader(int NameAcc) {
        ReaderModel r = findReader(NameAcc);
        Date old = ReaderController.selectDateReader(NameAcc);
        java.util.Date date = new java.util.Date(); // your date 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int old_year = (int) old.getYear();
        int old_month = (int) old.getMonth();
        int old_day = (int) old.getDate();
        int sum = ((int) sqlDate.getYear() - old_year) * 365 + ((int) sqlDate.getMonth() - old_month) * 30 + (int) sqlDate.getDate() - old_day;
        return r.getRemain() - sum;

    }
    // thong ke top reader
    public void topReaderStatistic(JTable table){
        String[] colName = {"Mã bạn đọc","Tên user","Số lượt mượn"};
        DefaultTableModel model = new DefaultTableModel(colName,0);
        String sql ="select Reader.ReaderID as'id',Reader.NameUser as 'name',count(Ticket.TicketID)as'So Luong' from Reader,Ticket"
                +" where Reader.ReaderID = Ticket.ReaderID"
                +" group by Reader.ReaderID,Reader.NameUser order by(count(Ticket.TicketID)) desc";
        System.out.println(sql);
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] objBanDoc = new Object[3];
                objBanDoc[2] = rs.getString("So Luong");
                objBanDoc[0] = rs.getString("id");
                objBanDoc[1] = rs.getString("name");
                model.addRow(objBanDoc);
            }
            table.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
