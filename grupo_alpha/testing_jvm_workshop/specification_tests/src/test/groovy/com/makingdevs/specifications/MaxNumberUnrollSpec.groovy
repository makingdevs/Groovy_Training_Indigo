package com.makingdevs.specifications

import spock.lang.Specification

class MaxNumberUnrollSpec extends Specification {
  def "The max of two numbers"() {
    expect:
    Math.max(a, b) == c

    where:
    a | b | c
    1 | 3 | 3
    7 | 4 | 7
    0 | 0 | 0
  }
}
