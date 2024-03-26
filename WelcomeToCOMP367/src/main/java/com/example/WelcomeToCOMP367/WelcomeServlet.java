package com.example.WelcomeToCOMP367;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Get the current hour
            int hour = java.time.LocalTime.now().getHour();

            // Determine the greeting based on the time of day
            String greeting;
            if (hour >= 0 && hour < 12) {
                greeting = "Good morning";
            } else if (hour >= 12 && hour < 18) {
                greeting = "Good afternoon";
            } else {
                greeting = "Good evening";
            }

            // Write HTML content with personalized greeting
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>Welcome to COMP367</title>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<h1>" + greeting + ", Welcome to COMP367</h1>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
        } finally {
            response.getWriter().close();
        }
    }
}
