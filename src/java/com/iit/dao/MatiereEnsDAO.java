/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.Enseignant;
import com.iit.model.Groupe;
import com.iit.model.Matiere;
import com.iit.model.MatiereEns;
import com.iit.model.Niveau;
import com.iit.model.NiveauGroupe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG
 */
public class MatiereEnsDAO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public ArrayList listgroupematiere(int id_ens) {
        ArrayList<MatiereEns> mEns = new ArrayList<MatiereEns>();
        try {

            MatiereEns mE;
            Matiere m;
            Groupe g;
            ResultSet rs = connection.select("select * from matiere_ens me, groupe g , matiere m where id_ens='" + id_ens + "'  and me.id_g=g.id and me.id_m=m.id_m;");
            while (rs.next()) {

                m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
                g = new Groupe(rs.getInt("id"), rs.getString("nom"), rs.getString("code"));
                mE = new MatiereEns(rs.getInt("id_me"), g, m);

                mEns.add(mE);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return mEns;
    }

    public ArrayList listMatiereNonGroupe(int id_g) {
        ArrayList<Matiere> mNotEns = new ArrayList<Matiere>();
        try {

            Matiere m;

            ResultSet rs = connection.select("select * from matiere m where m.id_m not in (select id_m from matiere_ens where id_g='" + id_g + "' )  ;");
            while (rs.next()) {
                m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
                mNotEns.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return mNotEns;
    }

    public ArrayList listMatiereGroupe(int id_g) {
        ArrayList<Matiere> mNotEns = new ArrayList<Matiere>();
        try {

            Matiere m;

            ResultSet rs = connection.select("select * from matiere m where m.id_m  in (select id_m from matiere_ens where id_g='" + id_g + "' )  ;");
            while (rs.next()) {
                m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
                mNotEns.add(m);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return mNotEns;
    }

    public void ajouterMatiereEns(MatiereEns mE) {

        connection.update("insert into matiere_ens values(null,'" + mE.getId_ens().getId() + "','" + mE.getId_m().getId() + "','" + mE.getId_g().getId() + "') ; ");

    }

    public MatiereEns getMatiereEns(int id_g, int id_m) {
        MatiereEns m = null;
        try {
            ResultSet rs = connection.select("select * from matiere_ens  where id_m='" + id_m + "'  and id_g='" + id_g + "';");
            rs.first();
            Matiere mat = new Matiere(rs.getInt("id_m"));
            Enseignant ens = new Enseignant(rs.getInt("id_ens"));
            Groupe gro = new Groupe(rs.getInt("id_g"));
            m = new MatiereEns(rs.getInt("id_me"), ens, gro, mat);
            return m;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return m;
    }

    public ArrayList listGroupeEns(String id_ens) {
        ArrayList<NiveauGroupe> mgroupe = new ArrayList();
        Groupe g;
        NiveauGroupe nG;
        Niveau n;
        try {
            ResultSet rs = connection.select("SELECT distinct id_g, g.*,n.* from matiere_ens m  , groupe g , niveau n where m.id_ens='" + id_ens + "' and g.id=m.id_g and n.id_n=g.id_n ;");
           
            while (rs.next()) {
                n = new Niveau(rs.getString("nom_n"), rs.getString("code_n"));
                g = new Groupe(rs.getInt("id"), rs.getString("nom"), rs.getString("code"));
                nG = new NiveauGroupe(g,n);
                mgroupe.add(nG);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return mgroupe;
    }

    public ArrayList listmatiereEns(String id_ens, int id_g) {
        ArrayList<MatiereEns> mEns = new ArrayList<MatiereEns>();
        try {

            MatiereEns mE;
            Matiere m;
            Groupe g;
            ResultSet rs = connection.select("select * from matiere_ens me, groupe g , matiere m where me.id_ens='" + id_ens + "' and me.id_g='" + id_g + "'  and  me.id_g=g.id and me.id_m=m.id_m;");
            while (rs.next()) {
                m = new Matiere(rs.getInt("id_m"), rs.getString("nom_m"));
                g = new Groupe(rs.getInt("id"), rs.getString("nom"), rs.getString("code"));
                mE = new MatiereEns(rs.getInt("id_me"), g, m);

                mEns.add(mE);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return mEns;
    }
    
     

}
