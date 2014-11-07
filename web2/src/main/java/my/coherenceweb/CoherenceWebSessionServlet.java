package my.coherenceweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by matrix on 14-9-15.
 */
@WebServlet(name = "CoherenceWebSessionServlet2", urlPatterns = "/coherence-web-session")
public class CoherenceWebSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        UUID uuid = UUID.randomUUID();
        session.setAttribute(uuid.toString(),new SessionObject(uuid.toString()));
        Enumeration<String> attributeNames = session.getAttributeNames();
        PrintWriter writer = httpServletResponse.getWriter();
        while(attributeNames.hasMoreElements()){
            String attr = attributeNames.nextElement();
            Object attribute = session.getAttribute(attr);
            writer.printf("%s:%s", attr, attribute);
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doPost(httpServletRequest, httpServletResponse);
    }
}
