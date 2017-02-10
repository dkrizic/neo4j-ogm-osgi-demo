package org.neo4j.ogm.osgi.impl;

import com.prodyna.pa.neo4j.service.product.Product;
import com.prodyna.pa.neo4j.service.product.ProductService;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by dkrizic on 29/09/2016.
 */
@Stateless
public class ProductServiceBean implements ProductService {

    @Inject
    private Logger log;

    @Inject
    private Session session;

    public ProductServiceBean() {
        // default
    }

    @Override
    public Collection<Product> findAll() {
        log.info("Asking for products");
        final Collection<Product> products = session.loadAll(Product.class,0);
        return products;
    }
}
