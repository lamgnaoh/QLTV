/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ReaderController;
import java.util.regex.Pattern;


public class Check {
      
    ReaderController readerController = new ReaderController();
            
    public static void main() {
        String e1="askjdhkjsdh";
        String e2="assd@gmail.com";
        String input="012345678";
      //  System.out.println(""+checkEmail(""));
       // System.out.println(""+checkPhoneNum(input));
        //System.out.println(""+readerController.findReader(Integer.parseInt("5465546")).getNameAcc());
    }
    public static boolean checkEmail(String email){
        if(email==null||email.isEmpty()){
            return true;
        }
        String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p=Pattern.compile(emailRegex);
        if(p.matcher(email).matches()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkPhoneNum(String input){
        try{
            Integer.parseInt(input);    
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
