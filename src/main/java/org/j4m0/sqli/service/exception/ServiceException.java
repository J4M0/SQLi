package org.j4m0.sqli.service.exception;

/**
 *
 * @author j4m0
 */
public class ServiceException extends Exception {
    
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
