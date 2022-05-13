package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.ArrayList;
import java.util.List;

// import javax.annotation.Resource;
import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.TriNestedMulti;
import com.adobe.aem.guides.wknd.core.models.helper.TriHelperClass;
import com.adobe.aem.guides.wknd.core.models.helper.TriNestedHelperClass;
import com.adobe.aem.guides.wknd.core.models.helper.TriNestedMultiHelper;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = TriNestedMulti.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TriNestedMultiImpl implements TriNestedMulti {

    private static final Logger LOG = LoggerFactory.getLogger(TriNestedMultiImpl.class);

    @Inject
    Resource resource;

    @Override
    public List<TriNestedMultiHelper> getMyUserSubmenu() {
        LOG.info("entering to myuser");

        List<TriNestedMultiHelper> object = new ArrayList<>();
        LOG.info("entering to myuser" + object);

        try {
            Resource resource2 = resource.getChild("myUserSubmenu");
            LOG.info("entering to resource2" + resource2);

            if (resource2 != null) {
                LOG.info("entering to resource2" + resource2);

                for (Resource adopt : resource2.getChildren()) {
                    LOG.info("entering to adopt" + adopt);

                    // Parent Multifield
                    TriNestedMultiHelper helper = new TriNestedMultiHelper(adopt);
                    LOG.info("entering to helper" + helper);

                    if (adopt.hasChildren()) {
                        LOG.info("entering to adopt" + adopt);

                        List<TriNestedHelperClass> object1 = new ArrayList<>();
                        LOG.info("entering to object1" + object1);

                        // Sub multifield
                        Resource resource3 = adopt.getChild("myUserSub");
                        LOG.info("entering to resource3" + resource3);

                        for (Resource adopt1 : resource3.getChildren()) {
                            LOG.info("entering to adopt1" + adopt1);

                            TriNestedHelperClass helper1 = new TriNestedHelperClass(adopt1);

                            // Child multifield
                            if (adopt1.hasChildren()) {

                                List<TriHelperClass> object2 = new ArrayList<>();
                                LOG.info("entering to myuser" + object2);
                                Resource resource4 = adopt1.getChild("myUser");
                                LOG.info("entered to myuser" + resource4);
                                for (Resource adopt2 : resource4.getChildren()) {
                                    LOG.info("entered to for loop myuser" + adopt2);

                                    TriHelperClass helper2 = new TriHelperClass(adopt2);
                                    LOG.info("entered to for loop myuser" + helper2);

                                    object2.add(helper2);

                                }
                                helper1.setMyUser(object2);

                            }
                            object1.add(helper1);

                        }
                        helper.setMyUserSub(object1);
                    }
                    object.add(helper);
                }

            }
        } catch (Exception e) {

        }

        return object;
    }

}
