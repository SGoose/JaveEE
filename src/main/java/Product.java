import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Random;


@WebServlet(name = "Product", urlPatterns = "/product")
public class Product implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(Product.class);

    private transient ServletConfig config;

    private int id;
    private String title;
    private double cost;



    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request");

        res.getWriter().println("<html><body><h1>Servlet content</h1><table>");
        res.getWriter().printf("<tr><th>id</th><th>title</th><th>cost</th></tr>");

        for(int i=1; i<=10;i++){
            res.getWriter().println("<tr><td>"+i+"</td><td>"+ getProduct(getRandom())+"<td>" + getRandom() +"</td></tr>");
        }
        res.getWriter().println("</table></body></html>");

    }

    @Override
    public String getServletInfo() {
        return "Product";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());

    }
    public static int getRandom () {
        Random r = new Random();
        int low = 0;
        int high = 9;
        int result = r.nextInt(high-low) + low;
        return result;
    }
    public static String getProduct(int masId){
        String[] product = new String[]{"Milk","PC","Cat","Dog","DVD","Axe","Wood","Window","Core","Web"};
        return product[masId];
    }
}
