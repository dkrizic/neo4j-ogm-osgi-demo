package org.neo4j.ogm.osgi.impl.common;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Startup
@Singleton
public class SessionProducer {

    private Driver driver;

    @Inject
    private Logger log;

    @PostConstruct
    public void start() {
        log.info("Creating driver");
        driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic("neo4j", "abc123") );
    }

    @Produces
    public synchronized Session produceSession() {
        if( driver == null ) {
            log.info("Creating driver");
            driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "abc123"));
        }
        log.info("Creating session");
        return driver.session();
    }

    @PreDestroy
    public void stop() {
        driver.close();
    }

}
