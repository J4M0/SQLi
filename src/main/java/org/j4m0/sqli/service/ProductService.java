package org.j4m0.sqli.service;

import java.util.List;

import org.j4m0.sqli.dao.ProductDao;
import org.j4m0.sqli.dao.exception.DaoException;
import org.j4m0.sqli.entity.Product;
import org.j4m0.sqli.service.exception.ServiceException;

/**
 *
 * @author j4m0
 */
public class ProductService {
    
    public List<Product> findAll() throws ServiceException {
        try {
            ProductDao dao = new ProductDao();
            return dao.findAll();
        } catch (DaoException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public List<Product> findById(String id) throws ServiceException {
        try {
            ProductDao dao = new ProductDao();
            return dao.findById(id);
        } catch (DaoException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
