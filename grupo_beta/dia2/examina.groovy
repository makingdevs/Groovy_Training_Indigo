class A {
  def e = {
    println this.getClass().name
    println owner.class.superclass.name
    println delegate.class.superclass.name
    def nested = {
      println this.getClass().name
      println owner.class.superclass.name
      println delegate.class.superclass.name
    }
    nested()
  }
}

a = new A()

a.e()

//a.e {
//  println this.getClass().name
//  println owner.class.superclass.name
//  println delegate.class.superclass.name
//  a.e {
//    println this.getClass().name
//    println owner.class.superclass.name
//    println delegate.class.superclass.name
//    a.e {
//      println this.getClass().name
//      println owner.class.superclass.name
//      println delegate.class.superclass.name
//    }
//  }
//}
