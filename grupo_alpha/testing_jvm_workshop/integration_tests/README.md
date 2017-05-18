Integration tests
------------------------------------

Durante la realización de este ejercicio estaremos probando componentes existentes de Spring, que en la mayor parte de los escenarios reales no tienen prueba.

> Una buena forma de saber como funciona un componente es realizando una prueba que permita explorar el conjunto de elementos que necesita sólo para operar.

En esta práctica tienes que demostrar que los _repositories_ y los _services_ que están en la aplicación funcionan de forma correcta y que afectan a la base de datos de la forma en que se espera.

Para los repositories tu tienes que:

- Comprobar que obtienes una lista de objetos persistentes
- Agregar un nuevo objeto persitente
- Actualizar un objeto persitente
- Borrar un objeto persistente
- Hacer conteos que demuestren que afectaste la base de datos

Para los services tu tienes que:

- Demostrar que los métodos hacen lo que dicen que tienen que hacer
- Si no lo hacen tienes que desarrollarlos, puedes usar los datos que ya existen o bien crear tus propios datos.
- Mostrar que los métodos de servicio de negocio participan en transacciones pero sin afectar la base de datos

Nota: Revisar la clase `org.springframework.test.jdbc.JdbcTestUtils`
