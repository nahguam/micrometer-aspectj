package com.example;

import static io.micrometer.core.instrument.Metrics.globalRegistry;

import io.micrometer.core.annotation.Timed;

public class Main {
  public static void main(String[] args) {
    timedMethod();
    printMeters();
  }

  static void printMeters() {
    globalRegistry.forEachMeter(meter -> System.out.println(meter.getId()));
  }

  @Timed
  static void timedMethod() {}
}
