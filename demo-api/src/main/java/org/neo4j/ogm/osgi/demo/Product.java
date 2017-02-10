package org.neo4j.ogm.osgi.demo;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by dkrizic on 29/09/2016.
 */
@NodeEntity(label="Product")
public class Product {

    @GraphId
    private Long id;

    private String productName;

    private int unitsInStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName='" + productName + '\'' + ", unitsInStock="
            + unitsInStock + '}';
    }
}
