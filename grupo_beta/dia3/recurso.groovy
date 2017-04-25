def factorial
factorial =  { int number, BigInteger fact ->
  number == 1 ?
    fact :
    factorial.trampoline(number - 1, number * fact)
}.trampoline()

//def factorial(BigInteger n){
//  n == 1 ? 1 : n * factorial(n-1)
//}

println factorial(4000, 1)
//println factorial(400, 1)
