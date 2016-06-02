/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EtudiantDAO;
import com.iit.dao.GroupeDAO;
import com.iit.dao.MatiereDAO;
import com.iit.dao.MatiereEnsDAO;
import com.iit.dao.NoteDAO;
import com.iit.model.Etudiant;
import com.iit.model.Groupe;
import com.iit.model.Matiere;
import com.iit.model.MatiereEns;
import com.iit.model.NiveauGroupe;
import com.iit.model.Note;
import com.iit.model.NoteEtud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SAMSUNG
 */
@WebServlet(name = "consultnote", urlPatterns = {"/consultnote"})
public class consultnote extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             GroupeDAO Groupe = new GroupeDAO();

            if (request.getParameter("id_event") != null) {

                if (request.getParameter("id_event").equals("mat")) {

                    MatiereEnsDAO mE = new MatiereEnsDAO();

                    ArrayList<Matiere> mGroupe ;
                    mGroupe = mE.listMatiereGroupe(Integer.parseInt(request.getParameter("id_g")));

                    Groupe g = Groupe.getGroupe(request.getParameter("id_g"));
                    request.setAttribute("groupe", g);
                    request.setAttribute("matiereList", mGroupe);

                    request.setAttribute("id_session", request.getParameter("id_s"));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultNoteAdmin.jsp");
                    rd.forward(request, response);
                } else if (request.getParameter("id_event").equals("form")) {
                    ArrayList<Note> mNote= new ArrayList<Note>();
                    NoteDAO mN = new NoteDAO();
                    EtudiantDAO eDAO= new EtudiantDAO();
                     MatiereEns mEns = new MatiereEnsDAO().getMatiereEns(Integer.parseInt(request.getParameter("group") ), Integer.parseInt(request.getParameter("matiere"))); 
                     
                     mNote = mN.listNoteMatiere(mEns.getId(),Integer.parseInt(request.getParameter("sess")));
                   
                     ArrayList<NoteEtud> listeNote= new ArrayList();
                    Etudiant e;
                    NoteEtud nEtud;
                    for (int i=0;i<mNote.size();i++)
                    {   
                       e= eDAO.getEtud(String.valueOf(mNote.get(i).getIdEt()));
                       nEtud= new NoteEtud(mNote.get(i), e);
                       listeNote.add(nEtud);
                    }
                    request.setAttribute("listN", listeNote);
                    request.setAttribute("nom_g", request.getParameter("nom_groupe"));
                   
                    request.setAttribute("matiere", new MatiereDAO().getMatiere(request.getParameter("matiere")));
                 
                   RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultNoteAdmin.jsp");
                    rd.forward(request, response);
                }
            } else {

                ArrayList<NiveauGroupe> groupList ;

                groupList = Groupe.listGroupe();

                request.setAttribute("groupList", groupList);
                request.setAttribute("id_session", request.getParameter("id_s"));

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultNoteAdmin.jsp");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
