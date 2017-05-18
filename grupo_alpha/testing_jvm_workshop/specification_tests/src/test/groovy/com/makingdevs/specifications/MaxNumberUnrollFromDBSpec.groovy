package com.makingdevs.specifications

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

// @ContextConfiguration(locations = "appcontext.xml")
// Hey you!!! Use Spring...!!!
class MaxNumberUnrollFromDBSpec extends Specification {
  @Shared db = [
    url:'jdbc:mysql://localhost/groovy_issue_tracker',
    user:'makingdevs',
    password:'makingdevs',
    driver:'com.mysql.jdbc.Driver'
  ]
  @Shared sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

  @Unroll
  def "The max value from #a and #b is #c"() {
    expect:
    Math.max(a, b) == c

    where:
    [a, b, c]<< sql.rows("select a, b, c from maxdata")
  }
}
