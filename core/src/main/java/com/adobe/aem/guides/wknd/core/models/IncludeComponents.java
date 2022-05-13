package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.day.cq.wcm.api.Page;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
// import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { SlingHttpServletRequest.class,
                Resource.class }, adapters = IncludeComponents.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class IncludeComponents {

        private static final Logger LOG = LoggerFactory.getLogger(IncludeComponents.class);

        @Inject
        Resource resource;

        @Self
        // @Inject
        @Via("resource")
        TextComponent textComponent;

        @Self
        // @Inject
        @Via("resource")
        TitleComponent titleComponent;

        @Self
        // @Inject
        @Via("resource")
        ButtonComponent buttonComponent;
        @Inject
        private Page currentPage;

        String richText = StringUtils.EMPTY;
        String textId = StringUtils.EMPTY;
        List<IncludeComponentsBean> list;

        @PostConstruct
        protected void init() {

                list = new ArrayList<>();

                LOG.debug("init method triggered");
                LOG.debug("init method triggered resource::::" + resource);

                LOG.debug("init method triggered page::::" + currentPage);
                if (resource != null) {
                        textComponent = resource.adaptTo(TextComponent.class);

                        titleComponent = resource.adaptTo(TitleComponent.class);

                        buttonComponent = resource.adaptTo(ButtonComponent.class);

                        IncludeComponentsBean bean = new IncludeComponentsBean();

                        bean.setRichText(textComponent.getRichText());
                        bean.setTextId(textComponent.getTextId());
                        bean.setTitleField(titleComponent.getTitleField());
                        bean.setDefaultType(titleComponent.getDefaultType());
                        bean.setType(titleComponent.getDefaultType());
                        bean.setTitleLink(titleComponent.getTitleLink());
                        bean.setTitleId(titleComponent.getTitleId());
                        bean.setText(buttonComponent.getText());
                        bean.setLink(buttonComponent.getLink());
                        bean.setId(buttonComponent.getId());
                        bean.setIcon(buttonComponent.getIcon());

                        list.add(bean);
                        LOG.debug("init method componentResults componentResults::::" + textComponent);
                        LOG.debug("init method componentResults componentResults::::" + textComponent.getRichText());
                        LOG.debug("init method componentResults TextId::::" + textComponent.getTextId());

                }

        }

        public List<IncludeComponentsBean> getList() {
                return list;
        }

}
