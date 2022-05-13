package com.adobe.aem.guides.wknd.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.JsonObject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
// import com.google.gson.JsonArray;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/page" })

public class GeeksPathTypeServlet extends SlingSafeMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(GeeksPathTypeServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/wknd/us");

        log.info("Page resourceResolver" + page);
        JSONArray pagesArray = new JSONArray();
        try {
            log.info("Enter into try block" + pagesArray);

            Iterator<Page> childPages = page.listChildren();
            log.info(" Before Enter into while block" + childPages.toString());
            while (childPages.hasNext()) {
                log.info("Enter into while block" + childPages);

                Page childPage = childPages.next();
                JSONObject pageObject = new JSONObject();
                pageObject.put(childPage.getTitle(), childPage.getPath().toString());
                pagesArray.put(pageObject);

                log.info("data of page" + pageObject);
            }
        } catch (JSONException e) {
            log.info("\n ERROR {}", e.getMessage());
        }
        response.setContentType("application/json");
        response.getWriter().write(pagesArray.toString());
    }

}
