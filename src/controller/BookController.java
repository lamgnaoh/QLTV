/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.BookModel;
import java.sql.Connection;
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

// Query DB , thực hiện tìm kiếm, thêm , sửa , xóa Book
public class BookController {
    
    // Tìm tất cả Book trong DB
    public List<BookModel> findAll() {
        List<BookModel> BookList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Book";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

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

    // xóa Book
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "delete from Book where BookID = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
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
    }

    // Tìm kiếm Book theo tên 
    public List<BookModel> findBookName(String BookName) {
        List<BookModel> BookList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Book where BookName like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + BookName + "%");
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

    // sửa Book
    public void Update(BookModel std, int bookId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            //query
            String sql = "Update  Book set BookName=?,GroupBookID=?,PubID=?,CateID=?,Author=?,MaxNum=?,Count=?,Date=? where BookID=?   ";
            statement = connection.prepareCall(sql);
            statement.setString(1, std.getBookName());
            statement.setInt(2, std.getGroupBookID());
            statement.setInt(3, std.getPubID());
            statement.setInt(4, std.getCateID());
            statement.setString(5, std.getAuthor());
            statement.setInt(6, std.getMaxNum());
            statement.setInt(7, std.getCount());
            statement.setInt(8, std.getDate());
            statement.setInt(9, bookId);
            statement.execute();
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
    }

