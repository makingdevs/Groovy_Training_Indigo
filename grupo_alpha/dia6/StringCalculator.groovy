  class StringCalculator {
    
  int add( String values ) {
    values == "" ? 0 : values.split(",").collect { it.toInteger() }.sum()     
  }

}