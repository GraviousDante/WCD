package com.example.wcd.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class HomeController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Init HomeController");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            req.getRequestDispatcher("/views/home/home.jsp").forward(req,resp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
