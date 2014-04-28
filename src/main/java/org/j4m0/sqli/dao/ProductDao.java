package org.j4m0.sqli.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.j4m0.sqli.dao.exception.DaoException;
import org.j4m0.sqli.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author j4m0
 */
public class ProductDao extends BaseDao {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDao.class);
    
    public List<Product> findAll() throws DaoException {
        try (Connection conn = this.getConnection()) {
            final List<Product> all = new ArrayList<>(0);
            String query = "SELECT * FROM product";
            ProductDao.LOGGER.debug(query);
            final Statement s =  conn.createStatement();
            final ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Product p = new Product();
                p.setDescription(rs.getString("description"));
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                all.add(p);
            }
            return all;
        } catch (SQLException ex) {
            ProductDao.LOGGER.error(ex.getMessage(), ex);
            throw new DaoException(ex.getMessage(), ex);
        }
    }
    
    public List<Product> findById(String id) throws DaoException {
        try (Connection conn = this.getConnection()) {
            final List<Product> all = new ArrayList<>(0);
            //String query = "SELECT * FROM product WHERE id = " + id;
            String query = "SELECT * FROM product WHERE id = ?";
            ProductDao.LOGGER.debug(query);
            //final Statement s =  conn.createStatement();
            final PreparedStatement s = conn.prepareStatement(query);
            s.setString(1,id);
            //final ResultSet rs = s.executeQuery(query);
            final ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setDescription(rs.getString("description"));
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                all.add(p);
            }
            ProductDao.LOGGER.debug(all.toString());
            return all;
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
    }
    
}
