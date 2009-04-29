package goograde;

import java.util.*;
import java.lang.*;
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

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    public boolean validate(String passwd)
    {
        return false;
    }
}

