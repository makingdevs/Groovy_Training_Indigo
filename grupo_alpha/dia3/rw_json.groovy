import groovy.json.*

//payload = new URL("https://api.github.com/users/neodevelop/orgs").text
//jsonSlurper = new JsonSlurper()
//data = jsonSlurper.parseText(payload)
//
//println data*.login

jsonBuilder = new JsonBuilder()

jsonBuilder.curso {
  nombre 'Productividad con Groovy'
  duracion 10
  imparte 'MakingDevs'
  alumnos {
    alumno1 {
        nombre "abel"
    }
    alumno2 {
        nombre "jorge"
    }
  }
}

println jsonBuilder.toString()
println JsonOutput.prettyPrint(jsonBuilder.toString())
