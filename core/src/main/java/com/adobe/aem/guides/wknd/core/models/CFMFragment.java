package com.adobe.aem.guides.wknd.core.models;

import java.util.Calendar;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
// import com.adobe.cq.dam.cfm.ContentElement;
// import com.adobe.cq.dam.cfm.ContentFragment;
//import com.adobe.cq.dam.cfm.FragmentData;
import com.adobe.cq.dam.cfm.FragmentTemplate;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CFMFragment {

    private static final Logger log = LoggerFactory.getLogger(ContentFragment.class);
    public static final String MODEL_TITLE = "UserData";

    public static final String CF_PATH = "/content/dam/wknd/content-fragment-/cf-sling-fragment";

    @Inject
    @Self
    private Resource resource;
    @Inject
    ResourceResolver resourceResolver;
    private Optional<ContentFragment> contentFragment;

    @PostConstruct
    public void init() {
        Resource fragmentResource = resourceResolver.getResource(CF_PATH);
        contentFragment = Optional.ofNullable(fragmentResource.adaptTo(ContentFragment.class));
    }

    public String getFirstName() {
        log.info("Mobile number returned from content fragments sling model");
        return contentFragment.map(cf -> cf.getElement("Ranjitha")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);

    }

    public String getLastName() {
        log.info("CheckBox returned from content fragments sling model");
        return contentFragment.map(cf -> cf.getElement("SH")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }

    // public Calendar getReleaseDate() {
    // return ((Calendar) contentFragment.map(cf ->
    // cf.getElement("releaseDate")).map(ContentElement::getValue)
    // .map(FragmentData::getValue).orElse(StringUtils.EMPTY));
    // }

    public String getPhNumber() {
        log.info("Consern returned from content fragments sling model");
        return contentFragment.map(cf -> cf.getElement("9113255861")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
}