def validaLaFrase(frase, validador){
  if(validador(frase))
    println "Chi"
  else
    println "Ño"
}

def v = { it == it.reverse()}
validaLaFrase("MakingDevs", v)
validaLaFrase("anitalavalatina", v)

validaLaFrase("1234") { it.size() > 5 }
