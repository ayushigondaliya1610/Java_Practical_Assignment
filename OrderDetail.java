/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package abc.fashion_store.controller;

import abc.fashion_store.dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String newPassword = request.getParameter("password");

        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("resetEmail");

        UserDAO dao = new UserDAO();
        dao.updatePassword(email, newPassword);

        session.invalidate(); // security

        response.sendRedirect("login.jsp?msg=resetSuccess");
    }
}
