import static groovyx.gpars.actor.Actors.*
 
def decriptor = reactor { code -> code.reverse() }
def muestra   = reactor { println it }
def main    = actor   {
  decriptor 'terces pot'
  react { plainText ->
    muestra plainText
  }
}
main.join()
muestra.stop()
muestra.join() 
