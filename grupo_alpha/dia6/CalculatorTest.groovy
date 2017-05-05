import groovy.mock.interceptor.*

class CalculatorTest extends GroovyTestCase {

  void testSumOperation(){
    
    def memoryStub = new StubFor( Memory )

    memoryStub.demand.findOperation { String op, values -> null }
    memoryStub.demand.saveOperation { String op, result, values -> }

    memoryStub.use {
      Calculator c = new Calculator()
      assert c.operation("+", 2, 3) == 5
    }
    
    memoryStub.expect.verify()
  }
}