package com.adobe.aem.guides.wknd.core.servlets;

import java.io.IOException;

// import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.day.cq.analytics.testandtarget.Resolution;
import com.day.cq.commons.jcr.JcrConstants;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
        // Constants.SERVICE_DESCRIPTION + "=JSON Servlet to read the data from the
        // external webservice",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.resourceTypes=" + "wknd/components/page",
        "sling.servlet.extensions=" + "txt"

})

@ServiceDescription("Simple Servlet")
public class SamplePathServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(SamplePathServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        final Resource resource = request.getResource();
        log.info("resource is " + resource);
        response.setContentType("text/plain");
        response.getWriter().write("page title =" + resource.getValueMap().get(JcrConstants.JCR_TITLE));

    }
}
