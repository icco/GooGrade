package GooGrade;

import java.io.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is to deal with files. This is not a good implementation. 
 *
 * @author bluGoo
 * @version 0.42
 */
public class FileController
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
    }

    /**
     * Upload to system.
     * @param filename to be uploaded 
     * @return true if successful, false if error.
     */
    public boolean upload(File filename)
    {

        return false;
    }

    /**
     * Download a file.
     * @param filename to be downloaded
     * @return true if successful, false if error.
     */
    public boolean download(File filename)
    {

        return false;
    }

    /**
     * Delete a file.
     * @param filename to be deleted
     * @return true if successful, false if error.
     */
    public boolean delete(File filename)
    {

        return false;
    }
}
