package com.makingdevs.specifications

import spock.lang.Specification
import spock.lang.Unroll

class MaxNumberSpec extends Specification {
  @Unroll
  def "The max of #a and #b is #c"() {
    expect:
    Math.max(a, b) == c

    where:
    a << [3, 7, 0]
    b << [5, 0, 0]
    c << [5, 7, 0]
  }
}
