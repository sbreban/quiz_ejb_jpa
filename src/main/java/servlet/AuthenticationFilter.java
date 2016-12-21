package servlet; /**
 * Created by Sergiu on 18.01.2016.
 */
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

  private ServletContext context;

  public void init(FilterConfig fConfig) throws ServletException {
    this.context = fConfig.getServletContext();
    this.context.log("AuthenticationFilter initialized");
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String uri = req.getRequestURI();
    this.context.log("Requested Resource::"+uri);

    HttpSession session = req.getSession(false);

    if(session == null && !(uri.endsWith("index.jsp") || uri.endsWith("loginServlet"))){
      res.sendRedirect("index.jsp");
      return;
    } else {
      if (session != null) {
        String user = (String)session.getAttribute("user");
        if (user == null && !(uri.endsWith("index.jsp") || uri.endsWith("loginServlet"))) {
          res.sendRedirect("index.jsp");
          return;
        }
      }
    }
    chain.doFilter(request, response);
  }

  public void destroy() {
    //close any resources here
  }

}
