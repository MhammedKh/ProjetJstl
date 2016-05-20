/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EnseignantADO;
import com.iit.model.Enseignant;
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
@WebServlet(name = "ListEnseignantServlet", urlPatterns = {"/ActionEnseignantServlet"})
public class ActionEnseignantServlet extends HttpServlet {

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
            EnseignantADO ensADO = new EnseignantADO();
            if (request.getParameter("id_event").equals("form")) {
                if (request.getParameter("action").equals("ajout")) {
                    if (request.getParameter("Passe").equals(request.getParameter("c_Passe"))) {
                        Enseignant e = new Enseignant(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("Iden"), request.getParameter("Passe"), request.getParameter("adr"), request.getParameter("tel"), Integer.parseInt(request.getParameter("cin")));
                        ensADO.ajouterEns(e);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/EnseignantServlet");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("erreur", "Le champs confirmer mot de passe invalide  ");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/EnseignantServlet");
                        rd.forward(request, response);
                    }
                }else{
                    Enseignant e = new Enseignant( Integer.parseInt(request.getParameter("ens")), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adr"), request.getParameter("tel"), Integer.parseInt(request.getParameter("cin")));
                    ensADO.modifierEns(e);
                     RequestDispatcher rd = getServletContext().getRequestDispatcher("/EnseignantServlet");
                    rd.forward(request, response);
                    
                }
            } else if (request.getParameter("id_event").equals("edit")) {
                Enseignant e = ensADO.getEns(request.getParameter("id_e"));
                request.setAttribute("ens", e);
                request.setAttribute("btnmodif", "oui");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/EnseignantServlet");
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
