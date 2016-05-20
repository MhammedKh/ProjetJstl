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
public class Niveau {

    private int id;
    private String nom;
    private String code;
    private int nbrGroupe;

    public Niveau(String nom, String code) {
        this.nom = nom;
        this.code = code;
    }

    public Niveau(int id, String nom, String code) {
        this.id = id;
        this.nom = nom;
        this.code = code;
    }

    
    public Niveau(int id, String nom, String code, int nbrGroupe) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.nbrGroupe = nbrGroupe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrGroupe() {
        return nbrGroupe;
    }

    public void setNbrGroupe(int nbrGroupe) {
        this.nbrGroupe = nbrGroupe;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getnbrGroupe() {
        return nbrGroupe;
    }

    public void setnbrGroupe(int nbrGroupe) {
        this.nbrGroupe = nbrGroupe;
    }
    
    
    
    
}
