import groovy.mock.interceptor.*

class CalculatorTest extends GroovyTestCase {

  void testSumOperation(){
    
    def memoryStub = new StubFor(Memory)

    memoryStub.demand.getOperation() { }
    memoryStub.demand.saveOperation() {  }

    memoryStub.use {
      Calculator c = new Calculator()
      assert c.operation('+', 2, 3) == 5  
    }
    
    memoryStub.expect.verify()
  }
}