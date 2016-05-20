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
public class Groupe {
    
        private int id;
        private String nom;
        private String code;
        private String niveau;

    public Groupe(int id) {
        this.id = id;
    }

    

    public Groupe(int id, String nom, String code,String niveau) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.niveau=niveau;
    }
    
      public Groupe(int id, String nom, String code) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        
    }

    public Groupe(String nom, String code, String niveau) {
        this.nom = nom;
        this.code = code;
        this.niveau = niveau;
    }
    

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        
}
