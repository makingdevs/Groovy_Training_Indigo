def discriminante(a,b,c){
  (b*b) - (4*a*c)
}

def unaSolucion(a,b,c){
  def d = discriminante(a,b,c)
  if(d < 0) throw new RuntimeException("No tiene solución")
  ((-1*b) - Math.sqrt(d)) / (2*a) 
}

println "Solución para 1x^2 + 16x + 64 es = ${unaSolucion(1,16,64)}"
