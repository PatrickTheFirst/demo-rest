package biz.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import biz.test.rest.config.RestConfig;

@Configuration
public class ServletConfig
{
    @Autowired ApplicationContext applicationContext;

    @Bean
    public ServletRegistrationBean msiServletV1()
    {
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.setParent(applicationContext);
        servletContext.register(RestConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(servletContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
        servletRegistrationBean.setName("REST Servlet V1");

        return servletRegistrationBean;
    }
}
