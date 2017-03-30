class Calculadora {
  def operacion
  Calculadora(_operacion_) { operacion = _operacion_ }
  def operar(){
    println "Ejecutando la operacion"
    operacion()
  }
}

calc1 = new Calculadora({ println "sumando" })
def operacion_externa = { println "restando" }
calc2 = new Calculadora(operacion_externa)

calc1.operar()
calc2.operar()
