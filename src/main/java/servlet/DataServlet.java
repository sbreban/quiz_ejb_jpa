package servlet;

import model.Test;
import stateless.TestService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class DataServlet extends HttpServlet {

  @EJB
  TestService testService;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/html");

    HttpSession httpSession = request.getSession();
    int level = (Integer) httpSession.getAttribute("level");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Tests</title>");
    out.println("</head>");
    out.println("<body>");

    String context = request.getContextPath() + "/questionServlet";

    try {
      List<Test> tests = testService.getTests(level);
      for (Test test : tests) {
        out.println("<form action=\"" + context + "\" method=\"get\">");
        out.println("<input type=\"text\" name=\"testId\" value=\"" + test.getId() + "\"/>");
        out.println("<input type=\"submit\" value=\"" + test.getName() + " Level "
            + test.getLevel() + "\"/>");
        out.println("</form>");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}


 