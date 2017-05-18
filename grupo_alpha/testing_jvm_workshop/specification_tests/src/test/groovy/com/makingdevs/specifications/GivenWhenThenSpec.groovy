package com.makingdevs.specifications

import spock.lang.Specification;

class GivenWhenThenSpec extends Specification {
  def "Add a new item in a set"() {
    given:
    def bag = [4, 6, 3, 2] as Set

    when:
    bag << 1

    then:
    bag.size() == 5
  }
}
