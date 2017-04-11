import groovyx.gpars.actor.Actor
import groovyx.gpars.actor.DefaultActor
 
class GuessMyNumber extends DefaultActor {
  int numeroSecreto
 
  void afterStart() {
    numeroSecreto = new Random().nextInt(50)
  }
 
  void act() {
    loop {
      react { int num ->
        if (num > numeroSecreto)
        reply 'muy alto'
        else if (num < numeroSecreto)
        reply 'muy pequeno'
        else {
          reply 'ganaste'
          terminate()
        }
      }
    }
  }
}
 
class Jugador extends DefaultActor {
  String nombre
  Actor servidor
  int miIntento
 
  void act() {
    loop {
      miIntento = new Random().nextInt(50)
      servidor.send miIntento
      react {
        switch (it) {
          case 'muy alto': println "$nombre: $miIntento fue muy alto"; break
          case 'muy pequeno': println "$nombre: $miIntento fue muy pequeno"; break
          case 'ganaste': println "$nombre: Gané $miIntento"; terminate(); break
        }
      }
    }
  }
}
 
def juego = new GuessMyNumber().start()
def jugador = new Jugador(nombre: 'Player', servidor: juego).start()
 
// Esto forza al hilo principal a vivir hasta que ambos actores paren
[juego, jugador]*.join()
