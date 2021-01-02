package com.github.airatgaliev.restclient.services;

import com.github.airatgaliev.restclient.payload.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

  private static final String BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

  private final RestTemplate restTemplate;

  @Autowired
  public JokeService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public String getJoke(String first, String last) {
    String url = String.format("%s&firstName=%s&lastName%s", BASE_URL, first, last);
    JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
    if (response != null) {
      return response.getValue().getJoke();
    }
    return "";
  }
}
