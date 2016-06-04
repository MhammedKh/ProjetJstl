/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;
import com.iit.model.MatEtud;
import com.iit.model.Matiere;

import com.iit.model.Note;
import com.iit.model.NoteEns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class NoteDAO {

    ConnectionBaseDonnee connection = new ConnectionBaseDonnee();

    public void ajouterCompostage(Note n) {

        connection.update("insert into note(id_m,id_e,id_s,n_comp) values('" + n.getIdMe() + "','" + n.getIdEt() + "','" + n.getId_Ses() + "','" + n.getNumCompostage() + "') ; ");

    }

    public synchronized void insertNoteDevoir(NoteEns n) {
        try {
            ResultSet rs = connection.select("select count(*) as nbr from note where id_m=" + n.getIdMe() + " and id_e=" + n.getIdEt() + " and  id_s=" + n.getId_Ses() + "  ;");
            rs.next();
            int exist = rs.getInt("nbr");
            // System.out.println(exist);
            if (exist == 0) {
                connection.update("insert into note(id_m,id_e,id_s,tp,ds,precence) values('" + n.getIdMe() + "','" + n.getIdEt() + "','" + n.getId_Ses() + "','" + n.getTp() + "','" + n.getDs() + "','" + n.getPresentielle() + "') ; ");
            } else {
                if (n.getTp() != "-1") {
                    connection.update("update  note set tp='" + n.getTp() + "' where id_m=" + n.getIdMe() + " and id_e= " + n.getIdEt() + " and id_s=" + n.getId_Ses() + " ; ");
                }

                if (n.getDs() != "-1") {
                    connection.update("update  note set ds='" + n.getDs() + "' where id_m=" + n.getIdMe() + " and id_e= " + n.getIdEt() + " and id_s=" + n.getId_Ses() + " ; ");
                }

                if (n.getPresentielle() != "-1") {
                    connection.update("update  note set precence='" + n.getPresentielle() + "' where id_m=" + n.getIdMe() + " and id_e= " + n.getIdEt() + " and id_s=" + n.getId_Ses() + " ; ");
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

    public synchronized void insertNoteExamain(NoteEns n) {

        if (n.getExamain() != "-1") {
            connection.update("update  note set examain='" + n.getExamain() + "' where id_m=" + n.getIdMe() + " and n_comp= " + n.getNumCompostage() + " and id_s=" + n.getId_Ses() + " ; ");
        }

    }
    
    public ArrayList listNoteEtudiant(int id_e, int id_ses) {
        ArrayList<MatEtud> lNote = new ArrayList<MatEtud>();
        try {
            Note n;
            Matiere m;
            MatEtud mE;
            double tp;
            double ds;
            double exa;
            double pres;
            ResultSet rsMat;
            ResultSet rs = connection.select("select * from note where id_e='" + id_e + "' and  id_s='" + id_ses + "'  ;");
            while (rs.next()) {

                if (rs.getString("tp") == null) {
                    tp = -1;
                } else {
                    tp = Double.parseDouble(rs.getString("tp"));
                }
                if (rs.getString("ds") == null) {
                    ds = -1;
                } else {
                    ds = Double.parseDouble(rs.getString("ds"));
                }
                if (rs.getString("examain") == null) {
                    exa = -1;
                } else {
                    exa = Double.parseDouble(rs.getString("examain"));
                }
                if (rs.getString("precence") == null) {
                    pres = -1;
                } else {
                    pres = Double.parseDouble(rs.getString("precence"));
                }
                n = new Note( tp, ds, exa, pres);
                rsMat = connection.select("select * from matiere_ens me, matiere m where me.id_me='" + rs.getString("id_m") + "' and m.id_m=me.id_m  ;");
               rsMat.first();
                
                m = new Matiere(rsMat.getString("nom_m"));
                mE = new MatEtud(m, n);

                lNote.add(mE);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

        return lNote;
    }
    

    public ArrayList listNoteMatiere(int id_me, int id_ses) {
        ArrayList<Note> lNote = new ArrayList<Note>();
        try {
            Note n;
            double tp;
            double ds;
            double exa;
            double pres;

            ResultSet rs = connection.select("select * from note where id_m='" + id_me + "' and  id_s='" + id_ses + "'  ;");
            while (rs.next()) {

                if (rs.getString("tp") == null) {
                    tp = -1;
                } else {
                    tp = Double.parseDouble(rs.getString("tp"));
                }
                if (rs.getString("ds") == null) {
                    ds = -1;
                } else {
                    ds = Double.parseDouble(rs.getString("ds"));
                }
                if (rs.getString("examain") == null) {
                    exa = -1;
                } else {
                    exa = Double.parseDouble(rs.getString("examain"));
                }
                if (rs.getString("precence") == null) {
                    pres = -1;
                } else {
                    pres = Double.parseDouble(rs.getString("precence"));
                }
                n = new Note(rs.getInt("id_e"), tp, ds, exa, pres, rs.getString("n_comp"));

                lNote.add(n);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

        return lNote;
    }

}
