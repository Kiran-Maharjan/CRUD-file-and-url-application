/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_loader_url.util;

import file_loader_url.dao.CompanyDAO;
import file_loader_url.dao.CompanyDAOImpl;
import file_loader_url.entities.Company;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author kiran
 */
public class DataLoader {
   private CompanyDAO companyDAO; //--but not instantiated as it may call for file or web
   //--so trick is
   public DataLoader(CompanyDAO companyDAO){
       this.companyDAO=companyDAO;
   }
   
   public  void loadFromFile(String fileName) throws IOException{
       
            for(String line:FileHelper.readLines(fileName)){
                String[] tokens=line.split(",");
                int id=Integer.parseInt(tokens[0]);
                
                if(companyDAO.getById(id)==null){
                   Company company=new Company();
                   company.setId(id);
                           
                   company.setName(tokens[1]);
                   company.setDescription(tokens[2]);
                   company.setAddedDate(new Date());
                   company.setStatus((tokens[3].equals("1")));
                   companyDAO.insert(company);
                }
            }
   }
   
   public void loadFromURL(String url) throws IOException{
       
       System.out.println(HttpClient.get(url));
   }
}
