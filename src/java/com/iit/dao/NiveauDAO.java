/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
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
public class NiveauDAO {
    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();
    
     public ArrayList listNiveau() {
        ArrayList<Niveau> lNiveau = new ArrayList<Niveau>();
        try {
            Niveau n;
            
            
            ResultSet rs = connection.select("select * from niveau  ;");
            while (rs.next()) {
               
                n = new Niveau(rs.getInt("id_n"), rs.getString("nom_n"),rs.getString("code_n"), rs.getInt("nbr_g"));
                
                lNiveau.add(n);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lNiveau;
    }

    public void ajouterNiveau(Niveau n) {

        connection.update("insert into niveau values(null,'" + n.getNom() + "','" + n.getCode() + "','0') ; ");
      

    }

    public void modifierNiveau(Niveau n) {

        connection.update("update niveau set nom_n = '" + n.getNom() + "', code_n= '" + n.getCode() + "'  where id_n='" + n.getId() + "'  ; ");

    }

    public Niveau getNiveau(String id) {
       Niveau n = null;
        try {

            ResultSet rs = connection.select("select * from niveau  where id_n='" + id + "' ;");
            rs.first();

            n = new Niveau(rs.getInt("id_n"), rs.getString("nom_n"), rs.getString("code_n"), Integer.parseInt(rs.getString("nbr_g")));
            return n;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return n;
    }
}
