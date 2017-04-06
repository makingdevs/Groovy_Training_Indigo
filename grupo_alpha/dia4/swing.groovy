import groovy.swing.*

builder = new SwingBuilder()

contador = 0

frame = builder.frame(
    title:"DS Indigo", 
    size:[300,200], 
    defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE){

  flowLayout()
  lbl = label(text: "Hola inmundo")
  btn = button(text: "Puchurrame!", actionPerformed: {
      contador++
      lbl.text = "Contador en ${contador}"
      btn.text = "Presionado ${contador} veces"
      })

}
frame.show()

frame2 = builder.frame(title: "Demo", size:[300,200]){
  menuBar {
    menu("Archivo"){
      menuItem("New...")
      menuItem("Open...")
    }
  }
  panel {
    label 'My label'
    slider()
    comboBox(items:["uno","dos","tres"])
  }
}

frame2.show()
