package org.neo4j.ogm.osgi.impl;

import org.neo4j.ogm.osgi.demo.Product;
import org.neo4j.ogm.osgi.demo.ProductService;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.Collection;

public class ProductServiceImpl implements ProductService {

    @Inject
    private Logger log;

    @Inject
    private Session session;

    public ProductServiceImpl() {
        // default
    }

    @Override
    public Collection<Product> findAll() {
        log.info("Asking for products");
        final Collection<Product> products = session.loadAll(Product.class,0);
        return products;
    }
}
