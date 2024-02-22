package org.todoapp.tp_jee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlet1")
public class Firstservlet extends HttpServlet {
    // Toute requête de type "post" ayant pour destination /servlet1 sera traitée
    // dans la fonction doPost
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Le getWriter permet d'écrire du contenu HTML au niveau de l'affichage de la page
        PrintWriter out = response.getWriter();

        // Les valeurs des champs "username" et "userpass" de la requête sont stockées
        // dans n et p
        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        // Vérifier si l'utilisateur ayant le username n et le mdp p existe dans la BD
        if(LoginDao.validate(n, p)){
            // L'utilisateur existe donc on fait une redirection au servlet2
            RequestDispatcher rd=request.getRequestDispatcher("servlet2");
            rd.forward(request,response);
        }
        else{
            // L'utilisateur n'existe pas et donc affichage d'un message d'erreur
            out.print("Sorry username or password error");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request,response);
        }

        // Fermeture de out
        out.close();
    }
}  