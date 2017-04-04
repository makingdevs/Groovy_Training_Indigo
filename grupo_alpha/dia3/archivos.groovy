env = System.getenv("ENV") ?: 'development'
userHome = System.getenv("HOME")
println userHome
home = new File(userHome)
println home.class.name
dirs = []
files = []

home.eachDir {
  dirs << it.name
}

home.eachFile {
  files << it.name
}
println dirs
println files

println home.properties.collect { k, v ->
  "$k \t=>\t $v"
}.join("\n")
