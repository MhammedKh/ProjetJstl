/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Enseignant;
import com.iit.model.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class EtudiantDAO {
    
        ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public ArrayList listEtud() {
        ArrayList<Etudiant> ens = new ArrayList<Etudiant>();
        try {
            Etudiant e;
            ResultSet rs = connection.select("select u.* ,g.nom as nom_g  from utilisateur u, groupe g where type='3' and u.id_g=g.id ;");
            while (rs.next()) {
                System.err.println(rs.getInt("id"));
                e = new Etudiant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"), rs.getInt("cin"), rs.getString("nom_g"));
                ens.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return ens;
    }
    
    
    public ArrayList listEtudGroupe(int id_g) {
        ArrayList<Etudiant> ens = new ArrayList<Etudiant>();
        try {
            Etudiant e;
            ResultSet rs = connection.select("select *  from utilisateur  where  u.id_g='"+id_g+"' ;");
            while (rs.next()) {
                System.err.println(rs.getInt("id"));
                e = new Etudiant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getInt("cin"));
                ens.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return ens;
    }
    
    
       public Etudiant getEtud(String id) {
         Etudiant e=null;
        try {
          
            ResultSet rs = connection.select("select * from utilisateur u  where id='"+id+"' ;");
            rs.first();
                
                e = new Etudiant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"), rs.getInt("cin"), rs.getString("id_g"));
               return e;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return e;
    }
    
    
    public void ajouteretud(Etudiant e){
        
        connection.update("insert into utilisateur values(null,"+e.getCin()+",'"+e.getNom()+"','"+e.getPrenom()+"',3,'"+e.getLogin()+"','"+e.getMotPasse()+"'," +e.getGroupe()+",'"+e.getTel()+"','"+e.getAdresse()+" ') ; ");
        
    }
    
      public void modifierEns(Etudiant e){
        
        connection.update("update utilisateur set cin = "+e.getCin()+", nom= '"+e.getNom()+"', prenom='"+e.getPrenom()+"', tel ='"+e.getTel()+"', adresse ='"+e.getAdresse()+" ' where id='"+e.getId()+"'  ; ");
        
    }
    
}
