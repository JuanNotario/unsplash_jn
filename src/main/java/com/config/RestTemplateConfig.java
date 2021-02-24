package com.config;

import com.interfaces.GetUnsplashService;
import com.interfaces.UnsplashService;
import com.service.odto.ListCollectionDataOdto;
import com.model.CollectionData;
import com.model.ListCollection;
import com.service.GetUnsplashServiceImpl;
import com.service.UnsplashServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Primary
    public RestTemplate registryRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public CollectionData registryCollectionDataWS() {
        return new CollectionData();
    }

    @Bean
    @Primary
    public ListCollection registryListCollectionWS() {
        return new ListCollection();
    }

    @Bean
    @Primary
    public ListCollectionDataOdto registryListCollectionData() {
        return new ListCollectionDataOdto();
    }

    @Bean
    @Primary
    public String registryString() {
        return new String();
    }

}
