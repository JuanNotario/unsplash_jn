package com.service;

import com.interfaces.GetUnsplashService;
import com.model.CollectionData;
import com.model.ListCollection;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class GetUnsplashServiceImpl implements GetUnsplashService {
    public static final String CLIENT_ID = "client_id";
    public static final String EQL = "=";
    public static final String INTR = "?";

    @Value("${api.endpoint}")
    private String endpoint;

    @Value("${api.key}")
    private String client_key;

    private RestTemplate restTemplate;

    private ListCollection listCollection;

    @Override
    public ListCollection getUnsplash() {
        String url = generateURL();

        ResponseEntity<List<CollectionData>> forEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CollectionData>>() {});

        listCollection.setCollectionData(forEntity.getBody());

        return listCollection;
    }

    private String generateURL() {
        return endpoint.concat(INTR).concat(CLIENT_ID).concat(EQL).concat(client_key);
    }
}
