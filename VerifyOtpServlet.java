/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package abc.fashion_store.controller;

import abc.fashion_store.dao.DBConnection;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "categoryServlet", urlPatterns = {"/categoryServlet"})
public class categoryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    String name = req.getParameter("category_name");

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO category(category_name) VALUES(?)");
        ps.setString(1, name);
        ps.executeUpdate();
        res.sendRedirect("categoryList.jsp");
    } catch (IOException | SQLException e) {
    }
}


}
