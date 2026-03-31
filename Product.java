/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package abc.fashion_store.controller;

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
@WebServlet("/verifyOtp")
public class VerifyOtpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enteredOtp = request.getParameter("otp");

        HttpSession session = request.getSession(false);
        String sessionOtp = (String) session.getAttribute("otp");

        if (sessionOtp != null && sessionOtp.equals(enteredOtp)) {
            response.sendRedirect("resetPassword.jsp");
        } else {
            response.sendRedirect("enterOtp.jsp?error=1");
        }
    }
}
