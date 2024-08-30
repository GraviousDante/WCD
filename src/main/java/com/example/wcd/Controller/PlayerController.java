package com.example.wcd.Controller;

import com.example.wcd.Entity.Player;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/player")
public class PlayerController extends HttpServlet {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    @Override
    public void init() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            var player = entityManager.createStoredProcedureQuery("getPlayer", Player.class).getResultList();
            req.setAttribute("player", player);
            req.getRequestDispatcher("views/class/player.jsp").forward(req, resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        try {
            if (method.equals("DELETE")) {
                doDelete(req, resp);
            }
            else if (method.equals("PUT")) {
                doPut(req, resp);
            }
            else {
                System.out.println("PlayerController doPost");
                var name = req.getParameter("name");
                int index_id = Integer.parseInt(req.getParameter("index_id"));

                var player = new Player();
                player.setName(name);
                player.setIndex_id(index_id);
                entityManager.getTransaction().begin();
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("INSERT_PLAYER");
                query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
                query.setParameter(1, name);
                query.setParameter(2, index_id);

                query.executeUpdate();
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }
}
