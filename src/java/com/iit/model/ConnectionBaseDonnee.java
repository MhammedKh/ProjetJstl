/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionBaseDonnee {

    public void update(String rec) {
        Connection con = null;
        Statement pred = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jstl", "root", "system");
            pred = con.createStatement();
            pred.executeUpdate(rec);

        } catch (Exception e) {
            System.err.println(e.getMessage());
           
        }
    }

    public ResultSet select(String rec) {
        Connection con = null;
        Statement pred = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jstl", "root", "system");
            pred = con.createStatement();
            rs = pred.executeQuery(rec);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return rs;

    }

}
