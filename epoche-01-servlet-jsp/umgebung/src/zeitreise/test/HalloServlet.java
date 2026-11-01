package zeitreise.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Wegwerf-Servlet fuer den Laufzeittest: nur Servlet-API-2.3-Klassen.
 */
public class HalloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hallo aus einem Servlet im 2.3-Stil");
        out.println("Container: " + context.getServerInfo());
        out.println("Servlet-API des Containers: "
                + context.getMajorVersion() + "." + context.getMinorVersion());
    }
}
