def saluda(nombre){
  "Hola $nombre"
}

def enElTiempo(nombre){
  "Hola ${saluda(nombre)} a las ${new Date().format('HH:mm')}"
}

println enElTiempo("Juan")
