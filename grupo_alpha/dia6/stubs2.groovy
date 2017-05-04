import groovy.mock.interceptor.StubFor

 class Person {
   String first, last
 }

 class Family {
   Person mother, father
   def nameOfFather() { "$father.first $father.last" }
 }

 def stub = new StubFor(Person)
 stub.demand.with {
   getLast{ 'name' }
   getFirst{ 'dummy' }
 }
 stub.use {
   def john = new Person(first:'John', last:'Smith')
   def f = new Family(father:john)
   assert f.nameOfFather() == 'dummy name'
 }
 stub.expect.verify()