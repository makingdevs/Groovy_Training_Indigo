def fiboMem;
def fibo = { n -> n< 2 ? n : fiboMem(n-1) + fiboMem(n-2) }
fiboMem = fibo.memoize()

def resultado = 0
def iterator = 1
def elementos = []
while(resultado < 4000000) {
    resultado = fiboMem(iterator++)
    resultado % 2 == 0 && elementos << resultado
}

println elementos.sum()
