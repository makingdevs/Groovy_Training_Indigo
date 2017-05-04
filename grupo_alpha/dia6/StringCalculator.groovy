class StringCalculator {
  
int add( String values ) {
   if ( values == "" )
    0
   else {
    def separator = ","
    if( values.contains(separator) ) {
      values.split(separator).collect {Integer.parseInt( it )}.sum()    
    } else {
      Integer.parseInt( values )
    }
  }
}

}