/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Usermanagement;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Hibernate;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class UserManagementDAO implements InterfaceDAO{

    private FunctionsDAO fdao;
    public UserManagementDAO() {
        
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }

    @Override
    public boolean insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Usermanagement ORDER by id");
    
    }

    @Override
    public List<Object> search(String category, String search) {
      return fdao.getAll("FROM Usermanagement where "+category+" LIKE '%"+search+"%' ORDER by id");
   
    }

    @Override
    public Object getById(String id) {
       return fdao.getById("FROM Usermanagement where id = "+id+"");
    }
    
        public boolean login(String id, String password) {
        Usermanagement um = (Usermanagement) getById(id);
        return BCrypt.checkpw(password, um.getPassword());
    }
    
}

    
   