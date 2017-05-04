import groovy.mock.interceptor.*
 
class StubAndMockTest extends GroovyTestCase{
 
  void testExcepciones(){
    def service = new Service()
    shouldFail { service.doMetodo1() }
    shouldFail(RuntimeException) { service.doMetodo2() }
    shouldFail RuntimeException, { service.doMetodoComplejo() }
  }
 
  void testStubs(){
    def dao = new StubFor( Dao )
 
    dao.demand.inserta { "Insertado..." }
    dao.demand.lee(2) { id -> id }
    dao.demand.borra { id -> 0 }
    dao.demand.actualiza { id -> 0}
    dao.use{
      def service = new Service()
      service.doMetodo1()
      assert 3 == service.doMetodo2(3)
      service.doMetodoComplejo(3)
    }
    dao.expect.verify()
  }
 
  void testMocks(){
    def dao = new MockFor( Dao )
 
    dao.demand.inserta { "Insertado..." }
    dao.demand.lee(2) { id -> id }
    dao.demand.actualiza() { id -> 0}
    dao.demand.borra() { id -> 0 }
    
    dao.use{
      def service = new Service()
      service.doMetodo1()
      assert 3 == service.doMetodo2(3)
      service.doMetodoComplejo(3)
    }
    dao.expect.verify()
  }
 
}

class Dao{
  void inserta(Object o){
    throw new RuntimeException('Insertate esta excpeción...')
  }
  Object lee(long id){
    throw new RuntimeException('Leete esta excpeción...')
  }
  int actualiza(Object o){
    throw new RuntimeException('Actualizate esta excpeción...')
  }
  int borra(long id){
    throw new RuntimeException('Borrate esta excpeción...')
  }
}

class Service{
  Dao dao = new Dao()
 
  void doMetodo1(){
    dao.inserta(new Object())
  }
  Object doMetodo2(long id){
    dao.lee(id)
  }
 
  int doMetodoComplejo(long id){
    Object o = dao.lee(id)
    //Cambios al objeto
    int i = dao.actualiza(o)
    int j = dao.borra(id)
  }
}

