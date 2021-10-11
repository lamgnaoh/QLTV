/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class PublisherModel {
   int PubID;
   String PubName;

    public int getPubID() {
        return PubID;
    }

    public void setPubID(int PubID) {
        this.PubID = PubID;
    }

    public String getPubName() {
        return PubName;
    }

    public void setPubName(String PubName) {
        this.PubName = PubName;
    }

    public PublisherModel() {
    }

    public PublisherModel(String PubName) {
        this.PubName = PubName;
    }

    public PublisherModel(int PubID, String PubName) {
        this.PubID = PubID;
        this.PubName = PubName;
    }
   
}
