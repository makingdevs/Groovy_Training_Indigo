class Perfil {
  private String bio
  private Persona persona
  private String twitter
  private String facebook
}
 
class Pedido {
  Persona persona
  Date dateCreated
  Date lastUpdated
  String toString() {
    "$persona - $dateCreated"
  }
}

Persona p = new Persona()
p.setNombre("Juan")
println p
Perfil perfil = new Perfil()
perfil.bio = "Biography"
println new Date()
