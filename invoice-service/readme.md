
### Step one

Create a REST api that creates PDF invoice when called with some purchase data parameters.

The goal is to build REST service with:

* plain Java

* embedded Tomcat

* self-written dependency injection framework

* fake PDF generation

```json
{
  "id": 1,
  "user_id": "john_matrix",
  "amount": 50,
  "pdf_url": "https://invoice-service.com/invoice-john_matrix-1.pdf"
}
```

#### Use Maven to setup Java Webapp

* jar packaging


#### Starting Tomcat and registering your HttpServlet

```java

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myFirstServlet", new MyFirstServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }
```

#### Adding manifest file with maven:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
        <archive>
            <manifest>
                <mainClass>eu.mithril.ApplicationLauncher</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

#### Maven shade plugin:

```xml


<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.4.1</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
            <configuration>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                        <mainClass>eu.mithril.ApplicationLauncher</mainClass>
                    </transformer>
                </transformers>
            </configuration>
        </execution>
    </executions>
</plugin>


```