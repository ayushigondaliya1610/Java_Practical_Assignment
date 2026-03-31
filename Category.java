/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package abc.fashion_store.controller;

import abc.fashion_store.dao.ProductDAO;
import abc.fashion_store.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();
        List<Product> productList = dao.getAllProducts();

        request.setAttribute("products", productList);
        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
        rd.forward(request, response);
    }
}
