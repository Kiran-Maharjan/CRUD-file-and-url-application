/*--
----This program does:
------Acts to switching for url read or file read
------ Reads data from JobsNepal.com
------- Reads data from file 
*/
package file_loader_url;

import file_loader_url.dao.CompanyDAO;
import file_loader_url.dao.CompanyDAOImpl;
import file_loader_url.entities.Company;
import file_loader_url.util.DataLoader;
import file_loader_url.util.FileHelper;
import file_loader_url.util.HttpClient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author kiran
 */
public class Program {

    public static void main(String[] args) throws IOException {

        String filename = "D:/java/File_and _URL_Loader/companies.csv";
        CompanyDAO companyDAO = new CompanyDAOImpl();

        try {
            DataLoader loader = new DataLoader(companyDAO);
        
            //---uncomment to load from file
           loader.loadFromFile(filename);
            
            //--uncomment to load form urls
           // loader.loadFromURL("http://jobsnepal.com");

            for (Company c : companyDAO.getAll()) {
                System.out.println(c);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
