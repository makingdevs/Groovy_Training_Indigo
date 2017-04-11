import static groovyx.gpars.GParsPool.withPool

url = ["http://groovyando.org","http://makingdevs.com","http://groovy.apache.org","http://www.google.com" ]

withPool {
  r = url.parallel
  .map { it.toURL().text.toLowerCase() }
  .map { Thread.sleep 1000*60*2  }
  .filter { it.contains('groovy') }
  .map { it.split() }
  .map { it.findAll { w -> w.contains 'groovy'  }.size()  }
  .map { Thread.sleep 1000*60*2  }
  .sum()

  l = [1,2,3,4,5,6,7].parallel
  .map { it + 1  }
  .map { it ** 2 }
  .reduce { a,b -> a + b  }
}
 println l
println r
