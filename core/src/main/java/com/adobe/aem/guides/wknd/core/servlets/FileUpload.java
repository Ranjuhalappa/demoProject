package com.adobe.aem.guides.wknd.core.servlets;

// import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.api.AssetManager;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
// import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
// import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
// import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

// import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/uploadDAMAsset")
@ServiceDescription("Image dam Demo Servlet")
public class FileUpload extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);

    @Override
    protected void doPost(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {

        // String fName = request.getParameter("inputFile");
        // LOGGER.info("fileName" + fName);
        Map<String, RequestParameter[]> requestParameterMap = request.getRequestParameterMap();
        LOGGER.info("request"+requestParameterMap);
        for (Entry<String, RequestParameter[]> paramPair : requestParameterMap.entrySet()) {
        LOGGER.info("forLoop"+paramPair);
            String key = paramPair.getKey();
        LOGGER.info("parmKey"+key);
            if (key.equals("inputFile")) {
        LOGGER.info("if loop"+key);
                RequestParameter[] values = paramPair.getValue();
        LOGGER.info("values"+values);

                RequestParameter paramVal = values[0];
        LOGGER.info("paramVal"+paramVal);

                try {
                    InputStream inputStream = paramVal.getInputStream();
                    String fname = paramVal.getFileName();
                    LOGGER.info("filename is " + fname);
                    String mimType = paramVal.getContentType();
                    LOGGER.info("mimType is " + mimType);
                    ResourceResolver resourceResolver = request.getResourceResolver();
                    if (null != inputStream) {
                        AssetManager assetMgr = resourceResolver.adaptTo(AssetManager.class);
                        assetMgr.createAsset("/content/dam/text/emails/" + fname, inputStream, mimType, true);
                    }
                    LOGGER.info("Assest Created successfully");
                } catch (IOException e) {
                    LOGGER.error("Error while getting the input stream and creating DAM asset: {} {}", e.getMessage(),
                            e);
                }
            }
        }
    }
}