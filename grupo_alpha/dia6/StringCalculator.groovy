  class StringCalculator {
    
  int add( String values ) {
    !values ? 0 : values.split(",|\\n").collect { it.toInteger() }.sum()     
  }

}