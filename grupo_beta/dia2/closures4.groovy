class Calculadora {
  def operacion
  def operar(){
    println "Operando"
    operacion()
  }
  Calculadora(o){ this.operacion = o }
}

c = new Calculadora({ println "Operacion"})
c.operar()
