package com.adobe.aem.guides.wknd.core.models.helper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
    private String entertitle;
    private String enterlink;

    public String getEntertitle() {
        return entertitle;
    }

    public String getEnterlink() {
        return enterlink;
    }

    public MultifieldHelper(Resource resource) {
        try {
            if (StringUtils.isNotBlank(resource.getValueMap().get("title", String.class))) {
                this.entertitle = resource.getValueMap().get("title", String.class);
            }

            if (StringUtils.isNotBlank(resource.getValueMap().get("link", String.class))) {
                this.enterlink = resource.getValueMap().get("link", String.class);
            }
        } catch (Exception e) {
            LOG.info("MultifieldHelper", e.getMessage());

        }
    }
}
