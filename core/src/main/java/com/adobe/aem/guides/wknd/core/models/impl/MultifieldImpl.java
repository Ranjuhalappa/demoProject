package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.ArrayList;
import java.util.List;

// import javax.annotation.Resource;
import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.Multifield;
import com.adobe.aem.guides.wknd.core.models.helper.MultifieldHelper;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Multifield.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldImpl implements Multifield {

    @Inject
    Resource resource;

    @Override
    public List<MultifieldHelper> getMyUserSubmenu() {
        List<MultifieldHelper> object = new ArrayList<>();
        try {

            Resource resource2 = resource.getChild("myUserSubmenu");
            if (resource2 != null) {
                for (Resource adoptresource : resource2.getChildren()) {
                    MultifieldHelper helper = new MultifieldHelper(adoptresource);
                    object.add(helper);
                }
            }

        } catch (Exception e) {

        }

        return object;

    }

}
