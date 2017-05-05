@groovy.transform.TypeChecked
class Calculator {

  Memory memory = new Memory()

  def operation(String op, int... values){
    def v = memory.findOperation(op, values)
    if(v){ memory.findOperation(op, values) }
    else {
      def result = values.sum()
      memory.saveOperation(op, result, values)
      result
    }
  }  
}