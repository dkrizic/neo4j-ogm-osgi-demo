Demo for Neo4j-OGM inside an OSGi container

Basic requirements
==================

Install and configure Karaf with Neo4j-OGM as described here:

https://github.com/neo4j/neo4j-ogm/issues/255#issuecomment-252522394


Method 1: No scanning (easier)
==============================

This method uses the new feature of Neo4j-OGM, that required classes can be registered directly. This avoids any kind of scanning, which
is really complicated in OSGi. So it is easier. Even larger projects seldom have more than 20 to 30 classes, that needs to be registered
so I personally think this is the way to go.

Setup and test
--------------

Clone and build this project, deploy

* demo-api.jar
* demo-impl.jar
* demo-client.jar

It should look like:

```
karaf@root()> list | grep Neo4j
 52 | Active   |  80 | 1.1.1.v20170119-2132 | Neo4j Java Driver
108 | Active   |  80 | 2.1.2.SNAPSHOT       | Neo4j-OGM API, Fragments: 112, 113
109 | Active   |  80 | 2.1.2.SNAPSHOT       | Neo4j-OGM HTTP Driver
110 | Active   |  80 | 2.1.2.SNAPSHOT       | Neo4j-OGM BOLT Driver
111 | Active   |  80 | 2.1.2.SNAPSHOT       | Neo4j-OGM Compiler
112 | Resolved |  80 | 1.0.0.SNAPSHOT       | Neo4j-OGM Demo API, Hosts: 108
113 | Resolved |  80 | 2.1.2.SNAPSHOT       | Neo4j-OGM Core, Hosts: 108
114 | Resolved |  80 | 1.0.0.SNAPSHOT       | Neo4j-OGM Demo Client
115 | Active   |  80 | 1.0.0.SNAPSHOT       | Neo4j-OGM Demo Impl
```

Ensure that Neo4j >= 3.0 is running on localhost and import the Northwind database. Start the bundle Neo4j-OGM Demo Client (in this case 114)

