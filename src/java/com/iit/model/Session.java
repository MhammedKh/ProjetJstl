/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.model;

import java.util.Date;

/**
 *
 * @author SAMSUNG
 */
public class Session {
    
    private int id;
    private String type;
    private String datedeb;
    private String datefin;

    public Session(int id, String type, String datedeb, String datefin) {
        this.id = id;
        this.type = type;
        this.datedeb = datedeb;
        this.datefin = datefin;
    }

    public Session(String type, String datedeb, String datefin) {
        this.type = type;
        this.datedeb = datedeb;
        this.datefin = datefin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    

   
    
    
    
}
