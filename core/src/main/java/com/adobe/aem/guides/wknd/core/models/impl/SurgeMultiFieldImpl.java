package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adobe.aem.guides.wknd.core.models.SurgeMultiField;

import org.apache.abdera.model.Collection;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = SurgeMultiField.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SurgeMultiFieldImpl implements SurgeMultiField {

    private static final Logger LOG = LoggerFactory.getLogger(SurgeMultiFieldImpl.class);
    @ValueMapValue
    private List<String> title;

    @ValueMapValue
    private List<String> link;

    @Override
    public List<Map<String, String>> getSurgeMulti() {
        LOG.info("entered" + title);

        if (title != null) {
            // LOG.info("getting title" + title);
            List<Map<String, String>> Surge = new ArrayList<>();
            // LOG.info("if condition" + Surge);
            for (int i = 0; i < title.size(); i++) {
                Map<String, String> result = new HashMap<>();
                result.put("TitelTxt", title.get(i));
                result.put("LinkURL", link.get(i));
                Surge.add(result);
            }
            return Surge;

        } else {
            return Collections.emptyList();
        }
    }

}
