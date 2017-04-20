def cuadrado(n, block){
  for(int i=0; i<n; i++)
    block(i)
}

//cuadrado(20, { if(it%2 == 0) println "cuadrado: ${it*it}" })
//cuadrado(20) { if(it%2 == 0) println "cuadrado: ${it*it}" }
cuadrado(20) { n -> if(n%2 == 0) println "cuadrado: ${n*n}" }
