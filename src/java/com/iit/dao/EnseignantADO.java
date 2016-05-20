/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Enseignant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class EnseignantADO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public ArrayList listEns() {
        ArrayList<Enseignant> ens = new ArrayList<Enseignant>();
        try {
            Enseignant e;
            ResultSet rs = connection.select("select * from utilisateur where type='2' ;");
            while (rs.next()) {
                System.err.println(rs.getInt("id"));
                e = new Enseignant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"), rs.getInt("cin"));
                ens.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return ens;
    }
       public Enseignant getEns(String id) {
         Enseignant e=null;
        try {
          
            ResultSet rs = connection.select("select * from utilisateur where id='"+id+"' ;");
            rs.first();
                
                e = new Enseignant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"), rs.getInt("cin"));
               return e;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return e;
    }
    
    
    public void ajouterEns(Enseignant e){
        
        connection.update("insert into utilisateur values(null,"+e.getCin()+",'"+e.getNom()+"','"+e.getPrenom()+"',2,'"+e.getLogin()+"','"+e.getMotPasse()+"',null,'"+e.getTel()+"','"+e.getAdresse()+" ') ; ");
        
    }
    
      public void modifierEns(Enseignant e){
        
        connection.update("update utilisateur set cin = "+e.getCin()+", nom= '"+e.getNom()+"', prenom='"+e.getPrenom()+"', tel ='"+e.getTel()+"', adresse ='"+e.getAdresse()+" ' where id='"+e.getId()+"'  ; ");
        
    }

}
