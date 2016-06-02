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
public class NoteEtud {
    
    private Note n;
    private Etudiant e;

    public NoteEtud(Note n, Etudiant e) {
        this.n = n;
        this.e = e;
    }

    public Note getN() {
        return n;
    }

    public void setN(Note n) {
        this.n = n;
    }

    public Etudiant getE() {
        return e;
    }

    public void setE(Etudiant e) {
        this.e = e;
    }
    
    
    
}
