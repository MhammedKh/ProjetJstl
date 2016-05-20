/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.controler;

import com.iit.dao.EtudiantDAO;
import com.iit.dao.GroupeDAO;
import com.iit.dao.MatiereEnsDAO;
import com.iit.model.Etudiant;
import com.iit.model.Groupe;
import com.iit.model.Matiere;
import com.iit.model.Niveau;
import com.iit.model.NiveauGroupe;
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
@WebServlet(name = "EcrireNumeroCompostage", urlPatterns = {"/EcrireNumeroCompostage"})
public class EcrireNumeroCompostage extends HttpServlet {

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
            GroupeDAO Groupe = new GroupeDAO();

            if (request.getParameter("id_event") != null) {

                if (request.getParameter("id_event").equals("mat")) {

                    MatiereEnsDAO mE = new MatiereEnsDAO();

                    ArrayList<Matiere> mGroupe = new ArrayList<Matiere>();
                    mGroupe = mE.listMatiereGroupe(Integer.parseInt(request.getParameter("id_g")));

                    Groupe g = Groupe.getGroupe(request.getParameter("id_g"));
                    request.setAttribute("groupe", g);
                    request.setAttribute("matiereList", mGroupe);

                    request.setAttribute("id_session", request.getParameter("id_s"));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/EcrireNumerodeCompostage.jsp");
                    rd.forward(request, response);
                } else if (request.getParameter("id_event").equals("form")) {
                    EtudiantDAO mE = new EtudiantDAO();
                    ArrayList<Etudiant> mEtud = mE.listEtudGroupe(Integer.parseInt(request.getParameter("group")));
                    request.setAttribute("mat_ens", new MatiereEnsDAO().getMatiereEns(Integer.parseInt("group"), Integer.parseInt("matiere")));
                    request.setAttribute("ListEtud", mEtud);
                    request.setAttribute("id_session", request.getParameter("sess"));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/EcrireNumerodeCompostage.jsp");
                    rd.forward(request, response);
                }
            } else {

                ArrayList<NiveauGroupe> groupList = new ArrayList<NiveauGroupe>();

                groupList = Groupe.listGroupe();

                request.setAttribute("groupList", groupList);
                request.setAttribute("id_session", request.getParameter("id_s"));

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/EcrireNumerodeCompostage.jsp");
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
