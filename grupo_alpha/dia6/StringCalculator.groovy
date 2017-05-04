class StringCalculator {
  
int add( String values ) {
   if ( values == "" )
    0
   else {
    def separator = ","
    if( values.contains(separator) ) {
      values.split(separator).collect { it.toInteger() }.sum()    
    } else {
      Integer.parseInt( values )
    }
  }
}

}