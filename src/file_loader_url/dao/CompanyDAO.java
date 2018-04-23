/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_loader_url.dao;

import file_loader_url.entities.Company;
import java.util.List;

/**
 *
 * @author kiran
 */
public interface CompanyDAO {
   
    List<Company> getAll();
    boolean insert (Company c);
    Company getById(int id);
            
    
}
