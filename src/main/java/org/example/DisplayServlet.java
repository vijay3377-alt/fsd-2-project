package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<html>");

        out.println("<head>");

        out.println("<title>Registered Users</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background-color: #f2f2f2;");
        out.println("}");

        out.println("h2 {");
        out.println("text-align: center;");
        out.println("}");

        out.println("table {");
        out.println("width: 95%;");
        out.println("margin: auto;");
        out.println("border-collapse: collapse;");
        out.println("background-color: white;");
        out.println("}");

        out.println("th, td {");
        out.println("border: 1px solid black;");
        out.println("padding: 10px;");
        out.println("text-align: center;");
        out.println("}");

        out.println("th {");
        out.println("background-color: #007bff;");
        out.println("color: white;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");


        out.println("<h2>Registered Users</h2>");


        out.println("<table>");


        out.println("<tr>");

        out.println("<th>ID</th>");

        out.println("<th>Full Name</th>");

        out.println("<th>Email</th>");

        out.println("<th>Phone</th>");

        out.println("<th>Password</th>");

        out.println("<th>Gender</th>");

        out.println("<th>Address</th>");

        out.println("</tr>");


        String sql =
                "SELECT * FROM users";


        try {

            Connection connection =
                    DBConnection.getConnection();


            PreparedStatement statement =
                    connection.prepareStatement(sql);


            ResultSet resultSet =
                    statement.executeQuery();


            while (resultSet.next()) {

                int id =
                        resultSet.getInt("id");

                String fullname =
                        resultSet.getString("fullname");

                String email =
                        resultSet.getString("email");

                String phone =
                        resultSet.getString("phone");

                String password =
                        resultSet.getString("password");

                String gender =
                        resultSet.getString("gender");

                String address =
                        resultSet.getString("address");


                out.println("<tr>");

                out.println("<td>" +
                        id +
                        "</td>");

                out.println("<td>" +
                        fullname +
                        "</td>");

                out.println("<td>" +
                        email +
                        "</td>");

                out.println("<td>" +
                        phone +
                        "</td>");

                out.println("<td>" +
                        password +
                        "</td>");

                out.println("<td>" +
                        gender +
                        "</td>");

                out.println("<td>" +
                        address +
                        "</td>");

                out.println("</tr>");
            }


            resultSet.close();

            statement.close();

            connection.close();


        } catch (Exception e) {

            e.printStackTrace();

            out.println(
                    "<tr><td colspan='7'>" +
                            e.getMessage() +
                            "</td></tr>"
            );
        }


        out.println("</table>");

        out.println("<br><br>");

        out.println(
                "<center>" +
                        "<a href='registration.html'>" +
                        "Register New User" +
                        "</a>" +
                        "</center>"
        );


        out.println("</body>");

        out.println("</html>");
    }
}