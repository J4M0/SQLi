package org.j4m0.sqli.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.j4m0.sqli.entity.Product;
import org.j4m0.sqli.service.ProductService;
import org.j4m0.sqli.service.exception.ServiceException;

/**
 *
 * @author j4m0
 */
@ManagedBean
@RequestScoped
public class ProductController {
    
    public List<Product> getAll() {
        ProductService service = new ProductService();
        try {
            return service.findAll();
        } catch (ServiceException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Product> getById() {
        FacesMessage msg = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String id = facesContext.getExternalContext().getRequestParameterMap().get("id");
        ProductService service = new ProductService();
        try {
            return service.findById(id);
        } catch (ServiceException ex) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(),
                        ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return null;
    }
}
