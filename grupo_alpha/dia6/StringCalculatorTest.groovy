class StringCalculatorTest extends GroovyTestCase {

  void testIsNull(){
    assert new StringCalculator().add(null) == 0
  } 

  void testEmptyValues(){
    assert new StringCalculator().add("") == 0
  } 

  void testOneNumber(){
    assert new StringCalculator().add("1") == 1   
    assert new StringCalculator().add("2") == 2
    assert new StringCalculator().add("3") == 3
    assert new StringCalculator().add("10") == 10
  }  
  void testTwoNumbers(){
    assert new StringCalculator().add("1,2")==3
    assert new StringCalculator().add("7,5")==12
  }

  void testAnyNumbers() {
   assert new StringCalculator().add("1,2,3") == 6
    assert new StringCalculator()
    .add("7,8,9,10") == 34
 assert new StringCalculator()
 .add("1,1,1,1,1,2,2") == 9   
  }

  void testBreaklineAsSeparatorInNumbers() {
    assert new StringCalculator().add("1,2\n3") == 6
    assert new StringCalculator().add("7,8\n9\n10") == 34
    assert new StringCalculator().add("1,1\n1,1\n1,2\n2") == 9   
  }
}
