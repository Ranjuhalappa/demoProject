package com.adobe.aem.guides.wknd.core.models;

import javax.jcr.Node;

import com.adobe.cq.sightly.WCMUsePojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 * 
 *         This class has the back-end logic for the Text Component 2.0
 */
public class Componentstxt extends WCMUsePojo {

    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(Componentstxt.class);

    /**
     * Model object
     */
    private ComponentstxtModel model;

    /**
     * Overridden activate method
     */
    @Override
    public void activate() throws Exception {

        try {

            log.info("Text Component 2.0 backend logic starts");

            /**
             * Initializing the model object to set the values
             */
            model = new ComponentstxtModel();

            /**
             * Getting the current node from the resource object which is available in Use
             * API
             */
            Node node = getResource().adaptTo(Node.class);

            /**
             * Check if the node has title property
             */
            if (node.hasProperty("title")) {

                /**
                 * Reading the title property from the string
                 */
                String title = node.getProperty("title").getString();

                /**
                 * Setting the value entered by the user in the model object
                 */
                model.setTitle(title);

            }

            /**
             * Check if the node has description property
             */
            if (node.hasProperty("description")) {

                /**
                 * Reading the title property from the string
                 */
                String description = node.getProperty("description").getString();

                /**
                 * Setting the value entered by the user in the model object
                 */
                model.setDescription(description);

            }

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }
    }

    /**
     * This method is wrapper to return the model object
     * 
     * @return {@link TextComponent2Model}
     */
    public ComponentstxtModel getModel() {
        return model;
    }
}