/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import model.BookModel;
import model.TicketModel;
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
import model.ReaderModel;
import views.staff.StaffManageView;


// Truy Vấn DB để tìm kiếm, thêm, sửa, xóa Ticket
public class TicketController {
    BookController bookController = new BookController();
    ReaderController readerController = new ReaderController();
    StaffLibController staffLibController = new StaffLibController();
    // Tìm tất cả Ticket trong DB
     public List<TicketModel> findAll() {
        List<TicketModel> TicketList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "select * from Ticket";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                TicketModel std = new TicketModel( 
                        resultSet.getInt("TicketID"),
                        resultSet.getInt("ReaderID"),     
                   
                        resultSet.getInt("BookID"), 
                        resultSet.getInt("StatusTicket"),
                         resultSet.getDate("DateBorrow")
                                
                        );
              TicketList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return TicketList;
    }
     
     // thêm Ticket
     public void AddTicket(TicketModel std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
             java.util.Date date = new java.util.Date(); // your date 
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            //query
            String sql = "insert into Ticket(ReaderID,   BookID,  StatusTicket,  DateBorrow) values(?, ?, ?, ?) ";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, std.getReaderID());
            
           
            statement.setInt(2, std.getBookID());
            statement.setInt(3, std.getStatusTicket());
            statement.setDate(4, sqlDate);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
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
     
     // Xóa ticket
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection = ConnectDB.getConnection();
            
