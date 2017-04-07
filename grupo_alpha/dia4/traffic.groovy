@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.1' )
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import static groovyx.gpars.GParsPool.withPool
import java.util.Random

def peticiones = []
def urls = [
  "http://makingdevs.com/"
  ]

1.upto(10000){
  Random rand = new Random()
  peticiones << urls[rand.nextInt(urls.size())]
}

withPool{
    peticiones.eachParallel{ job ->
			println job
      llamada(job)
    }
}


llamada()

def llamada(url){
  
  def http = new HTTPBuilder(url)


  http.request(GET,TEXT) { req ->
    headers.'User-Agent' = 'Mozilla/5.0'

    response.success = { resp, reader ->
      assert resp.status == 200
      //println "My response handler got response: ${resp.statusLine}"
      //println "Response length: ${resp.headers.'Content-Length'}"
      //System.out << reader // print response reader
    }

    // called only for a 404 (not found) status code:
    response.'404' = { resp ->  
      println 'Not found'
    }
  }  
}
