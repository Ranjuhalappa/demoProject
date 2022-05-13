package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Network;
import com.adobe.aem.guides.wknd.core.models.ReadJsonService;

import org.osgi.service.component.annotations.Component;
// import static org.redquark.demo.core.constants.AppConstants.URL;
// import org.redquark.demo.core.services.ReadJsonService;
// import org.redquark.demo.core.utils.Network;

/**
 * @author Anirudh Sharma
 * 
 *         Implementation of ReadJsonService
 */
@Component(immediate = true, service = ReadJsonService.class)
public class ReadJsonDataImpl implements ReadJsonService {

    /**
     * Overridden method which will read the JSON data via an HTTP GET call
     */
    @Override
    public String getData() {

        String response = Network.readJson("https://jsonplaceholder.typicode.com/todos/");

        return response;
    }

}