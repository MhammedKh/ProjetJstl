/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Enseignant;
import com.iit.model.Etudiant;
import com.iit.model.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SAMSUNG
 */
public class UtilisateurDAO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public boolean verifLogimMp(String login, String mp) {
        try {

            ResultSet rs = connection.select("select count(*) as nbr from utilisateur where login='" + login + "' and mp = '" + mp + "' ;");
            rs.first();
            if (rs.getInt("nbr") > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }

    }

    public Utilisateur getUserLoginPass(String login, String mp) {
        try {
            ResultSet rs = connection.select("select * from utilisateur where login='" + login + "' and mp = '" + mp + "' ;");
            rs.first();
            if (rs.getInt("type") == 2) {

                return new Enseignant(rs.getInt("id"));

            } else if (rs.getInt("type") == 3) {

                return new Etudiant(rs.getInt("id"));

            }
        } catch (SQLException e) {

        }
        return null;
    }

}
