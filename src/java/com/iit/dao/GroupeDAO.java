/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Etudiant;
import com.iit.model.Groupe;
import com.iit.model.Niveau;
import com.iit.model.NiveauGroupe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class GroupeDAO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public ArrayList listGroupe() {
        ArrayList<NiveauGroupe> Ngroupe = new ArrayList<NiveauGroupe>();
        try {
            Groupe g;
            Niveau n;
            NiveauGroupe nG;
            ResultSet rs = connection.select("select * from groupe g , niveau n where g.id_n=n.id_n  ;");
            while (rs.next()) {

                g = new Groupe(rs.getInt("id"), rs.getString("nom"), rs.getString("code"));
                n = new Niveau(rs.getInt("id_n"), rs.getString("nom_n"), rs.getString("code_n"), rs.getInt("nbr_g"));
                nG = new NiveauGroupe(g, n);
                Ngroupe.add(nG);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return Ngroupe;
    }

    public Groupe getGroupe(String id) {
        Groupe g = null;
        try {

            ResultSet rs = connection.select("select * from groupe u  where id='" + id + "' ;");
            rs.first();

            g = new Groupe(rs.getInt("id"), rs.getString("nom"), rs.getString("code"), rs.getString("id_n"));
            return g;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return g;
    }

    public void ajouterGroupe(Groupe g) {

        connection.update("insert into groupe values(null," + g.getNom() + ",'" + g.getCode() + "','" + g.getNiveau() + " ') ; ");
        connection.update("update niveau set nbr_g=nbrg+1 where id_n='" + g.getNiveau() + "';");

    }

    public void modifierGroupe(Groupe g) {

        connection.update("update groupe set nom = '" + g.getNom() + "', code= '" + g.getCode() + "', id_n='" + g.getNiveau() + "' where id='" + g.getId() + "'  ; ");

    }

}
