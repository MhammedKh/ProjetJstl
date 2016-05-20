/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.NiveauDAO;
import com.iit.dao.SessionDAO;
import com.iit.model.Niveau;
import com.iit.model.Session;
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
@WebServlet(name = "ActionSessionServlet", urlPatterns = {"/ActionSessionServlet"})
public class ActionSessionServlet extends HttpServlet {

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
            SessionDAO sDAO = new SessionDAO();
            if (request.getParameter("id_event").equals("form")) {
                if (request.getParameter("action").equals("ajout")) {
                    
                        Session s = new Session(request.getParameter("type"), request.getParameter("date_d"), request.getParameter("date_f"));

                        sDAO.ajouterSession(s);
                       RequestDispatcher rd = getServletContext().getRequestDispatcher("/SessionServlet");
                        rd.forward(request, response);
                    
                    }
                else{
                    //out.println(request.getParameter("niveau")+" "+request.getParameter("nom")+" "+request.getParameter("code"));
                    Session s = new Session(Integer.parseInt(request.getParameter("session")),request.getParameter("type"), request.getParameter("date_d"), request.getParameter("date_f"));
                    sDAO.modifierSession(s);
                     RequestDispatcher rd = getServletContext().getRequestDispatcher("/SessionServlet");
                    rd.forward(request, response);
                    
                }
            } else if (request.getParameter("id_event").equals("edit")) {
                Session s = sDAO.getSession(request.getParameter("id_s"));
                request.setAttribute("session", s);
                request.setAttribute("btnmodif", "oui");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/SessionServlet");
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
