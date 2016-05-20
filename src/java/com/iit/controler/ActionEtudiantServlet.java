/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EnseignantADO;
import com.iit.dao.EtudiantDAO;
import com.iit.model.Enseignant;
import com.iit.model.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ActionEtudiantServlet", urlPatterns = {"/ActionEtudiantServlet"})
public class ActionEtudiantServlet extends HttpServlet {

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
            EtudiantDAO etudDAO = new EtudiantDAO();
            if (request.getParameter("id_event").equals("form")) {
                if (request.getParameter("action").equals("ajout")) {
                    if (request.getParameter("Passe").equals(request.getParameter("c_Passe"))) {
                        Etudiant e = new Etudiant(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("Iden"), request.getParameter("Passe"), request.getParameter("adr"), request.getParameter("tel"), Integer.parseInt(request.getParameter("cin")), request.getParameter("groupe"));
                        
                        etudDAO.ajouteretud(e);
                       RequestDispatcher rd = getServletContext().getRequestDispatcher("/EtudiantServlet");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("erreur", "Le champs confirmer mot de passe invalide  ");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/EtudiantServlet");
                        rd.forward(request, response);
                    }
                }else{
                    Etudiant e = new Etudiant( Integer.parseInt(request.getParameter("etud")), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adr"), request.getParameter("tel"), Integer.parseInt(request.getParameter("cin")), request.getParameter("groupe"));
                    etudDAO.modifierEns(e);
                     RequestDispatcher rd = getServletContext().getRequestDispatcher("/EtudiantServlet");
                    rd.forward(request, response);
                    
                }
            } else if (request.getParameter("id_event").equals("edit")) {
                Etudiant e = etudDAO.getEtud(request.getParameter("id_e"));
                request.setAttribute("etud", e);
                request.setAttribute("btnmodif", "oui");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/EtudiantServlet");
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
