/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class ReaderModel {
    int ReaderID,MaxBook,BookBorrow,NameAcc;
    int StatusReader,Remain;
    public String NameUser,Email,PhoneNum,PassAcc;
    Date DateReader;
    public int getReaderID() {
        return ReaderID;
    }

    public void setReaderID(int ReaderID) {
        this.ReaderID = ReaderID;
    }

    public int getRemain() {
        return Remain;
    }

    public void setRemain(int Remain) {
        this.Remain = Remain;
    }

    public int getNameAcc() {
        return NameAcc;
    }

    public void setNameAcc(int NameAcc) {
        this.NameAcc = NameAcc;
    }

    public String getPassAcc() {
        return PassAcc;
    }

    public void setPassAcc(String PassAcc) {
        this.PassAcc = PassAcc;
    }

    public int getMaxBook() {
        return MaxBook;
    }

    public void setMaxBook(int MaxBook) {
        this.MaxBook = MaxBook;
    }

    public int getBookBorrow() {
        return BookBorrow;
    }

    public void setBookBorrow(int BookBorrow) {
        this.BookBorrow = BookBorrow;
    }

    public Date getDateReader() {
        return DateReader;
    }

    public void setDateReader(Date DateReader) {
        this.DateReader = DateReader;
    }

    public int getStatusReader() {
        return StatusReader;
    }

    public void setStatusReader(int StatusReader) {
        this.StatusReader = StatusReader;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }


    public ReaderModel(int NameAcc, String PassAcc, int MaxBook, int BookBorrow, Date DateReader, int StatusReader, String NameUser, String Email, String PhoneNum,int Remain) {
        this.NameAcc = NameAcc;
        this.PassAcc = PassAcc;
        this.MaxBook = MaxBook;
        this.BookBorrow = BookBorrow;
        this.DateReader = DateReader;
        this.StatusReader = StatusReader;
        this.NameUser = NameUser;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
        this.Remain=Remain;
    }
    
        public ReaderModel(int ReaderID, int NameAcc, String PassAcc, int MaxBook, int BookBorrow, Date DateReader, int StatusReader, String NameUser, String Email, String PhoneNum,int Remain) {
        this.ReaderID = ReaderID;
        this.NameAcc = NameAcc;
        this.PassAcc = PassAcc;
        this.MaxBook = MaxBook;
        this.BookBorrow = BookBorrow;
        this.DateReader = DateReader;
        this.StatusReader = StatusReader;
        this.NameUser = NameUser;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
        this.Remain=Remain;
    }

    public ReaderModel() {
    }

    
}