package servlet;

import model.User;
import persistence.DatabaseUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    doPost(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    RequestDispatcher rd;
    String login = req.getParameter("name");
    String password = req.getParameter("password");

    try {
      User user = DatabaseUtil.getUser(login, password);
      if (user != null) {
        HttpSession session = req.getSession();
        session.setAttribute("user", login);
        session.setMaxInactiveInterval(60);
        int level = DatabaseUtil.getMaxLevel(user.getId());
        session.setAttribute("level", level);
        rd = req.getRequestDispatcher("/loginSuccess.jsp");
      } else {
        rd = req.getRequestDispatcher("/loginError.jsp");
      }
      rd.forward(req, res);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}