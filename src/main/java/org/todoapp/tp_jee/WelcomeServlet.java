package org.todoapp.tp_jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet2")
public class WelcomeServlet extends HttpServlet {

    // Toute requête de type "post" ayant pour destination /servlet2 sera traitée
    // dans la fonction doPost
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Recuperation du nom d'utilisateur à partir de la requête
        String n=request.getParameter("username");

        // Ecrire un message de Welcome + affichage du nom d'utilisateur
        out.print("Welcome "+n);

        out.close();
    }

}  