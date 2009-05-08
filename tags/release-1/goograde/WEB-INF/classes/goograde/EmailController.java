package goograde;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This deals with sending emails.
 *
 * @author bluGoo
 * @version 0.42
 */
public class EmailController extends HttpServlet
{

    /**
     * doPost handles an HTTP POST request
     * @param req the request
     * @param resp the response
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    /**
     * Sends the email once it has been written.
     */
    public void send()
    {
    }
}
