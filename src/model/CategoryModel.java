/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class CategoryModel {
    int CateID;
    String CateName;

    public int getCateID() {
        return CateID;
    }

    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

    public CategoryModel() {
    }

    public CategoryModel(String CateName) {
        this.CateName = CateName;
    }

    public CategoryModel(int CateID, String CateName) {
        this.CateID = CateID;
        this.CateName = CateName;
    }
    
}
