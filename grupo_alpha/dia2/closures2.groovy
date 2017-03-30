def cuadrado(n, block){
  for(int i=0; i < n; i++)
    block(i)
}

cuadrado(20, { if(it%2 == 1) println "Cuadrado de ${it} = ${it*it}" })
