String.metaClass.metodoQueNoExiste = { -> "Como ño?" }
String s = "hola mundo"
println s.getClass()
println s.charAt(3)
println s.metodoQueNoExiste()
println s.getClass()
