/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EnseignantADO;
import com.iit.dao.EtudiantDAO;
import com.iit.dao.GroupeDAO;
import com.iit.dao.MatiereEnsDAO;
import com.iit.model.Enseignant;
import com.iit.model.Etudiant;
import com.iit.model.Groupe;
import com.iit.model.Matiere;
import com.iit.model.MatiereEns;
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
@WebServlet(name = "ActionGroupeServlet", urlPatterns = {"/ActionGroupeServlet"})
public class ActionGroupeServlet extends HttpServlet {

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
             GroupeDAO gDAO = new GroupeDAO();
            if (request.getParameter("id_event").equals("form")) {
                if (request.getParameter("action").equals("ajout")) {
                    
                        Groupe g = new Groupe(request.getParameter("nom"), request.getParameter("code"), request.getParameter("niveau"));

                        gDAO.ajouterGroupe(g);
                       RequestDispatcher rd = getServletContext().getRequestDispatcher("/GroupeServlet");
                        rd.forward(request, response);
                    
                    }
                else{
                    
                     Groupe g = new Groupe(Integer.parseInt( request.getParameter("group")),request.getParameter("nom"), request.getParameter("code"), request.getParameter("niv"));
                    gDAO.modifierGroupe(g);
                     RequestDispatcher rd = getServletContext().getRequestDispatcher("/GroupeServlet");
                    rd.forward(request, response);
                    
                }
            } else if (request.getParameter("id_event").equals("edit")) {
                Groupe g = gDAO.getGroupe(request.getParameter("id_g"));
                request.setAttribute("group", g);
                request.setAttribute("btnmodif", "oui");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/GroupeServlet");
                rd.forward(request, response);

            }else if(request.getParameter("id_event").equals("zoom"))
            {
                
               MatiereEnsDAO  mEnsDAO = new  MatiereEnsDAO();
               EnseignantADO ensDAO = new EnseignantADO();
               ArrayList<Matiere> listMatGroup = mEnsDAO.listMatiereGroupe(Integer.parseInt(request.getParameter("id_g")));
               ArrayList<Matiere> listMatNonGroup = mEnsDAO.listMatiereNonGroupe(Integer.parseInt(request.getParameter("id_g")));
               ArrayList<Enseignant> listEns = ensDAO.listEns();
               request.setAttribute("group", request.getParameter("id_g"));
               request.setAttribute("ListE", listEns);
               request.setAttribute("ListM", listMatGroup);
               request.setAttribute("ListNonG", listMatNonGroup);
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/listeMatiereGroupe.jsp");
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
