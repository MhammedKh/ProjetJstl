/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.dao;

import com.iit.model.ConnectionBaseDonnee;

import com.iit.model.Note;
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

        connection.update("insert into note(id_m,id_e,id_s,n_comp) values('"+n.getIdMe()+"','" + n.getIdEt() + "','" + n.getId_Ses() + "','"+n.getNumCompostage()+"') ; ");
      

    }
    
       public ArrayList listNoteMatiere(int id_me , int id_ses ) {
        ArrayList<Note> lNote=new ArrayList<Note>();
        try {
            Note n;
            double tp;
            double ds;
            double exa;
            double pres;
                    

            ResultSet rs = connection.select("select * from note where id_m='"+id_me+"' and  id_s='"+id_ses+"'  ;");
            while (rs.next()) {
                
              if(rs.getString("tp")==null)
              {
                  tp=-1;
              }
              else
              {
                  tp=Double.parseDouble(rs.getString("tp"));
              }
              if(rs.getString("ds")==null)
              {
                  ds=-1;
              }
              else
              {
                 ds=Double.parseDouble(rs.getString("ds"));
              }
              if(rs.getString("examain")==null)
              {
                  exa=-1;
              }
               else
              {
                 exa=Double.parseDouble(rs.getString("examain"));
              }
              if(rs.getString("precence")==null)
              {
                  pres=-1;
              }
               else
              {
                 pres=Double.parseDouble(rs.getString("precence"));
              }
                n = new Note(rs.getInt("id_e"),tp  ,ds,exa, pres,rs.getString("n_comp") );
               
                lNote.add(n);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
           
        return lNote;
    }
}
