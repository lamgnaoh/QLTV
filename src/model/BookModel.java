/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class BookModel {
    int Date,Count,BookID,GroupBookID,PubID,CateID,MaxNum;
    String BookName,Author;

    public BookModel(String bookName, int groupBookId, int pubBookId, int cateBookId, String bookAuthor, int maxBook, int bookCount, int bookBorrow) {
        this.Date = bookBorrow;
        this.Count = bookCount;
        this.GroupBookID = groupBookId;
        this.PubID = pubBookId;
        this.CateID = cateBookId;
        this.BookName = bookName;
        this.Author = bookAuthor;
        this.MaxNum = maxBook;
    }

    public int getBookID() {
        return BookID;
    }


    public int getDate() {
        return Date;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public int getGroupBookID() {
        return GroupBookID;
    }

    public void setGroupBookID(int GroupBookID) {
        this.GroupBookID = GroupBookID;
    }

    public int getPubID() {
        return PubID;
    }

    public void setPubID(int PubID) {
        this.PubID = PubID;
    }

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public int getMaxNum() {
        return MaxNum;
    }

    public void setMaxNum(int MaxNum) {
        this.MaxNum = MaxNum;
    }

   

    public BookModel() {
    }

    public BookModel(int Date, int Count, int GroupBookID, int PubID, int CateID, String BookName, String Author,int MaxNum) {
        this.Date = Date;
        this.Count = Count;
        this.GroupBookID = GroupBookID;
        this.PubID = PubID;
        this.CateID = CateID;
        this.BookName = BookName;
        this.Author = Author;
        this.MaxNum=MaxNum;
    }

    public BookModel(int Date, int Count, int BookID, int GroupBookID, int PubID, int CateID, String BookName, String Author,int MaxNum) {
        this.Date = Date;
        this.Count = Count;
        this.BookID = BookID;
        this.GroupBookID = GroupBookID;
        this.PubID = PubID;
        this.CateID = CateID;
        this.BookName = BookName;
        this.Author = Author;
        this.MaxNum=MaxNum;
    }
    
    
}
