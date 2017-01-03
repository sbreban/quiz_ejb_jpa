package servlet;

import model.Test;
import model.User;
import stateless.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

  @EJB
  UserService userService;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    doPost(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    RequestDispatcher rd;
    String login = req.getParameter("name");
    String password = req.getParameter("password");

    try {
      User user = userService.getUser(login, password);
      if (user != null) {
        HttpSession session = req.getSession();
        session.setAttribute("user", login);
        session.setMaxInactiveInterval(60);
        int level = 1;
        if (user.getTests() != null) {
          for (Test test : user.getTests()) {
            if (test.getLevel() > level) {
              level = test.getLevel();
            }
          }
        }
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