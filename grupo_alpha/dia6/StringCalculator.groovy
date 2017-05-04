class StringCalculator {
  
int add( String values ) {
   if ( values == "" )
    0
   else {
    def separator = ","
    if( values.contains(separator) ) {
      def arr = values.split(separator)
      def a = 0
      a = arr.collect {Integer.parseInt( it )}.sum()
      a       
    } else {
      Integer.parseInt( values )
    }
  }
}

}