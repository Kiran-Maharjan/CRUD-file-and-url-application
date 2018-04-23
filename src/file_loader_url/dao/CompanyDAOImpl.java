/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_loader_url.dao;

import file_loader_url.entities.Company;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiran
 */
public class CompanyDAOImpl implements CompanyDAO{
    List<Company> companyList=new ArrayList<>();
    
    @Override
    public List<Company> getAll() {
        return companyList;
        }

    @Override
    public boolean insert(Company c) {
        return companyList.add(c);
    }

    @Override
    public Company getById(int id) {
        for(Company c:companyList){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }
    
}
