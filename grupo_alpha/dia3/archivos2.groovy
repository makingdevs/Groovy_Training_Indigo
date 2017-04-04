file = new File("/Users/makingdevs/Downloads/Teradata_txt.txt")
lines = file.readLines()
println lines
println "Lines in file: ${lines.size()}"
file.splitEachLine(" ") { palabras ->
    println palabras
    println palabras.size()
}
