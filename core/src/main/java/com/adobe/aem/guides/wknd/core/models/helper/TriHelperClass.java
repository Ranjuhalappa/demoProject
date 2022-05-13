package com.adobe.aem.guides.wknd.core.models.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriHelperClass {

    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);

    private String typetrititleNested;
    private String typetrilinkNested;

    public String getTypetrititleNested() {
        return typetrititleNested;
    }

    public String getTypetrilinkNested() {
        return typetrilinkNested;
    }

    public TriHelperClass(Resource resource) {
        try {
            if (StringUtils.isNotBlank(resource.getValueMap().get("titletriNested", String.class))) {
                this.typetrititleNested = resource.getValueMap().get("titletriNested", String.class);
            }

            if (StringUtils.isNotBlank(resource.getValueMap().get("linktriNested", String.class))) {
                this.typetrilinkNested = resource.getValueMap().get("linktriNested", String.class);
            }
        } catch (Exception e) {
            LOG.info("NestedHelperClass", e.getMessage());

        }
    }
}
