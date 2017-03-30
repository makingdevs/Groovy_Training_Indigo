class Persona {
  String nombre
  String apellidos
  Date fechaDeNacimiento
  String toString(){ "$nombre - $apellidos" }
}

p1 = new Persona(nombre:"Juan",apellidos:"Reyes Zuniga",fechaDeNacimiento: new Date() - 3000)
p2 = new Persona(nombre:"Itza",apellidos:"Reyes",fechaDeNacimiento: new Date() - 2000)
p3 = new Persona(nombre:"Edgar",apellidos:"Chavez",fechaDeNacimiento: new Date() - 4000)
p4 = new Persona(nombre:"Abel",fechaDeNacimiento: new Date() - 3500)

mapa = [juan: p1, itza: p2, edgar: p3, abel: p4]
//println mapa

//mapa.each { println it }
//mapa.each { k, v -> println "$k es $v" }
mapa.each { key, persona -> println "$key es $persona" }

fechas = mapa.collect { key, persona ->
  persona.fechaDeNacimiento
}

println fechas

println mapa.find { k, v -> v.apellidos.contains("Reyes") }
println mapa.findAll { String k, Persona v -> v.apellidos?.contains("Reyes") }
