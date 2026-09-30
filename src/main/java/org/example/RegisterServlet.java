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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get data from registration form

        String fullname = request.getParameter("fullname");

        String email = request.getParameter("email");

        String phone = request.getParameter("phone");

        String password = request.getParameter("password");

        String gender = request.getParameter("gender");

        String address = request.getParameter("address");


        String sql =
                "INSERT INTO users " +
                        "(fullname, email, phone, password, gender, address) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";


        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);


            statement.setString(1, fullname);

            statement.setString(2, email);

            statement.setString(3, phone);

            statement.setString(4, password);

            statement.setString(5, gender);

            statement.setString(6, address);


            int result =
                    statement.executeUpdate();


            if (result > 0) {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration Successful</title>");
                out.println("</head>");

                out.println("<body>");

                out.println("<h2>Registration Successful!</h2>");

                out.println("<p>Welcome " +
                        fullname +
                        "</p>");

                out.println("<br>");

                out.println(
                        "<a href='registration.html'>Register Another User</a>"
                );

                out.println("<br><br>");

                out.println(
                        "<a href='display'>View All Users</a>"
                );

                out.println("</body>");

                out.println("</html>");

            } else {

                out.println("<h2>Registration Failed</h2>");
            }


            statement.close();

            connection.close();


        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Database Error</h2>");

            out.println(
                    "<p>" + e.getMessage() + "</p>"
            );
        }
    }
}