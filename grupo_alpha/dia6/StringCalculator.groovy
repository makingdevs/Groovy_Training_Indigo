class StringCalculator {
  
int add( String values ) {
   if ( values == "" )
    0
   else {
    def separator = ","
    
      values.split(separator).collect { it.toInteger() }.sum()    
    
  }
}

}