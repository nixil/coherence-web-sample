package my.coherenceweb;

import com.tangosol.net.CacheFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by matrix on 14-9-15.
 */
@WebServlet(name = "CoherenceWebServlet1", urlPatterns = "/coherence-web")
public class CoherenceWebServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter writer = httpServletResponse.getWriter();
        try {
            String clusterName = CacheFactory.getCluster().getClusterName();
            writer.println(clusterName);
            writer.println();
            writer.flush();
        } catch (Exception e) {
            throw new ServletException(e);
        }finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doPost(httpServletRequest, httpServletResponse);
    }
}
