class StringCalculatorTest extends GroovyTestCase {

  void testOne(){
    assert new StringCalculator().add("") == 0
  } 

  void testTwo(){
    assert new StringCalculator().add("1") == 1   
    assert new StringCalculator().add("2") == 2
    assert new StringCalculator().add("3") == 3
    assert new StringCalculator().add("10") == 10
  }  
  void testTree(){
    assert new StringCalculator().add("1,2")==3
    assert new StringCalculator().add("7,5")==12
  }

  void testFour() {
   assert new StringCalculator().add("1,2,3") == 6
    assert new StringCalculator()
    .add("7,8,9,10") == 34
 assert new StringCalculator()
 .add("1,1,1,1,1,2,2") == 9   
  }
}
