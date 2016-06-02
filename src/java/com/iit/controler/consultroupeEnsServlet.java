/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EtudiantDAO;
import com.iit.dao.MatiereEnsDAO;
import com.iit.dao.NoteDAO;
import com.iit.dao.SessionDAO;
import com.iit.model.Etudiant;
import com.iit.model.MatiereEns;
import com.iit.model.NiveauGroupe;
import com.iit.model.Note;
import com.iit.model.NoteEtud;
import com.iit.model.Session;
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
@WebServlet(name = "consultroupeEnsServlet", urlPatterns = {"/consultroupeEnsServlet"})
public class consultroupeEnsServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            MatiereEnsDAO mEDAO = new MatiereEnsDAO();
            if(request.getParameter("id_event")!=null)
            {
             if (request.getParameter("id_event").equals("note")) 
             {
                 
                 ArrayList<Session> session = new ArrayList();
                 SessionDAO sDAO= new SessionDAO();
                
                 session=sDAO.listSession();
                 request.setAttribute("sess", session);
                 request.setAttribute("id_me", request.getParameter("id_matEns"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultationNotEns.jsp");
                rd.forward(request, response);
                 
             }
              else if (request.getParameter("id_event").equals("show")) {
                 ArrayList<Session> session = new ArrayList();
                 SessionDAO sDAO= new SessionDAO();
                
                 session=sDAO.listSession();
                 request.setAttribute("sess", session);
                 request.setAttribute("id_me", request.getParameter("id_mat"));
                  ArrayList<Note> mNote = new ArrayList<Note>();
                  ArrayList<NoteEtud> listeNote = new ArrayList<>();
                  NoteDAO nDAO = new NoteDAO();
                  EtudiantDAO eDAO = new EtudiantDAO();
                  mNote=nDAO.listNoteMatiere(Integer.parseInt(request.getParameter("id_mat")), Integer.parseInt(request.getParameter("id_s")));
                  Etudiant e;
                    NoteEtud nEtud;
                    for (int i=0;i<mNote.size();i++)
                    {   
                       e= eDAO.getEtud(String.valueOf(mNote.get(i).getIdEt()));
                       nEtud= new NoteEtud(mNote.get(i), e);
                       listeNote.add(nEtud);
                    }
                    
                  
                  request.setAttribute("ListNote",listeNote);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultationNotEns.jsp");
                rd.forward(request, response);
              }
            }
             else if (request.getParameter("id_g") != null) {
                 
                
                ArrayList<MatiereEns> ListM = mEDAO.listmatiereEns(String.valueOf(request.getSession().getAttribute("ens")),Integer.parseInt(request.getParameter("id_g")) );
                request.setAttribute("listM", ListM);
                ArrayList<NiveauGroupe> ListG = mEDAO.listGroupeEns(String.valueOf(request.getSession().getAttribute("ens")));
                out.println("nabil basggsas");
                request.setAttribute("matens", ListG);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultationGroupeEns.jsp");
                rd.forward(request, response);
                

            } else {
              
                out.println(String.valueOf( request.getSession().getAttribute("ens")));
                ArrayList<NiveauGroupe> ListG = mEDAO.listGroupeEns(String.valueOf(request.getSession().getAttribute("ens")));
                out.println("nabil basggsas");
                request.setAttribute("matens", ListG);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/consultationGroupeEns.jsp");
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
