package com.adobe.aem.guides.wknd.core.models.helper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriNestedHelperClass {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);

    private String typetitleNested;
    private String typelinkNested;

    public String getTypetitleNested() {
        return typetitleNested;
    }

    public String getTypelinkNested() {
        return typelinkNested;
    }

    public List<TriHelperClass> myUser;

    public List<TriHelperClass> getMyUser() {
        return myUser;
    }

    public void setMyUser(List<TriHelperClass> myUser) {
        this.myUser = myUser;
    }

    public TriNestedHelperClass(Resource resource) {
        try {
            if (StringUtils.isNotBlank(resource.getValueMap().get("titleNested", String.class))) {
                this.typetitleNested = resource.getValueMap().get("titleNested", String.class);
            }

            if (StringUtils.isNotBlank(resource.getValueMap().get("linkNested", String.class))) {
                this.typelinkNested = resource.getValueMap().get("linkNested", String.class);
            }
        } catch (Exception e) {
            LOG.info("NestedHelperClass", e.getMessage());

        }
    }

}
