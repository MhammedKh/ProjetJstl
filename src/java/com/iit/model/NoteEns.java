/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.model;

/**
 *
 * @author SAMSUNG
 */
public class NoteEns {
    
     private int idMe;
    private int idEt;
    private int id_Ses;
    private String tp;
    private String ds;
    private String examain;
    private String presentielle;
    private String numCompostage;

    public NoteEns(int idMe, int id_Ses, String examain, String numCompostage) {
        this.idMe = idMe;
        this.id_Ses = id_Ses;
        this.examain = examain;
        this.numCompostage = numCompostage;
    }

    
  

    public NoteEns(int idMe, int idEt, int id_Ses, String tp, String ds, String presentielle) {
        this.idMe = idMe;
        this.idEt = idEt;
        this.id_Ses = id_Ses;
        this.tp = tp;
        this.ds = ds;
        this.presentielle = presentielle;
    }

    public int getIdMe() {
        return idMe;
    }

    public void setIdMe(int idMe) {
        this.idMe = idMe;
    }

    public int getIdEt() {
        return idEt;
    }

    public void setIdEt(int idEt) {
        this.idEt = idEt;
    }

    public int getId_Ses() {
        return id_Ses;
    }

    public void setId_Ses(int id_Ses) {
        this.id_Ses = id_Ses;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getExamain() {
        return examain;
    }

    public void setExamain(String examain) {
        this.examain = examain;
    }

    public String getPresentielle() {
        return presentielle;
    }

    public void setPresentielle(String presentielle) {
        this.presentielle = presentielle;
    }

    public String getNumCompostage() {
        return numCompostage;
    }

    public void setNumCompostage(String numCompostage) {
        this.numCompostage = numCompostage;
    }
    
    
    
}
