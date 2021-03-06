package goograde;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * This contatins static methods needed for various actions around the site.
 * 
 * @author nwelch
 */
public final class Utils
{
    /**
     * To overide defailt public construvtor
     */
    private Utils()
    {
       // So Checkstyle doesn't get mad
    }
    /**
     * Given a servlet request, get an account outta it's cookie.
     * 
     * @param req the incomming request.
     * @return an account.
     */
    public static Account getUseridCookie(HttpServletRequest req)
    {
        Account user1 = new Account();

        // Gets the cookie we want
        for (Cookie cook : req.getCookies())
        {
            // Get the id of the account and load it
            if (cook.getName().equals("userid"))
            {
                user1.setId(new Integer(cook.getValue()));
                user1.fetch();
            }
        }

        return user1;
    }
}
