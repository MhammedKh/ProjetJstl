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
    
    private double tp;
    private double ds;
    private double examain;
    private double presentielle;
    private String numCompostage;

    public Note(double tp, double ds, double examain, double presentielle, String numCompostage) {
        this.tp = tp;
        this.ds = ds;
        this.examain = examain;
        this.presentielle = presentielle;
        this.numCompostage = numCompostage;
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
