//Definimos una clase
class Persona{
  //Un par de atributos
  String nombre
  //El atributo a trabajar en cuestion
  Map relaciones = [:]
 
  //Implementamos nuestro methodMissing
  //relacion es el nombre del metodo
  //personas son los argumentos que vienen con la llamada
  def methodMissing(String relacion, personas){
    //Si ya tenemos esa relacion
    if(relaciones.containsKey(relacion)){
      //Iteramos los argumentos
      personas.each{ persona ->
        //Agregamos el elemento a la lista
        relaciones.get(relacion).add(persona)
      }
    //Si no existe dicho elemento
    }else{
      //Lo creamos con una nueva Llave
      relaciones.put(relacion,personas as List)
    }
  }
}
 
//Usemos nuestro metodo
def juan = new Persona(nombre:'Juan')
juan.trabajaEn("MakingDevs")
juan.trabajaCon("Felipe","Sergio")
juan.esAmigoDe("Misael")
juan.trabajaCon("Jorge")
juan.esAmigoDe("George")
juan.conoceA("Epifania","Perla","Cassandra","Alejandra")
 
println juan.relaciones
