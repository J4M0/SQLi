package org.j4m0.sqli.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.j4m0.sqli.dao.exception.DaoException;
import org.j4m0.sqli.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author j4m0
 */
public class UserDao extends BaseDao {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    
    public User login(final String username, final String password) 
            throws DaoException {
        try (final Connection conn = this.getConnection()) {
            User user = null;
            final String query = "SELECT * FROM user WHERE username = '"
                    + username + "' AND password = '" + password + "'";
            LOGGER.debug(query);
            final Statement s =  conn.createStatement();
            final ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setId(rs.getLong("id"));
                user.setLastName(rs.getString("last_name"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new DaoException(ex.getMessage(), ex);
        }
    }
    
}
