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
  g.usaLista()
