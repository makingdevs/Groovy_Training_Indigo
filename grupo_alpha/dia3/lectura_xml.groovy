doc = new XmlSlurper().parse("makingdevs.xml")
println doc.'@organization'
doc.roadmap.category.each { c ->
    println "${c.'@name'}"
      for(course in c.course){
        println """\t${course.text().trim()}
          Duración: ${course.'@duration'}
        """
      }
}
