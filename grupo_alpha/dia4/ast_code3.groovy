@Singleton
class Service {

}

println Service.instance
println Service.instance

class CustomCollection implements Set {
  @Delegate
  Set delegate = new HashSet()

  @Override
  boolean add(n){
    println "Adding $n"
    delegate.add(n)
  }

}

s = new CustomCollection()
s.add(5)
