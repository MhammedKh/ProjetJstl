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
public class Etudiant extends Utilisateur{


    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String motPasse;
    private String adresse;
     private String tel;
    private int cin;
    private String groupe;

    public Etudiant(int id) {
        this.id = id;
    }

    public Etudiant( String nom, String prenom, String login, String motPasse, String adresse, String tel, int cin, String groupe) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motPasse = motPasse;
        this.adresse = adresse;
        this.tel = tel;
        this.cin = cin;
        this.groupe = groupe;
    }

    public Etudiant(int id, String nom, String prenom, int cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

  
    

    public Etudiant(int id, String nom, String prenom, String adresse, String tel, int cin, String g) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.cin = cin;
        this.groupe=g;
       
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    
}
