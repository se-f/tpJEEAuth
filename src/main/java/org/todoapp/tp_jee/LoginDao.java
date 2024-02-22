package org.todoapp.tp_jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static boolean validate(String name,String pass){
        boolean status=false;
        try{
            // Charger JDBC avec Class.forName
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Création de connection en specifiant l'URL, le username et le passwsord de la BD
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/tpjee","root","");

            // Preparation du statement
            PreparedStatement ps=con.prepareStatement(
                    "select * from userreg where name=? and pass=?");
            // Affectation des valeurs "?" de la requête avec le nom et le mdp
            // spécifiés dans les paramètres de la fonction
            ps.setString(1,name);
            ps.setString(2,pass);

            // Execution de la requête
            ResultSet rs=ps.executeQuery();

            // Status==1 donc la requête retourne la ligne qui correspond à l'utilisateur, 0 sinon
            status=rs.next();

        }catch(Exception e){System.out.println(e);}
        return status;
    }
}