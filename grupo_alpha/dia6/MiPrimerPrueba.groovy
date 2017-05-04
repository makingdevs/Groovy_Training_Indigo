class MiPrimerPrueba extends GroovyTestCase {
  void testCompare(){
    assert 1+2+3+4+5 == 1+2+3+4+5
  }
  void testTruth(){
    assertTrue true
    assertFalse false
  }

  void testArray(){
    //assertArrayEquals([1,2,3,4], [1,2,3,4])
    assert !( [1,2,3,4] == [4,3,2,1] )
  }

  void testFail(){
    shouldFail(java.sql.SQLException) {
      println "Hola"
      throw new IllegalArgumentException("Error de parámetro")
    }
    //try{
    //  throw new IllegalArgumentException("Error de parámetro")
    //  assert false
    //}catch(e){
    //  assert e.message == "Error de parámetro"
    //}
  }

}
