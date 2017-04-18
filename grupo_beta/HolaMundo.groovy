class HolaMundo2 {
  String nombre

  def saluda(){
    "Hola ${nombre} !!!"
  }
}

def objeto = new HolaMundo2(nombre: "MakingDevs")
println(objeto.saluda())
