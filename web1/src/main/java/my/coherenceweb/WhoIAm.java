package my.coherenceweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by matrix on 14-9-19.
 */
@WebServlet(name = "WhoIAm", urlPatterns = "/whoiam")
public class WhoIAm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Object user = httpServletRequest.getSession().getAttribute("user");
        PrintWriter writer = httpServletResponse.getWriter();
        if(null == user) {
            writer.write("I Don't Know you.");
        } else {
            writer.printf("Welcome %s", user);
        }
        writer.flush();
        writer.close();
    }
}
