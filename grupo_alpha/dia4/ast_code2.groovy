class Cross {
  @Lazy
  def connection = getConnection("jdbc:mysql//localhost")
}

new Cross()

@groovy.transform.InheritConstructors
class CustomPRintWritter extends PrintWriter {

} 

new CustomPRintWritter(new File('out.txt'))
