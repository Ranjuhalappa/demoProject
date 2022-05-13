package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.FieldsComp;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = FieldsComp.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FieldCompImpl implements FieldsComp {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String path;

    @ValueMapValue
    private String richtext;

    @ValueMapValue
    private String checkbox;

    @Override
    public String getTitle() {

        return text;
    }

    @Override
    public String getPathTitle() {

        return path;
    }

    @Override
    public String getRight() {

        return checkbox;
    }

    @Override
    public String getDescription() {

        return richtext;
    }

}
