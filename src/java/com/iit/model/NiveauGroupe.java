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
public class NiveauGroupe {
    
    private Groupe g;
    private Niveau n;

    public NiveauGroupe(Groupe g, Niveau n) {
        this.g = g;
        this.n = n;
    }

    public Groupe getG() {
        return g;
    }

    public void setG(Groupe g) {
        this.g = g;
    }

    public Niveau getN() {
        return n;
    }

    public void setN(Niveau n) {
        this.n = n;
    }
    
    
    
    
}
