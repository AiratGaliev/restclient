package com.github.airatgaliev.restclient.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class JokeServiceTest {
  @Autowired
  private JokeService jokeService;

  @Test
  void getJoke() {
    String joke = jokeService.getJoke("Airat", "Galiev");
    log.info(joke);
    assertTrue(joke.contains("Airat") || joke.contains("Galiev"));
  }
}