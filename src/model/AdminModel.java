/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class AdminModel {
    String AdminName,AdminPass;

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    public String getAdminPass() {
        return AdminPass;
    }

    public void setAdminPass(String AdminPass) {
        this.AdminPass = AdminPass;
    }

    public AdminModel(String AdminName, String AdminPass) {
        this.AdminName = AdminName;
        this.AdminPass = AdminPass;
    }

    public AdminModel() {
    }
    
}
