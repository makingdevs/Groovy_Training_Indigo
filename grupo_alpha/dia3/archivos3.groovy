file = new File("hola.txt")
file.write("hola inmundo !!!\n")

file.append("Como les va?\n")
file << "Hola de nuevo a las ${new Date()}"

new File("file_copy.txt").write(file.text)

binario = new File("/Users/makingdevs/Downloads/makingdevs.png")

new File("img_copia.png").withOutputStream { out ->
  out.write binario.readBytes()
}
