package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.IncludeComp;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = IncludeComp.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class IncludeCompImpl implements IncludeComp {

    @ValueMapValue
    private String textField;

    @ValueMapValue
    private String pathField;

    @Override
    public String getNameTxt() {
        // TODO Auto-generated method stub
        return textField;
    }

    @Override
    public String getPathTxt() {
        // TODO Auto-generated method stub
        return pathField;
    }

}
