package goograde;

import java.lang.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the controller for Announcement. All it does is post the announcement.
 *
 * @author bluGoo
 * @version 0.42
 */
public class AnnouncementController extends HttpServlet
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    /**
     * Posts an announcement. This will call the functions needed 
     * to save to the database.
     * @param title The title
     * @param post The post body
     * @return false if fail, true if pass.
     */
    boolean postEmail(String title, String post)
    {
        return false;
    }
}

