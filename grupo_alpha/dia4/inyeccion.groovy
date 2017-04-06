//Usamos el metaClass para agregar un metodo
Integer.metaClass.diasDesdeHoy = {->
  //Definimos una instancia de Calendar
  Calendar hoy = Calendar.instance
  //Le sumamos el valor de delegate que es el objeto original
  hoy.add(Calendar.DAY_OF_MONTH,delegate)
  //Regresamos el resultaod
  hoy.time
}
 
//Invocamos a nuestro objeto
println 5.diasDesdeHoy()
 
//Quitarle el parentesis
////Usarlo en Integer y en Long
// 
//Podemos inyectar métodos estaticos
Integer.metaClass.static.esPar = { val -> val % 2 == 0 }
//Probemos nuestro método estatico
println "2 es Par? " + Integer.esPar(2)
println "3 es Par? " + Integer.esPar(3)
// 
////Agreguemos la definicion de un constructor
Integer.metaClass.constructor << { Calendar calendar ->
  //Obtenemos un entero del dia en el que estamos
  new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}
//Llamamos a nuestro nuevo constructor
println new Integer(Calendar.instance)
// 
////Podemos 'sobreescribir' los constructores actuales
Integer.metaClass.constructor = { int val ->
  println "*** Interceptando la llamada del constructor ***"
  constructor = Integer.class.getConstructor(Integer.TYPE)
  constructor.newInstance(val)
}
//Probemos nuestro constructor 'sobreescrito'
println new Integer(4)
println new Integer(Calendar.instance)
// Se puede agregar métodos por instancia inclusive
