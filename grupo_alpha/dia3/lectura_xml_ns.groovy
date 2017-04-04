entrenamiento = new XmlSlurper().parse("makingdevs_ns.xml").declareNamespace(fundamentals:'Essential')

cursos = entrenamiento.roadmap.category.'fundamentals:course'.collect { n -> "${n.'@name'}" }
println cursos.join("\n")
