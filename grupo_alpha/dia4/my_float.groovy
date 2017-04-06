Float.metaClass.invokeMethod = { String nombre, args ->
  //Al igual desplegamos algo de informacion
  System.out.println "Ejecutando el metodo '$nombre' con argumentos '$args'"
  //Obtenemos el metodo del metaClass
  def metodoValido = Float.metaClass.getMetaMethod(nombre,args)
  //Si no existe dicho metodo
  if(metodoValido == null){
    //Entonces regresamos la ejecucion convencional
    return Float.metaClass.invokeMissingMethod(delegate,nombre,args)
  }
  //Creamos un prefiltro
  System.out.println("Before...")
  //Invocamos al metodo original con sus parametros
  resultado = metodoValido.invoke(delegate,args)
  //Creamos uns postfiltro
  System.out.println("After...")
  //Regresamos la ejecucion del metodo
  resultado
}
 
//Usemos los metodos de la clase que no es propietaria
println 10F.intValue()
println 100F.toString()
try{
  50F.empty()
}catch(Exception e){
  println e.message
}
