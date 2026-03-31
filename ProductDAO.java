package abc.fashion_store.controller;

import abc.fashion_store.dao.UserDAO;
import abc.fashion_store.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginId = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.validateUser(loginId, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", user);
            session.setMaxInactiveInterval(30 * 60);

            response.sendRedirect("profile.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
