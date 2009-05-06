package goograde;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A controller for passwords since they need to be validated and such.
 *
 * @author bluGoo
 * @version 0.42
 */
public class PasswordController extends HttpServlet
{

    /**
     * do Post carries through an HTTP POST request
     * @param req the request class
     * @param resp the response class
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    /**
     * validate ensures that the password meets requirements in the SRS security
     * requirements
     * @param passwd the password to be analyzed
     * @return true if the password meets requirements
     */
    public boolean validate(String passwd)
    {
        return false;
    }
}

