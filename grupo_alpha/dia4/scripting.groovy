@TimedInterrupt(10)
import groovy.transform.TimedInterrupt

while(true){
  status = "mysql.server status".execute().text
  if(status.contains("not running")){
    println "Se quieren agandallar"
    "mysql.server start".execute()
  }
}
