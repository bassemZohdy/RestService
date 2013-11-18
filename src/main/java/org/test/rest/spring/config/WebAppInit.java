package org.test.rest.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class WebAppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext cxt) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		cxt.addListener(new ContextLoaderListener(rootContext));
		cxt.addListener(new Log4jConfigListener());
		

		AnnotationConfigWebApplicationContext pageContext = new AnnotationConfigWebApplicationContext();
		pageContext.register(PageServletConfig.class);
		
		ServletRegistration.Dynamic registrationPage = cxt.addServlet("page",
				new DispatcherServlet(pageContext));
		registrationPage.setLoadOnStartup(1);
		registrationPage.addMapping("/page/*");

		AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
		restContext.register(RESTServletConfig.class);
		
		ServletRegistration.Dynamic registrationREST = cxt.addServlet("REST",
				new DispatcherServlet(restContext));
		registrationREST.setLoadOnStartup(1);
		registrationREST.addMapping("/rest/*");
	}

}
