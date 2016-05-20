/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.GroupeDAO;
import com.iit.dao.NiveauDAO;
import com.iit.model.Groupe;
import com.iit.model.Niveau;
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
@WebServlet(name = "ActionNiveauServlet", urlPatterns = {"/ActionNiveauServlet"})
public class ActionNiveauServlet extends HttpServlet {

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
            NiveauDAO nDAO = new NiveauDAO();
            if (request.getParameter("id_event").equals("form")) {
                if (request.getParameter("action").equals("ajout")) {
                    
                        Niveau n = new Niveau(request.getParameter("nom"), request.getParameter("code"));

                        nDAO.ajouterNiveau(n);
                       RequestDispatcher rd = getServletContext().getRequestDispatcher("/NiveauServlet");
                        rd.forward(request, response);
                    
                    }
                else{
                    //out.println(request.getParameter("niveau")+" "+request.getParameter("nom")+" "+request.getParameter("code"));
                    Niveau n = new Niveau(Integer.parseInt(request.getParameter("niveau")),request.getParameter("nom"), request.getParameter("code"));
                    nDAO.modifierNiveau(n);
                     RequestDispatcher rd = getServletContext().getRequestDispatcher("/NiveauServlet");
                    rd.forward(request, response);
                    
                }
            } else if (request.getParameter("id_event").equals("edit")) {
                Niveau n = nDAO.getNiveau(request.getParameter("id_n"));
                request.setAttribute("niveau", n);
                request.setAttribute("btnmodif", "oui");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/NiveauServlet");
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
