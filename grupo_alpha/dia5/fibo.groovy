def fiboMem;
def fibo = { it < 2 ? it : fiboMem(it-1) + fiboMem(it-2) }
fiboMem = fibo.memoize()

def resultado = 0;
def iterator = 1;
def elementos = [];
while(resultado < 4000000) {
    resultado = fiboMem(iterator++);
    resultado % 2 == 0 && elementos << resultado
}

println elementos.sum()
