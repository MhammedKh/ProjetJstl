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
public class Note {
    
    private int idMe;
    private int idEt;
    private int id_Ses;
    private double tp;
    private double ds;
    private double examain;
    private double presentielle;
    private String numCompostage;

    public Note(int idEt, double tp, double ds, double examain, double presentielle, String numCompostage) {
        this.idEt = idEt;
        this.tp = tp;
        this.ds = ds;
        this.examain = examain;
        this.presentielle = presentielle;
        this.numCompostage = numCompostage;
    }

    public Note(double tp, double ds, double examain, double presentielle, String numCompostage) {
        this.tp = tp;
        this.ds = ds;
        this.examain = examain;
        this.presentielle = presentielle;
        this.numCompostage = numCompostage;
    }

    public Note(int idMe, int idEt, int id_Ses, String numCompostage) {
        this.idMe = idMe;
        this.idEt = idEt;
        this.id_Ses = id_Ses;
        this.numCompostage = numCompostage;
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

    public double getTp() {
        return tp;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    public double getDs() {
        return ds;
    }

    public void setDs(double ds) {
        this.ds = ds;
    }

    public double getExamain() {
        return examain;
    }

    public void setExamain(double examain) {
        this.examain = examain;
    }

    public double getPresentielle() {
        return presentielle;
    }

    public void setPresentielle(double presentielle) {
        this.presentielle = presentielle;
    }

    public String getNumCompostage() {
        return numCompostage;
    }

    public void setNumCompostage(String numCompostage) {
        this.numCompostage = numCompostage;
    }
    
    
    
    
}
