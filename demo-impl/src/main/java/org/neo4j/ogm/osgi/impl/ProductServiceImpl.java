package org.neo4j.ogm.osgi.impl;

import org.neo4j.ogm.osgi.demo.Product;
import org.neo4j.ogm.osgi.demo.ProductService;
import org.neo4j.ogm.osgi.impl.common.OGMSessionProducer;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class ProductServiceImpl implements ProductService {

    // @Inject
    private Logger log;

    // @Inject
    private Session session;

    public ProductServiceImpl() {
        log = LoggerFactory.getLogger(getClass());            // TODO: Replace with CDI
        session = new OGMSessionProducer().produceSession();    // TODO: Replace with CDI
    }

    @Override public Collection<Product> findAll() {
        log.info("Asking for products");
        final Collection<Product> products = session.loadAll(Product.class, 0);
        return products;
    }
}
