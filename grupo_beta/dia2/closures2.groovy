def cuadrado(n, block){
  for(int i=0; i<n; i++)
    block(i)
}

//cuadrado(37.0, { if(it%2 == 0) println "cuadrado: ${it*it}" })
//cuadrado(20, { if(it%2 == 0) println "cuadrado: ${it*it}" })
//cuadrado(20) { if(it%2 == 0) println "cuadrado: ${it*it}" }
//cuadrado(20) { n, m -> if(n%2 == 0) println "cuadrado: ${n*n}" }
