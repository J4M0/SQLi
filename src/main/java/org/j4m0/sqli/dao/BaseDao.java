package org.j4m0.sqli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.j4m0.sqli.dao.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author j4m0
 */
public abstract class BaseDao {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
    
    public Connection getConnection() throws DaoException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql_injection?useServerPrepStmts=true",
                "root","root");
            BaseDao.LOGGER.info("Se obtiene la conexión a la base de datos");
            return conn;
        } catch (ClassNotFoundException | SQLException | InstantiationException 
                | IllegalAccessException ex) {
            BaseDao.LOGGER.error(ex.getMessage(), ex);
            throw new DaoException(ex.getMessage(), ex);
        }
    }
    
}
