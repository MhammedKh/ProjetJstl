/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.model;

import com.iit.dao.EnseignantADO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SAMSUNG
 */
public class main {
    public static void main(String[] args) throws SQLException {
        ConnectionBaseDonnee connection = new ConnectionBaseDonnee();
         ResultSet rs = connection.select("select * from utilisateur where id='"+7+"' ;");
            rs.first();
                
               Enseignant e = new Enseignant(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"), rs.getInt("cin"));
               System.out.println(e.getAdresse());
            
    }
    
}
