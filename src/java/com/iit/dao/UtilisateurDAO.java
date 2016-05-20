/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
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

}
