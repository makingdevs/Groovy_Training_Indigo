lista = [1,2,3,4]
lista.add(4)
lista += [5,6,7,-1,-2,-3,-4]
lista << 10 << 20 << 30
lista.each { println it }
lista - [1,3,5,100]
lista = lista * 3
sublista = lista[-1..9]
lista.find { it == 10 }
lista.findAll { it == 10 }[-1..1].join(',')

println(lista.findAll{ it%2==1 }.collect { it*it }.sum())

