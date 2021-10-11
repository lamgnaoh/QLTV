/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;

// getConnection() 
public class ConnectDB {
  
    public static Connection getConnection(){
        Connection cnn=null;
        try{
            String uRL="jdbc:sqlserver://Localhost:1433;databaseName=Quan_ly_thu_vien_1";
            String user="sa";
            String pass="123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn=DriverManager.getConnection(uRL,user,pass);
        }catch(Exception e){
            System.out.println("Khong ket noi");
        }   
        return cnn;
    }
    
}
   