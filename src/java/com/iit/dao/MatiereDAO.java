/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Matiere;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class MatiereDAO {
    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();
    
     public ArrayList listMatiere() {
        ArrayList<Matiere> lMatiere = new ArrayList<Matiere>();
        try {
            Matiere m;
            
            
            ResultSet rs = connection.select("select * from matiere  ;");
            while (rs.next()) {
               
                m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
                
                lMatiere.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lMatiere;
    }

    public void ajouterMatiere(Matiere m) {

        connection.update("insert into matiere values(null,'" + m.getNom() + "' ) ; ");
      

    }

    public void modifierMatiere(Matiere m) {

        connection.update("update matiere set nom_m = '" + m.getNom() + "'  where id_m='" + m.getId() + "'  ; ");

    }

    public Matiere getMatiere(String id) {
       Matiere m = null;
        try {

            ResultSet rs = connection.select("select * from matiere  where id_m='" + id + "' ;");
            rs.first();

            m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
            return m;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return m;
    }
}
