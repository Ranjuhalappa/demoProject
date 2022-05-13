package com.adobe.aem.guides.wknd.core.models;

// import javax.annotation.Resource;

// import com.adobe.aem.guides.wknd.core.models.TextComponent;

// import com.aem.geeks.core.models.TextComponent;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, adapters = TextComponent.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextComponent {

    @ValueMapValue
    String richText;

    @ValueMapValue
    String textId;

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

}
