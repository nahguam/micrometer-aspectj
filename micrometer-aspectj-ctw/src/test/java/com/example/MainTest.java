package com.example;

import static io.micrometer.core.instrument.Metrics.globalRegistry;
import static org.assertj.core.api.Assertions.assertThat;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  void test() {
    globalRegistry.add(new SimpleMeterRegistry());

    Main.timedMethod();

    Timer timer = globalRegistry.find("method.timed")
        .tag("class", "com.example.Main")
        .tag("method", "timedMethod")
        .tag("exception", "none")
        .timer();
    assertThat(timer.count()).isOne();
  }
}