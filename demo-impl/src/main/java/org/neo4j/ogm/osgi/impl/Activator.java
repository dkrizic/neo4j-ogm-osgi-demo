package org.neo4j.ogm.osgi.impl;

import org.neo4j.ogm.osgi.demo.ProductService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("Registering ProductService");
        context.registerService(ProductService.class.getName(), new ProductServiceImpl(), null);
        System.out.println("ProductService registered");
    }

    public void stop(BundleContext context) throws Exception {
        context.ungetService(context.getServiceReference(ProductService.class.getName()));
        System.out.println("ProductService unregistered");
    }


}
