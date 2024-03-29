package com.servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        if (isValidName(username) && isValidPassword(password) && username.equals("Admin") && password.equals("Password@123")) {
            response.sendRedirect("LoginSucces.jsp");
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            if (!isValidName(username)) {
                out.println("<font color=red>Please enter a valid name starting with a capital letter and having a minimum of three characters.</font>");
            } else if (!isValidPassword(password)) {
                out.println("<font color=red>Please enter a valid password adhering to the specified rules.</font>");
            } else {
                out.println("<font color=red>Incorrect Credential</font>");
            }
            requestDispatcher.include(request, response);
        }
    }

    private boolean isValidName(String name) {
        // Check if the name starts with a capital letter and has a minimum of three characters
        return name.matches("[A-Z][a-zA-Z]{2,}");
    }

    private boolean isValidPassword(String password) {
        // Check if the password adheres to the specified rules
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
