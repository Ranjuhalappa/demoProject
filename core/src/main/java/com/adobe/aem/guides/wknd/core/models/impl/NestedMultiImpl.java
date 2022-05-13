
package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.NestedMulti;
import com.adobe.aem.guides.wknd.core.models.helper.NestedHelperClass;
import com.adobe.aem.guides.wknd.core.models.helper.NestedMultiHelper;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = NestedMulti.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NestedMultiImpl implements NestedMulti {

    private static final Logger LOG = LoggerFactory.getLogger(NestedMultiImpl.class);

    @Inject
    Resource resource;

    @Override
    public List<NestedMultiHelper> getMyUserSubmenu() {
        List<NestedMultiHelper> object = new ArrayList<>();
        LOG.info("getting List" + object);
        try {

            Resource resource2 = resource.getChild("myUserSubmenu");
            // LOG.info("getting List" + resource2);
            if (resource2 != null) {
                for (Resource adoptresource : resource2.getChildren()) {
                    // LOG.info("entered into for block" + adoptresource);
                    NestedMultiHelper helper = new NestedMultiHelper(adoptresource);
                    // LOG.info("helper" + helper);
                    if (adoptresource.hasChildren()) {
                        // LOG.info("entered into if block" + adoptresource);
                        List<NestedHelperClass> object1 = new ArrayList<>();
                        // LOG.info("List2" + object1);
                        Resource resource3 = adoptresource.getChild("myUserSub");// gettingnull
                        // LOG.info("resource3" + resource3);
                        for (Resource adoptresource1 : resource3.getChildren()) {
                            // LOG.info("entered into for block2" + resource3);
                            NestedHelperClass helper1 = new NestedHelperClass(adoptresource1);
                            // LOG.info("helper1" + helper1);
                            object1.add(helper1);
                            // LOG.info("adding helper1" + object1);

                        }
                        helper.setMyUserSub(object1);
                        LOG.info("helper" + helper);
                    }
                    object.add(helper);
                    LOG.info("adding helper1" + object);
                }

            }
        } catch (Exception e) {

        }
        return object;

    }
}