```
karaf@root()> start 114
Product{id=0, productName='Chai', unitsInStock=39}
Product{id=1, productName='Chang', unitsInStock=17}
Product{id=2, productName='Aniseed Syrup', unitsInStock=13}
Product{id=3, productName='Chef Anton's Cajun Seasoning', unitsInStock=53}
Product{id=4, productName='Chef Anton's Gumbo Mix', unitsInStock=0}
Product{id=5, productName='Grandma's Boysenberry Spread', unitsInStock=120}
Product{id=6, productName='Uncle Bob's Organic Dried Pears', unitsInStock=15}
Product{id=7, productName='Northwoods Cranberry Sauce', unitsInStock=6}
Product{id=8, productName='Mishi Kobe Niku', unitsInStock=29}
Product{id=9, productName='Ikura', unitsInStock=31}
Product{id=10, productName='Queso Cabrales', unitsInStock=22}
Product{id=11, productName='Queso Manchego La Pastora', unitsInStock=86}
Product{id=12, productName='Konbu', unitsInStock=24}
Product{id=13, productName='Tofu', unitsInStock=35}
Product{id=14, productName='Genen Shouyu', unitsInStock=39}
Product{id=15, productName='Pavlova', unitsInStock=29}
Product{id=16, productName='Alice Mutton', unitsInStock=0}
Product{id=17, productName='Carnarvon Tigers', unitsInStock=42}
Product{id=18, productName='Teatime Chocolate Biscuits', unitsInStock=25}
Product{id=19, productName='Sir Rodney's Marmalade', unitsInStock=40}
Product{id=20, productName='Sir Rodney's Scones', unitsInStock=3}
Product{id=21, productName='Gustaf's Knäckebröd', unitsInStock=104}
Product{id=22, productName='Tunnbröd', unitsInStock=61}
Product{id=23, productName='Guaraná Fantástica', unitsInStock=20}
Product{id=24, productName='NuNuCa Nuß-Nougat-Creme', unitsInStock=76}
Product{id=25, productName='Gumbär Gummibärchen', unitsInStock=15}
Product{id=26, productName='Schoggi Schokolade', unitsInStock=49}
Product{id=27, productName='Rössle Sauerkraut', unitsInStock=26}
Product{id=28, productName='Thüringer Rostbratwurst', unitsInStock=0}
Product{id=29, productName='Nord-Ost Matjeshering', unitsInStock=10}
Product{id=30, productName='Gorgonzola Telino', unitsInStock=0}
Product{id=31, productName='Mascarpone Fabioli', unitsInStock=9}
Product{id=32, productName='Geitost', unitsInStock=112}
Product{id=33, productName='Sasquatch Ale', unitsInStock=111}
Product{id=34, productName='Steeleye Stout', unitsInStock=20}
Product{id=35, productName='Inlagd Sill', unitsInStock=112}
Product{id=36, productName='Gravad lax', unitsInStock=11}
Product{id=37, productName='Côte de Blaye', unitsInStock=17}
Product{id=38, productName='Chartreuse verte', unitsInStock=69}
Product{id=39, productName='Boston Crab Meat', unitsInStock=123}
Product{id=40, productName='Jack's New England Clam Chowder', unitsInStock=85}
Product{id=41, productName='Singaporean Hokkien Fried Mee', unitsInStock=26}
Product{id=42, productName='Ipoh Coffee', unitsInStock=17}
Product{id=43, productName='Gula Malacca', unitsInStock=27}
Product{id=44, productName='Rogede sild', unitsInStock=5}
Product{id=45, productName='Spegesild', unitsInStock=95}
Product{id=46, productName='Zaanse koeken', unitsInStock=36}
Product{id=47, productName='Chocolade', unitsInStock=15}
Product{id=48, productName='Maxilaku', unitsInStock=10}
Product{id=49, productName='Valkoinen suklaa', unitsInStock=65}
Product{id=50, productName='Manjimup Dried Apples', unitsInStock=20}
Product{id=51, productName='Filo Mix', unitsInStock=38}
Product{id=52, productName='Perth Pasties', unitsInStock=0}
Product{id=53, productName='Tourtière', unitsInStock=21}
Product{id=54, productName='Pâté chinois', unitsInStock=115}
Product{id=55, productName='Gnocchi di nonna Alice', unitsInStock=21}
Product{id=56, productName='Ravioli Angelo', unitsInStock=36}
Product{id=57, productName='Escargots de Bourgogne', unitsInStock=62}
Product{id=58, productName='Raclette Courdavault', unitsInStock=79}
Product{id=59, productName='Camembert Pierrot', unitsInStock=19}
Product{id=60, productName='Sirop d'érable', unitsInStock=113}
Product{id=61, productName='Tarte au sucre', unitsInStock=17}
Product{id=62, productName='Vegie-spread', unitsInStock=24}
Product{id=63, productName='Wimmers gute Semmelknödel', unitsInStock=22}
Product{id=64, productName='Louisiana Fiery Hot Pepper Sauce', unitsInStock=76}
Product{id=65, productName='Louisiana Hot Spiced Okra', unitsInStock=4}
Product{id=66, productName='Laughing Lumberjack Lager', unitsInStock=52}
Product{id=67, productName='Scottish Longbreads', unitsInStock=6}
Product{id=68, productName='Gudbrandsdalsost', unitsInStock=26}
Product{id=69, productName='Outback Lager', unitsInStock=15}
Product{id=70, productName='Flotemysost', unitsInStock=26}
Product{id=71, productName='Mozzarella di Giovanni', unitsInStock=14}
Product{id=72, productName='Röd Kaviar', unitsInStock=101}
Product{id=73, productName='Longlife Tofu', unitsInStock=4}
Product{id=74, productName='Rhönbräu Klosterbier', unitsInStock=125}
Product{id=75, productName='Lakkalikööri', unitsInStock=57}
Product{id=76, productName='Original Frankfurter grüne Soße', unitsInStock=32}
```

How does it work?
-----------------

* "Neo4j-OGM Demo API" provides a @NodeEntity Product and marks itself a fragment to "Neo4j-OGM API", so the class loader of "Neo4j-OGM API" is extended at runtime and is able to see our entity. 
* "Neo4j-OGM Demo Impl" actually uses "Neo4j-OGM Core" and registeres a "ProductService"
* "Neo4j-OGM Demo Impl" registeres the class "Product.class" directly with OGM so no classpath scannig us done.
* "Neo4j-OGM Demo Client" looks up "ProductService" and calls it.

Method 2: Scanning (more complex)
=================================

