package org.neo4j.ogm.osgi.impl.common;

import com.prodyna.pa.neo4j.service.BasePackage;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.drivers.bolt.driver.BoltDriver;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class OGMSessionProducer {

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private Class driverClass = BoltDriver.class;

    @Inject
    private Logger log;

    @PostConstruct
    public void start() {
        log.info("Starting");
        configuration = new Configuration();
        configuration.driverConfiguration().setDriverClassName( driverClass.getName() )
            .setURI("bolt://localhost").setCredentials("neo4j", "abc123");
        log.info("Configured as " + configuration);
        String packageName = BasePackage.class.getPackage().getName();
        sessionFactory = new SessionFactory(configuration, packageName, "WEB-INF.classes." + packageName );
        log.info("Session factory created " + sessionFactory);
    }

    @Produces
    public synchronized Session produceSession() {
        log.info("Creating session with sessionFactory " + sessionFactory );
        Session session = sessionFactory.openSession();
        log.info("Created session " + session );
        return session;
    }

    @PreDestroy
    public void stop() {
        /*
        if( sessionFactory != null ) {
            sessionFactory.close();
            sessionFactory = null;
        }
        if( configuration != null ) {
            configuration.close();
            configuration = null;
        }
        */
    }

}