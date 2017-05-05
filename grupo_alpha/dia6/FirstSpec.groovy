@Grapes(
  @Grab(group='org.spockframework', module='spock-core', version='1.1-groovy-2.4-rc-4')
)

import spock.lang.*

class FirstSpec extends Specification {
  
  def "Add an item to a new Collection"(){
    given: "We have a collection with 4 elemns"
      def c = [1,2,3,4]
    when: "We add one element"
      c << 5 << 6
    then: "Validate the size"
      c.size() == 6
  }

  @Unroll
  def "Know which is bigger between two numbers"(){
    expect:
      Math.max(a,b) == c
    where:
      a  | b  | c
      7  | 8  | 8
      9  | 8  | 9
      8  | 0  | 8
  }

  def "Know which is bigger between two numbers with datapipes"(){
    expect:
      Math.max(a,b) == c
    where:
      a << [7,9,8]
      b << [8,8,0]
      c << [8,9,8]
  }
  
  @Shared sql = Sql.newInstance(
    "jdbc:mysql://localhost/test_data",
    "makingdevs",
    "makingdevs",
    "com.mysql.jdbc.Drivee")

  def "Know which is bigger between two numbers with DB values"(){
    expect:
      Math.max(a,b) == c
    where:
      [a,b,c] << sql.rows("select * from max_data")
  }

}