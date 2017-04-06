abstract class A {
  String metodo(n){
    //doFoo()
    "Hola ${n*2}"
  }
}

interface Behat {
  int doFoo()
}

trait MyTrait {
  String attribute
  String metodo(n){
    doFoo()
    "Hola ${n*3}"
  }
  abstract int doFoo()
}

//class B extends A implements Behat {
class B implements MyTrait {
  String metodo2(){ 3+4+2 }
  int doFoo(){ println this.class; this.class.name.size() }
}

class C implements MyTrait {
  String metodo2(){ 4*6*7 }
  int doFoo(){ println this.class; this.class.name.size() }
}

//a = new A()
b = new B()
c = new C()

@groovy.transform.TypeChecked
def metodo(MyTrait a){
  println a.metodo("MakingDevs")
  //println a.doFoo()
}

//metodo(a)
metodo(b)
metodo(c)

