Specification tests
------------------------------------

## Groovy

Con ayuda del lenguaje dinámico Groovy podemos hacer uso de elementos muy útiles como los Power Asserts, los cuales detallan cada una de las ejecuciones y el resultado que arrojan, para al final hacer una comparación:

```groovy
assert [[1,2,3,3,3,3,4]].first().unique() == [1,2,3]
```

// Output:
//
// Assertion failed:
// assert [[1,2,3,3,3,3,4]].first().unique() == [1,2,3]
//                          |       |        |
//                          |       |        false
//                          |       [1, 2, 3, 4]
//                          [1, 2, 3, 4]

## GroovyTestCase

Groovy además, incluye características de JUnit para extender la forma en como se hacen pruebas:

```groovy
class MyTestCase extends GroovyTestCase {

  void testAssertions() {
    assertTrue(1 == 1)
    assertEquals("test", "test")

    def x = "42"
    assertNotNull "x must not be null", x
    assertNull null

    assertSame x, x
  }

}
```


Al usar lenguajes alternativos y dinámicos como Groovy, podemos encontrar una nueva forma de hacer tests. Una de los frameworks más conocidos es llamado Spock, del cual de manera general describimos la estructura a seguir:

```groovy
import spock.lang.*

class MySpecification extends Specification {
  // Campos
  def obj = new ClaseBajoSpec()
  def coll = new Colaborador()

  // Métodos comúnes o de accesorio
  def setup() {}          // corre antes de cada feature
  def cleanup() {}        // corre después de cada feature
  def setupSpec() {}     // corre antes de cualquier feature
  def cleanupSpec() {}   // corre hasta al terminarse de ejecutar el último feature

  // Métodos de features o características a probar
  def "Dado un estimulo al sistema/clase se espera una respuesta"(){

  }

  // Especificando a Spock
  def "mostrar el ciclo de ejecución de Spock"(){
    setup: "Aqui puedes inicializar recursos que necesites para la especificacion, también se puede usar 'given'"
      println "Inicializando recursos para\t\t${a}\t\t${b}\t\t${tamanio}"
    and: "Y algo más si lo deseas"
    //given: "O bien contextualizarlo como un feature con given-when-then, es un alias de setup"
    when: "Ejecutas acciones concretas, incluso de objetos no definidos aún"
      a.toLowerCase()
    then: "Evaluas los resultados de las acciones, por lo generla ocurrió algún efecto colateral"
      a.size() == tamanio
    expect: "Similar a when-then juntos, pero se usa para métodos pruamente funcionales"
      a.toLowerCase() == b
    cleanup: "Aqui puedes inicializar recursos que necesites para la especificacion"
      println "Limpiando recursos para\t\t\t\t${a}\t\t${b}\t\t${tamanio}"
    where: "Condiciones varias que serán evaluadas tantas veces como valores tengamos"
      a       | b       | tamanio
      "HOLA"  | "hola"  | 4
      "MUNDO" | "mundo" | 5
  }

  // Métodos de ayuda
  def metodoQueValidaLaSalida(){}
}
```

### Práctica final

Usa una especificación para hacer una prueba de integración de los servicios de Spring y una especificación para crear una prueba funcional.
