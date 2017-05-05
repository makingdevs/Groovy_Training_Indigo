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

  void testSumOperationWithCache(){
    def memoryStub = new StubFor( Memory )
    def cache = [:]
    memoryStub.demand.findOperation(4) { String op, values ->
      cache?."$op $values"
    }
    memoryStub.demand.saveOperation(2) { String op, result, values -> 
      cache."$op $values" = result
    }
    memoryStub.use {
      Calculator c = new Calculator()
      assert c.operation("+", 2, 3) == 5
      assert c.operation("+", 5, 5) == 10
      assert c.operation("+", 2, 3) == 5
    }
    memoryStub.expect.verify()
  }
}