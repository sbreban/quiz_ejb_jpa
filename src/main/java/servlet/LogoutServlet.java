package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Sergiu on 18.01.2016.
 */
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    //invalidate the session if exists
    HttpSession session = request.getSession(false);
    System.out.println("User="+session.getAttribute("user"));
    session.invalidate();
    response.sendRedirect("index.jsp");
  }

}
