class User {
  String username
  String bio
  Date fechaDeNacimiento
  String toString(){ "$username ${bio.substring(0,10)} $fechaDeNacimiento " }
}

u1 = new User(username:"neodevelop",bio: "Trabaja en MD", fechaDeNacimiento: new Date()-7000)
u2 = new User(username:"cggg88",bio: "Trabaja en MD como programador", fechaDeNacimiento: new Date()-6000)
u3 = new User(username:"username",bio: "Estar en Indigo")

mapa = [user1: u1, user2:u2]
mapa.user3 = u3

//mapa.each { println it }
//mapa.each { mapEntry -> println mapEntry }
mapa.each { k, v -> println "$k == $v" }

println mapa.find { key,user -> user.bio.contains("MD") }
println mapa.findAll { key,user -> user.bio.contains("MD") }
println mapa.collect { k,v -> v }
