/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;

import com.iit.model.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class SessionDAO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public ArrayList listSession() {
        ArrayList<Session> lSession = new ArrayList<Session>();
        try {
            Session s;

            ResultSet rs = connection.select("select * from session order by id desc  ;");
            while (rs.next()) {

                s = new Session(rs.getInt("id"), rs.getString("type"), rs.getString("date_d"), rs.getString("date_f"));

                lSession.add(s);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return lSession;
    }

    public void ajouterSession(Session s) {

        connection.update("insert into session values(null,'" + s.getType() + "','" + s.getDatedeb() + "','" + s.getDatefin() + "') ; ");

    }

    public void modifierSession(Session s) {

        connection.update("update session set type = '" + s.getType() + "', date_d= '" + s.getDatedeb() + "', date_f= '" + s.getDatefin() + "'  where id='" + s.getId() + "'  ; ");

    }

    public Session getSession(String id) {
        Session s = null;
        try {

            ResultSet rs = connection.select("select * from session  where id='" + id + "' ;");
            rs.first();

            s = new Session(rs.getInt("id"), rs.getString("type"), rs.getString("date_d"), rs.getString("date_f"));
            return s;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return s;
    }
}
