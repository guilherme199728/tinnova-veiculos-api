package com.tinnova.vehicles;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class HttpUtils {
    private static final String BASE_URL = "http://localhost:8082";
    private static final RestTemplate restTemplate = restTemplate();

    public static RestTemplate restTemplate()  {
        RestTemplate restTemplate =  new RestTemplate ();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    public static <T> List<T> getList(String path, Class<T[]> responseType) {
        String url = BASE_URL + path;
        T[] objects = restTemplate.getForObject(url, responseType);
        assert objects != null;
        return Arrays.asList(objects);
    }

    public static <T> T get(String path, Class<T> responseType) {
        String url = BASE_URL + path;
        return restTemplate.getForObject(url, responseType);
    }

    public static <T> T post(String path, Object request, Class<T> responseType) {
        String url = BASE_URL + path;
        HttpEntity<Object> entity = new HttpEntity<>(request, defaultHeaders());
        return restTemplate.postForObject(url, entity, responseType);
    }

    public static <T> T patch(String path, Object request, Class<T> responseType) {
        String url = BASE_URL + path;
        HttpEntity<Object> entity = new HttpEntity<>(request,  defaultHeaders());

        return restTemplate.exchange(url, HttpMethod.PATCH, entity, responseType).getBody();
    }

    public static void delete(String path) throws URISyntaxException {
        String url = BASE_URL + path;
        restTemplate.delete(new URI(url));
    }

    private static HttpHeaders defaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }
}
