import static groovyx.gpars.GParsPool.withPool

def jobs = [300,100,500,800,900,100,200]

init = System.currentTimeMillis()
withPool(10) {
  //x = jobs.collectParallel {
  //  Thread.sleep it
  //    println "Doing $it"
  //    it * it
  //}
  //end = System.currentTimeMillis()
  //println x
}


//println "Total time : ${end - init}"

def calculo(lista){
  lista.collect {
    it * 3
  }
}

withPool(10) {
  println calculo(jobs.makeConcurrent())
}
