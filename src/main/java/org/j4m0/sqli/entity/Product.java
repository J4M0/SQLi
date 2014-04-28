package org.j4m0.sqli.entity;

import java.io.Serializable;

/**
 *
 * @author j4m0
 */
public class Product implements Serializable {
    
    private Long id;
    private String name;
    private String description;
    private Double price;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
