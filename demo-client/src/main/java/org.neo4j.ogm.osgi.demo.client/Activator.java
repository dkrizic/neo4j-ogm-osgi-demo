package org.neo4j.ogm.osgi.demo.client;

import org.neo4j.ogm.osgi.demo.Product;
import org.neo4j.ogm.osgi.demo.ProductService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator extends BundleActivator {

    @Override public void start(BundleContext bundleContext) throws Exception {
        final ServiceReference serviceReference =
            bundleContext.getServiceReference(ProductService.class.getName());
        ProductService ps = (ProductService) bundleContext.getService( serviceReference );
        for( Product product : ps.findAll() ) {
            System.out.println( product );
        }
    }

    @Override public void stop(BundleContext bundleContext) throws Exception {
        // nothing
    }
}
