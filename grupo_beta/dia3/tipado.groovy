//@groovy.transform.TypeChecked
//def c(s){
//    println s.toUpperCase()
//}
//c("hola")
//c('c')
//c(4)

//@groovy.transform.TypeChecked
//class Person {
//  String firstName
//  String lastName
//  String getFullName() { "$firstName $lastname" }
//}
//def p = new Person()

//@groovy.transform.TypeChecked
//int metodo(){
//  if(true){ 3 }
//  else { 'hola' }
//}
//
//metodo()

//@groovy.transform.TypeChecked
//def shout(String str) {
//  println "Printing in uppercase"
//  println str.toUpperCase()
//  println "Printing again in uppercase"
//  println str.toUppercase()
//}
//shout('hello')

@groovy.transform.TypeChecked
class Genericos{
  def usaLista() {
    ArrayList<Integer> list = new ArrayList<Integer>()
    list.add(1)
    list.add(2.0)
    list.add("hello")
    list
  }
}
def g = new Genericos()
println g.usaLista()
