import groovy.mock.interceptor.*

class CalculatorTest extends GroovyTestCase {

  void testSumOperation(){
    
    def memoryStub = new StubFor( Memory )

    memoryStub.demand.damnTheFuckingStub { "Message Reached :) !!!" }

    memoryStub.use {
      Calculator c = new Calculator()
      assert c.operation("+", 2, 3) == "Message Reached :) !!!"
    }
    
    memoryStub.expect.verify()
  }
}