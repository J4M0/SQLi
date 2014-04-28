package org.j4m0.sqli.service;

import org.j4m0.sqli.dao.UserDao;
import org.j4m0.sqli.dao.exception.DaoException;
import org.j4m0.sqli.entity.User;
import org.j4m0.sqli.service.exception.ServiceException;

/**
 *
 * @author j4m0
 */
public class UserService extends BaseService {
    
    public User login (final String username, final String password) 
            throws ServiceException {
        try {
            final UserDao dao = new UserDao();
            return dao.login(username, password);
        } catch (final DaoException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
    
}
