package com.adobe.aem.guides.wknd.spa.react.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.wknd.spa.react.core.models.Carousel;
import com.adobe.cq.export.json.ExporterConstants;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@Model(adaptables = SlingHttpServletRequest.class,
    adapters = Carousel.class,
    resourceType = CarouselImpl.RESOURCE_TYPE)
public class CarouselImpl implements Carousel {

    private static final Logger LOG = LoggerFactory.getLogger(CarouselImpl.class);
    static final String RESOURCE_TYPE = "wknd-spa-react/components/commerce/carousel";

    @ValueMapValue(name = PROPERTY_RESOURCE_TYPE,
        injectionStrategy = InjectionStrategy.OPTIONAL)
    @Default(values = "No resourceType")
    protected String resourceType;

    @SlingObject
    private Resource currentResource;

    protected void init() {
        LOG.debug("Initialing component model for {}", currentResource.getPath());
    }

    public String[] getSku() {
        return currentResource.getValueMap().get("sku", new String[] {});
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
