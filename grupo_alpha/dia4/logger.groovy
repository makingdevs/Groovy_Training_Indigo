@Grab(group='commons-logging', module='commons-logging', version='1.2')
import groovy.util.logging.*

@Singleton
@Commons
class Service {

  def metodo(){
    log.info "Hola inmundo"
  }

}

Service.instance.metodo()
