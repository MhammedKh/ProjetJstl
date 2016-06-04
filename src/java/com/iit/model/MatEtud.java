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
public class MatEtud {
    
    private Matiere m;
    private Note n;

    public MatEtud(Matiere m, Note n) {
        this.m = m;
        this.n = n;
    }

    public Matiere getM() {
        return m;
    }

    public void setM(Matiere m) {
        this.m = m;
    }

    public Note getN() {
        return n;
    }

    public void setN(Note n) {
        this.n = n;
    }
    
    
    
}