If you really need classpath scanning of all your annotated entities (@NodeEntity and @RelationshipEntity), then it is basically possible, but
currently only in the Equinox OSGi container.

Setup and test
--------------

Additionally install "Neo4j-OGM Equinox Resolver" as bundle to the OSGi container and install those bundles from this project:

* demo-api.jar
* demo-impl2.jar <- Note the 2 here
* demo-client.jar

The only difference between demo-impl.jar and demo-impl2.jar is the followoing code

For automatic scanning used in this method:

```
        sessionFactory = new SessionFactory(configuration, packageName, "WEB-INF.classes." + packageName );
```

against statically registered to avoid any scanning

```
        sessionFactory = new SessionFactory(configuration, Product.class );     // no scanning, direct announcing the classes
```

The complexity is, that Neo4j-OGM Equinox Resolver requires a few more dependencies. So we need to add:

* TODO: Liste the required bundles (or feel free to find them out by yourself :-) )

The test is identical as above, the result should be the same.

Trying to start bundle "Neo4j-OGM Demo Impl2" without "Neo4j-OGM Equinox Resolver" leads to the following:

```
2017-02-13 11:58:56,807 | ERROR | nsole user karaf | ShellUtil                        | 43 - org.apache.karaf.shell.core - 4.0.8 | Exception caught while executing command
org.apache.karaf.shell.support.MultiException: Error executing command on bundles:
	Error starting bundle 132: Exception in org.neo4j.ogm.osgi.impl.Activator.start() of bundle org.neo4j.ogm.osgi-demo-impl2.
	at org.apache.karaf.shell.support.MultiException.throwIf(MultiException.java:61)
    ...
	at java.lang.Thread.run(Thread.java:745)[:1.8.0_112]
Caused by: java.lang.Exception: Error starting bundle 132: Exception in org.neo4j.ogm.osgi.impl.Activator.start() of bundle org.neo4j.ogm.osgi-demo-impl2.
	at org.apache.karaf.bundle.command.BundlesCommand.doExecute(BundlesCommand.java:66)[23:org.apache.karaf.bundle.core:4.0.8]
	... 12 more
Caused by: org.osgi.framework.BundleException: Exception in org.neo4j.ogm.osgi.impl.Activator.start() of bundle org.neo4j.ogm.osgi-demo-impl2.
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:792)[org.eclipse.osgi-3.10.101.v20150820-1432.jar:]
    ...
	at org.apache.karaf.bundle.command.BundlesCommand.doExecute(BundlesCommand.java:64)[23:org.apache.karaf.bundle.core:4.0.8]
	... 12 more
Caused by: java.lang.RuntimeException: org.neo4j.ogm.exception.ServiceNotFoundException: Resource: bundleresource://108.fwk1714078840:1/org/neo4j/ogm/osgi/demo/
	at org.neo4j.ogm.utils.ClassUtils.getUniqueClasspathElements(ClassUtils.java:172)
	...
	at org.eclipse.osgi.internal.framework.BundleContextImpl$3.run(BundleContextImpl.java:1)[org.eclipse.osgi-3.10.101.v20150820-1432.jar:]
	at java.security.AccessController.doPrivileged(Native Method)[:1.8.0_112]
	at org.eclipse.osgi.internal.framework.BundleContextImpl.startActivator(BundleContextImpl.java:764)[org.eclipse.osgi-3.10.101.v20150820-1432.jar:]
	... 20 more
Caused by: org.neo4j.ogm.exception.ServiceNotFoundException: Resource: bundleresource://108.fwk1714078840:1/org/neo4j/ogm/osgi/demo/
	at org.neo4j.ogm.service.ResourceService.resolve(ResourceService.java:49)
	at org.neo4j.ogm.utils.ClassUtils.getUniqueClasspathElements(ClassUtils.java:169)
	... 34 more
```

How does it work?
-----------------
* "Neo4j-OGM Equinox Resolver" registers itself as resolver for "bundleresource" and uses the Equinox specific class org.eclipse.core.runtime.FileLocator to find
the actual file location of the bundle and returns an URL with file://. This can be handled by OGM and the scanning works. 
* "Neo4j-OGM Core" gets a file:// URL and can open and scan it normally.

This solution is specific to Equinox. Other contains e.g. Felix are not supported. Felix internally returns and URL with "bundle" and I did not find a way how to
convert that to a "file", yet. 
