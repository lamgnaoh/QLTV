/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class GroupBookModel {
    int GroupBookID;
    String GroupBookName;

    public int getGroupBookID() {
        return GroupBookID;
    }

    public void setGroupBookID(int GroupBookID) {
        this.GroupBookID = GroupBookID;
    }

    public String getGroupBookName() {
        return GroupBookName;
    }

    public void setGroupBookName(String GroupBookName) {
        this.GroupBookName = GroupBookName;
    }

    public GroupBookModel() {
    }

    public GroupBookModel(int GroupBookID, String GroupBookName) {
        this.GroupBookID = GroupBookID;
        this.GroupBookName = GroupBookName;
    }

    public GroupBookModel(String GroupBookName) {
        this.GroupBookName = GroupBookName;
    }
    
}
