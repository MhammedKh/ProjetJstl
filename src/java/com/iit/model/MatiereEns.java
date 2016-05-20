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
public class MatiereEns {
    private int id;
    private Enseignant id_ens;
    private Groupe id_g;
    private Matiere id_m;

    public MatiereEns(Enseignant id_ens, Groupe id_g, Matiere id_m) {
        this.id_ens = id_ens;
        this.id_g = id_g;
        this.id_m = id_m;
    }

    public MatiereEns(int id, Enseignant id_ens, Groupe id_g, Matiere id_m) {
        this.id = id;
        this.id_ens = id_ens;
        this.id_g = id_g;
        this.id_m = id_m;
    }

    public MatiereEns(int id, Groupe id_g, Matiere id_m) {
        this.id = id;
        this.id_g = id_g;
        this.id_m = id_m;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enseignant getId_ens() {
        return id_ens;
    }

    public void setId_ens(Enseignant id_ens) {
        this.id_ens = id_ens;
    }

    public Groupe getId_g() {
        return id_g;
    }

    public void setId_g(Groupe id_g) {
        this.id_g = id_g;
    }

    public Matiere getId_m() {
        return id_m;
    }

    public void setId_m(Matiere id_m) {
        this.id_m = id_m;
    }

   
    
}
