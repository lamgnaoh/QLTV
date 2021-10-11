/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;

public class TicketModel {
    int TicketID,ReaderID,BookID;
    int StatusTicket;
    Date DateBorrow;

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int TicketID) {
        this.TicketID = TicketID;
    }

    public int getReaderID() {
        return ReaderID;
    }

    public void setReaderID(int ReaderID) {
        this.ReaderID = ReaderID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getStatusTicket() {
        return StatusTicket;
    }
    
    public String getStatusTicket1(){
        if(this.getStatusTicket()==1){
            return "Đã mượn";
        } else {
            return "Chưa mượn";
        }
    }

    public void setStatusTicket(int StatusTicket) {
        this.StatusTicket = StatusTicket;
    }

    public Date getDateBorrow() {
        return DateBorrow;
    }

    public void setDateBorrow(Date DateBorrow) {
        this.DateBorrow = DateBorrow;
    }

    public TicketModel() {
    }

    public TicketModel(int TicketID, int ReaderID,  int BookID, int StatusTicket, Date DateBorrow) {
        this.TicketID = TicketID;
        this.ReaderID = ReaderID;
        this.BookID = BookID;
        this.StatusTicket = StatusTicket;
        this.DateBorrow = DateBorrow;
    }

    public TicketModel(int ReaderID,  int BookID, int StatusTicket, Date DateBorrow) {
        this.ReaderID = ReaderID;
        this.BookID = BookID;
        this.StatusTicket = StatusTicket;
        this.DateBorrow = DateBorrow;
    }
}