            //query
            String sql = "delete from Ticket where TicketID = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    // Tìm ticket theo ReaderId
  public List<TicketModel> findReaderID(int ReaderID) {
        List<TicketModel> TicketList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = ConnectDB.getConnection();
            
            //query
            String sql = "select * from Ticket where ReaderID= ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1,ReaderID);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                TicketModel std = new TicketModel( 
                        resultSet.getInt("TicketID"),
                        resultSet.getInt("ReaderID"),     
                     
                        resultSet.getInt("BookID"), 
                        resultSet.getInt("StatusTicket"),
                         resultSet.getDate("DateBorrow")
                                
                        );
              TicketList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return TicketList;
    }
  
  // lấy về ReaderId theo tên Reader
   public int  ReaderID(int Name) {
        int ReaderID=0;
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection =  ConnectDB.getConnection();
            
            //query
            String sql = "select ReaderID from Reader where NameAcc=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, Name);
            
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {                
               ReaderID=resultSet.getInt("ReaderID");
               break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return ReaderID;
    }
   
   // Chỉnh sửa Ticket
    public void Update(TicketModel std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection = ConnectDB.getConnection();
            
            //query
           String sql="Update  Ticket set StatusTicket=?,DateBorrow=? where TicketID=?   ";
            statement = connection.prepareCall(sql);
            
          
             statement.setInt(1, std.getStatusTicket());
              statement.setDate(2, (Date) std.getDateBorrow());
             statement.setInt(3, std.getTicketID());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    // Lấy về NameAcc theo ReaderId
    public int  NameAcc(int id) {
        int NameAcc=0;
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
           connection =  ConnectDB.getConnection();
            
            //query
            String sql = "select NameAcc from Reader where ReaderID=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1,id);
            
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {                
               NameAcc=resultSet.getInt("NameAcc");
               break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return NameAcc;
    }
    
    // Check thời hạn ticket để tính số ngày mượn sách 
      public int checkDateTicket(TicketModel ticket) {
           BookModel book = bookController.findBookByID(ticket.getBookID());
           
           Date old= (Date) ticket.getDateBorrow();
           java.util.Date date = new java.util.Date(); // your date 
           java.sql.Date sqlDate=new java.sql.Date(date.getTime());
           int old_year=(int) old.getYear();
           int old_month=(int)old.getMonth();
           int old_day=(int) old.getDate();
           int sum=((int)sqlDate.getYear()-old_year)*365+((int)sqlDate.getMonth()-old_month)*30+(int)sqlDate.getDate()-old_day;
           if(sum<=book.getDate()) return 0;
           else return 1;
    }
      
    public boolean inPhieuMuon(TicketModel ticketModel, String path) {
        ReaderModel readerModel = readerController.findReaderbyID(ticketModel.getReaderID());
        BookModel bookModel = bookController.findBookByID(ticketModel.getBookID());

        String nameStaff = staffLibController.findNameStaffById(StaffManageView.idStaff);
        
        try {

            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
            Document document = new Document(/*PageSize.A4, 50, 50, 50, 50*/);
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();
            Font fontTenThuVien = new Font(bf1, 30, Font.BOLD, BaseColor.RED);
            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
            Font fontLienLac = new Font(bf1, 7, Font.UNDEFINED, BaseColor.BLACK);
            document.add(new Paragraph("           THƯ VIỆN TẠ QUANG BỬU", fontTenThuVien));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Đại học Bách Khoa Hà Nội                                                                                                                                                                                          SĐT: 0987666888",fontLienLac));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
            document.add(new Paragraph("                                      PHIẾU MƯỢN SÁCH", fontTieuDe));
            document.add(new Paragraph("                               ", fontTieuDe));
            document.add(new Paragraph("Mã số phiếu        : " + ticketModel.getTicketID(), fontChung));
            document.add(new Paragraph("Ngày mượn         : " + ticketModel.getDateBorrow(), fontChung));
            Date date = new Date(ticketModel.getDateBorrow().getYear(), ticketModel.getDateBorrow().getMonth(), ticketModel.getDateBorrow().getDay() + bookModel.getDate());
            
            document.add(new Paragraph("Hạn trả           : " + date, fontChung));
            document.add(new Paragraph("Số tiền cọc          : " + "20.000 VND" , fontChung));
            document.add(new Paragraph("Mã số bạn đọc     : " + readerModel.getReaderID(), fontChung));
            document.add(new Paragraph("Họ tên bạn đọc    : " + readerModel.getNameUser(), fontChung));
            document.add(new Paragraph("Năm sinh          : " + "2000", fontChung));
            document.add(new Paragraph("Địa chỉ           : " + "Số xxx Đường Giải Phóng", fontChung));
            document.add(new Paragraph("Số chứng minh thư : " + "035212312xxx", fontChung));
            document.add(new Paragraph("Số điện thoại     : " + readerModel.getPhoneNum(), fontChung));
            document.add(new Paragraph("Mã số thủ thư      : " + StaffManageView.idStaff , fontChung));
            document.add(new Paragraph("Họ tên nhân viên    : " + nameStaff + "\n", fontChung));
            document.add(new Paragraph("Sách đã mượn :", fontChung));
            document.add(new Paragraph(" ", fontChung));
            String bookBorrow = "Id sách : "+bookModel.getBookID()+"\nTên sách :"+ bookModel.getBookName() +
                    "\nTác Giả : " + bookModel.getAuthor();
            document.add(new Paragraph(bookBorrow ,fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph(" ", fontChung));
            document.add(new Paragraph("         Chữ ký bạn đọc                                                Chữ ký thủ thư và đóng dấu ", fontChuKy));
            document.close();
  
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public PdfPTable getTable(JTable table) throws DocumentException, IOException {
        BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
        Font fontBang = new Font(bf1, 10, Font.NORMAL, BaseColor.BLACK);
        Font fontCot = new Font(bf1, 12, Font.BOLD, BaseColor.BLUE);
        int numColumm = table.getColumnCount();
        // set cho dòng đầu tiên
        PdfPTable pdfTable = new PdfPTable(numColumm);
        for (int i = 0; i < numColumm; i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(i), fontCot));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
            pdfTable.addCell(cell);
        }
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                PdfPCell cell = new PdfPCell(new Paragraph("" + table.getValueAt(i, j), fontBang));
                pdfTable.addCell(cell);
            }
        }
        return pdfTable;
    }
}
