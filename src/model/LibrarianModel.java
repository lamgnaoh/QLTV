/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class LibrarianModel {
      int AccID,NameAcc;
    String PassAcc,NameUser,Email,PhoneNum;

    public int getAccID() {
        return AccID;
    }

    public void setAccID(int AccID) {
        this.AccID = AccID;
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

    public LibrarianModel() {
    }

    public LibrarianModel(int AccID, int NameAcc, String PassAcc, String NameUser, String Email, String PhoneNum) {
        this.AccID = AccID;
        this.NameAcc = NameAcc;
        this.PassAcc = PassAcc;
        this.NameUser = NameUser;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
    }

    public LibrarianModel(int NameAcc, String PassAcc, String NameUser, String Email, String PhoneNum) {
        this.NameAcc = NameAcc;
        this.PassAcc = PassAcc;
        this.NameUser = NameUser;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
    }
    
    
}
