package eu.mithril.invoice;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import eu.mithril.invoice.context.ApplicationConfiguration;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context tomcatContext = tomcat.addContext("", null);

        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(ApplicationConfiguration.class);
        webCtx.setServletContext(tomcatContext.getServletContext());
        webCtx.refresh();
        webCtx.registerShutdownHook();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);

        Wrapper servlet = Tomcat.addServlet(tomcatContext, "dispatcherServlet", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
        tomcat.start();
    }
}
