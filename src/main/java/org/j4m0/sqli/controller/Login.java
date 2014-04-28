package org.j4m0.sqli.controller;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.j4m0.sqli.entity.User;
import org.j4m0.sqli.service.UserService;
import org.j4m0.sqli.service.exception.ServiceException;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author j4m0
 */
@ManagedBean
@RequestScoped
public class Login {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent actionEvent) {
        try {
            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage msg = null;
            boolean loggedIn = false;
            UserService userService = new UserService();
            User user = userService.login(username, password);
            
            if (user != null) {
                loggedIn = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", 
                user.getName() + user.getLastName());
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String redirect = "product.jsf";
                NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
                myNav.handleNavigation(facesContext, null, redirect);
            } else {
                loggedIn = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                        "Usuario o contraseña incorrectos");
            }
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
            context.addCallbackParam("loggedIn", loggedIn);
        } catch (ServiceException ex) {
            Login.LOGGER.error(ex.getMessage(), ex);
        }
    }
}