    // Trả về tên sách theo BookId
    public String BookNameByReaderID(int BookID) {
        String Book_name = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select BookName from Book where BookID = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, BookID);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book_name = resultSet.getString("BookName");
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
        return Book_name;
    }

    // Tìm Book theo BookId
    public BookModel findBookByID(int BookID) {
        BookModel Book = new BookModel();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "select * from Book where BookID= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, BookID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book = new BookModel(resultSet.getInt("Date"),
                        resultSet.getInt("Count"),
                        resultSet.getInt("BookID"),
                        resultSet.getInt("GroupBookID"),
                        resultSet.getInt("PubID"),
                        resultSet.getInt("CateID"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getInt("MaxNum")
                );
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
        return Book;
    }

    // Cập nhật tổng số Book trong DB
    public void UpdateCount(BookModel std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();

            //query
            String sql = "Update  Book set Count=? where BookID=?  ";
            statement = connection.prepareCall(sql);

            // statement.setInt(1,std.getNameAcc());
            statement.setInt(1, std.getCount());

            statement.setInt(2, std.getBookID());

            statement.execute();
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
    }

    public boolean addBook(BookModel book) {
        try {
            Connection connection = ConnectDB.getConnection();
            String sql = "Insert into Book(BookName,GroupBookID,PubID,CateID,Author,MaxNum,Count,Date) values(?,?, ?, ?, ?, ?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, book.getBookName());
            pst.setInt(2, book.getGroupBookID());
            pst.setInt(3, book.getPubID());
            pst.setInt(4, book.getCateID());
            pst.setString(5, book.getAuthor());
            pst.setInt(6, book.getMaxNum());
            pst.setInt(7, book.getCount());
            pst.setInt(8, book.getDate());
            pst.execute();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
     //thong ke sach theo cac kieu khac nhau
    public void bookStatistic(JTable table , String type){
        String sql = "select " + type + ", sum(Book.Count) as 'So Luong'from Book, Category , Publisher where Book.CateID = Category.CateID and Book.PubID = Publisher.PubID group by "+type;
        String[] colName = new String[2];
        if (type.equals("BookName")){
            colName[0] = "Tên Sách";

        }
        if(type.equals("Author")){
            colName[0] = "Tác Giả";
        }
        if(type.equals("CateName")){
            colName[0] = "Thể Loại";
        }
        if(type.equals("PubName")){
            colName[0] = "Nhà xuất bản";
        }
        System.out.println(sql);
        colName[1] = "Số Lượng";
        DefaultTableModel model =  new DefaultTableModel(colName,0);
        Object[] objBook =new Object[2];
        Connection conn = ConnectDB.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                objBook[0] = rs.getString(type);
                objBook[1] = rs.getInt("So Luong");
                model.addRow(objBook);
            }
            table.setModel(model);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //thong ke top nhung sach dang duoc muon nhieu nhat
    public void topBookStatistic(JTable table, int numberBook){
        String sql = "select top "+numberBook+" BookName, Author, PubName, CateName, count(Ticket.TicketID)  as 'so luong'"
                +" from Book,Ticket,Publisher,Category where Book.BookID = Ticket.BookID and Book.PubID =Publisher.PubID and Book.CateID = Category.CateID and Ticket.StatusTicket = 1"
                +" group by BookName, Author, PubName, CateName "
                +" order by count(Ticket.TicketID) desc ";
        String[] colName = {"Tên sách", "Tác giả", "Nhà xuất bản", "Thể loại", "Số lượt mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objBook = new Object[5];
        System.out.println(sql);
        Connection con = ConnectDB.getConnection();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                objBook[0] = rs.getString("BookName");
                objBook[1] = rs.getString("Author");
                objBook[2] = rs.getString("PubName");
                objBook[3] = rs.getString("CateName");
                objBook[4] = rs.getInt("so luong");
                model.addRow(objBook);
            }
            table.setModel(model);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //so luong sach duoc muon trong thang
    public void bookStatisticByMonth(JTable table){
        String sql = "select month(Ticket.DateBorrow) as 'Month', count(Ticket.BookID)  as 'So Luong'"
                +" from Ticket where year(Ticket.DateBorrow ) = year(GETDATE()) and Ticket.StatusTicket = 1"
                +" group by month(Ticket.DateBorrow)";
        String[] colName = {"Tháng","Số lượng sách cho mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] objNumberBook =new Object[2];
                objNumberBook[0] = rs.getString("Month");
                objNumberBook[1] = rs.getInt("So Luong");
                model.addRow(objNumberBook);
            }
            table.setModel(model);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // so luot muon sach theo thang
    public void borrowStatisticByMonth(JTable table){
        String sql = "select month(Ticket.DateBorrow) as 'Thang', count(Ticket.TicketID) as 'So luong'"
                +" from Ticket where year(Ticket.DateBorrow ) = year(GETDATE()) and Ticket.StatusTicket = 1"
                +" group by month(Ticket.DateBorrow)";
        String[] colName = {"Tháng","Số lượt cho mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] objNumberBook =new Object[2];
                objNumberBook[0] = rs.getString("Thang");
                objNumberBook[1] = rs.getInt("So luong");
                model.addRow(objNumberBook);
            }
            table.setModel(model);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // thong ke sach muon theo ngay
    public void borrowBookStatistic(JTable table,String date1, String date2){
        String sql = String.format("select Book.BookID,Book.BookName,Ticket.DateBorrow,Ticket.ReaderID,Reader.NameUser,Ticket.TicketID"
                +" from Book,Ticket,Reader where Ticket.StatusTicket = 1 and Ticket.BookID = Book.BookID and Ticket.ReaderID = Reader.ReaderID and datediff(day,'%s',Ticket.DateBorrow) >=0 and datediff(day,Ticket.DateBorrow,'%s') >=0;"
                , date2,date1);
        System.out.println(sql);
        String[] colName = {"Mã số sách", "Tên sách", "Ngày mượn", "Mã số bạn đọc mượn sách", "Tên bạn đọc", "Mã số mượn"};
        DefaultTableModel model = new DefaultTableModel(colName, 0);
        Object[] objBookStatistic = new Object[6];
        Connection con = ConnectDB.getConnection();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                objBookStatistic[0] = rs.getString("Book.BookID");
                objBookStatistic[1] = rs.getString("Book.BookName");
                objBookStatistic[2] = rs.getDate("Ticket.DateBorrow");
                objBookStatistic[3] = rs.getString("Ticket.ReaderID");
                objBookStatistic[4] = rs.getString("Reader.NameUser");
                objBookStatistic[5] = rs.getString("Ticket.TicketID");
                model.addRow(objBookStatistic);
                
            }
            table.setModel(model);
        }catch(SQLException e ){
            e.printStackTrace();
        }
    }
}
