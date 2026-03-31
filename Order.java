/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package abc.fashion_store.controller;

import abc.fashion_store.dao.UserDAO;
import abc.fashion_store.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String captchaInput = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String captchaSession = (String) session.getAttribute("captcha");

        // CAPTCHA VALIDATION
        if (!captchaInput.equals(captchaSession)) {
            response.sendRedirect("register.jsp?captchaError=1");
            return;
        }

        User u = new User();
        u.setUsername(request.getParameter("username"));
        u.setLoginId(request.getParameter("login_id"));
        u.setPassword(request.getParameter("password"));
        u.setPasswordQuestion(request.getParameter("password_question"));
        u.setPasswordAnswer(request.getParameter("password_answer"));
        u.setEmail(request.getParameter("email"));
        u.setPhone(request.getParameter("phone"));
        u.setAddress(request.getParameter("address"));
        u.setCity(request.getParameter("city"));
        u.setState(request.getParameter("state"));
        u.setCountry(request.getParameter("country"));
        u.setPin(request.getParameter("pin"));

        UserDAO dao = new UserDAO();
        dao.insertUser(u);

        response.sendRedirect("login.jsp");
    }
}
