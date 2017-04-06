import groovy.swing.SwingBuilder
 
import java.awt.BorderLayout
import javax.swing.JFrame
import java.awt.GridLayout
import java.awt.Color
 
SwingBuilder.build {
  myFrame = frame(title: 'Hilos en Swing', pack: true, defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
    borderLayout()
    def lazyPanelsParent
    scrollPane(constraints: BorderLayout.CENTER, preferredSize: [500, 300]) {
      lazyPanelsParent = panel(layout: new GridLayout(0, 1, 5, 5)) {
      }
    }
    panel(constraints: BorderLayout.NORTH) {
      button(text: 'Crear un panel', actionPerformed: {
        println 'Presionado'
        buildInTheBackground(lazyPanelsParent)
        })
    }
  }
  myFrame.show()
}
 
def buildInTheBackground(parentPanel) {
  SwingBuilder.build {
    def statusMessage = label(border: lineBorder(color:Color.RED, thickness:4))
 
    def setStatus = { String msg -> println msg; statusMessage.setText(msg) }
 
    setStatus('Construyendo...')
 
    parentPanel.add(statusMessage, 0)
 
    parentPanel.validate()
 
    doOutside {
      edt { setStatus('Trabajando por fuera') }
 
      // Un trabajo pesado...
      sleep(3000)
      def powerData = [* 0..5].collect {power -> [* 0..10].collect { Math.pow(it, power) } }
 
      def newPanel = panel(minimumSize: [250, 250], border: lineBorder(color:Color.BLUE, thickness:2)) {
        edt { setStatus("Construyendo un nuevo panel") }
 
        sleep(3000)
        tableLayout {
          powerData.each {row -> tr { row.each {cell -> td { textField(cell.toString()) } } } }
        }
      }
 
      edt { setStatus("Nuevo panel listo!") }
 
      doLater {
        setStatus("Agregando un nuevo panel")
        def idx = (parentPanel.components as List).indexOf(statusMessage)
        parentPanel.remove(idx)
        parentPanel.add(newPanel, idx)
        parentPanel.validate()
 
        setStatus("Construido...:)")
      }
    }
  }
}
