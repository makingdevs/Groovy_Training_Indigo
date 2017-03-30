def esPalindrome(frase, esValida){
  if(esValida(frase))
    println "es valida"
  else 
    println "NO es valida"
}

def validacion = { it == it.reverse() }

esPalindrome("Hola inmundo", validacion)
esPalindrome("anitalavalatina", validacion)
esPalindrome("algo") { s -> s.size() > 3  }
