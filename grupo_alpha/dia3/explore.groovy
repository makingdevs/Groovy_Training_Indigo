class AnyClass {
  def first = 1
  def getSecond() { first * 2 }
  public third = 3
  def myMethod() {}
}

def obj = new AnyClass()
assert obj.hasProperty('first')
assert obj.respondsTo('myMethod')
obj.with {
  first = 3
  third = 5
  println getSecond()
  myMethod()
}
