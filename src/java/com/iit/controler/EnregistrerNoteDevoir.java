/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.NoteDAO;
import com.iit.model.Note;
import com.iit.model.NoteEns;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.NoSuchElementException;
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
@WebServlet(name = "EnregistrerNoteDevoir", urlPatterns = {"/EnregistrerNoteDevoir"})
public class EnregistrerNoteDevoir extends HttpServlet {

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
            Enumeration param = request.getParameterNames();
            int idMe = Integer.parseInt(request.getParameter("mat_ens"));
            int idSess = Integer.parseInt(request.getParameter("sessin"));

            param.nextElement();
            param.nextElement();
            param.nextElement();
            int idEtud;
            NoteDAO nDAO = new NoteDAO();
            NoteEns n;
            String tp;
            String ds;
            String precense;
            while (param.hasMoreElements()) {
                idEtud = Integer.parseInt(request.getParameter((String) param.nextElement()));
               
                    tp = request.getParameter((String) param.nextElement());
                    if(tp=="")
                        tp="-1";
                    ds = request.getParameter((String) param.nextElement());
                    if(ds=="")
                        ds="-1";
                        tp="-1";
                    precense = request.getParameter((String) param.nextElement());
                    if(precense=="")
                        precense="-1";
                    
                n = new NoteEns(idMe, idEtud, idSess, tp, ds, precense);
                nDAO.insertNoteDevoir(n);
                
            }
            
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/saisieNote");
            rd.forward(request, response);

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
