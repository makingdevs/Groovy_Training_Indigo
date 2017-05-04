class Calculator {

  Memory memory = new Memory()

  def operation(op, value1, value2){
    def v = memory.getOperation(op, value1, value2)
    if(v) memory.getOperation(op, value1, value2)
    else {
      def result = value1 + value2
      memory.saveOperation(op, value1, value2, result)
      result
    }
  }  
}