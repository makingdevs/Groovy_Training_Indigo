Unit tests
------------------------------------

Durante la realización de esta práctica realizaremos un ejercicio(Kata) que nos permitirá comprender el uso de JUnit, de las pruebas parametrizadas y del uso correcto de los Mocks/Stubs.

# 1. Kata FizzBuzz

1. Escribir una prueba en donde se llame al método `serie(n)` de una clase FizzBuzz,  en donde _n_ es un número entero(1 < n <= 100), y me regrese un arreglo/lista de longitud _n_, en donde todos sus tipos son String.
2. Escribir un conjunto de pruebas en donde llame al mismo método obteniendo el arreglo; dicho arreglo contendrá la secuencia de números sucesivos pero como String más no como números, pero cumpliendo las siguientes variantes:
  - Si el contenido del String es un número divisible entre 3 entonces no se pone el número si no la palabra "Fizz", por ejemplo: "3" es "Fizz", "21" es "Fizz"
  - Si el contenido del String es un número divisible entre 5 entonces no se pone el número si no la palabra "Buzz", por ejemplo: "5" es "Buzz", "25" es "Buzz"
  - Si el contenido del String es un número divisible entre 3 y 5 entonces no se pone el número si no la palabra "FizzBuzz", por ejemplo: "15" es "FizzBuzz", "30" es "FizzBuzz"
  - Cualquier otro número en la serie que no entre en las variantes anteriores es el mismo número, es decir: "4" es "4", "17" es "17"

Escribir una prueba por cada variante.

## Mejores pruebas

Una vez hecho hecho el ejercico anterior comprobar el uso de `org.junit.runners.Parameterized`

# 2. Manejo de colaboradores

Existe la necesidad de consumir un WebService inestable(SOAP) que obtiene la temperatura en grados Farenheit dado un país y una ciudad, una vez obtenido el dato se tiene que convertir a grados Centígrados para ser presentado. Se tiene que desarrollar lo siguiente:

1. Crear una prueba que permita obtener la temperatura de París, Francia(53ºF) y se presente en ªC
2. Crear una prueba que permita obtener la temperatura de Madrid, España(70ºF) y se presente en ªC
3. Crear una prueba que permita obtener la temperatura de D.F., México(70ºF) y arroje un error indicando que no es posible obtener la temperatura debido a un timeout
4. Crear una prueba que consulte dos veces la misma ciudad, pero que la segunda ocasión consulte de un caché en donde se guardó el resultado la primera vez que fue obtenido
5. Confirmar y comprobar que el orden de invocación del elemento anterior es correcto, es decir, primero obtenemos la temperatura del WS y despúes la consulta sea desde caché

> Nota: La fórmula para la conversión de grados Farenheit a Celsius es: (°F  -  32)  x  5/9 = °C
