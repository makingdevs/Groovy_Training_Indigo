//Incluso podemos implementar interfaces al vuelo sin necesidad de desarrollarlas todas
import javax.swing.*
import java.awt.*
import java.awt.event.*
 
// Incluso la palabra def es opcional
frame = new JFrame(size:[300,300],layout:new FlowLayout(), defaultCloseOperation:javax.swing.WindowConstants.EXIT_ON_CLOSE)
 
// Creamos unos componentes
button = new JButton("Click")
positionLabel = new JLabel("")
msgLabel = new JLabel("")
// Los agregamos
frame.contentPane.add button
frame.contentPane.add positionLabel
frame.contentPane.add msgLabel
frame.contentPane.add new JTextField("Texto")
 
// usemos los closures para agregar un listener
button.addActionListener(
  { JOptionPane.showMessageDialog(frame,"You clicked!") } as ActionListener
)
 
// Definamos un closure por fuera
displayMouseLocation = { positionLabel.setText("$it.x , $it.y") }
// Vamos a agregarlo al listener
frame.addMouseListener( displayMouseLocation as MouseListener )
frame.addMouseMotionListener( displayMouseLocation as MouseMotionListener )
// 
//// Vamos a definir un objeto del tipo Map al estilo Groovy
handleFocus = [
  focusGained : { msgLabel.setText "Good 2 see you..." },
  focusLost : { msgLabel.setText "Come back soon!!!..." }
]
// Lo usamos para otro listener
button.addFocusListener( handleFocus as FocusListener )
// 
//// Definimos una lista de eventos como Strings
events = [ 'WindowListener','ComponentListener' ]
 
// Un closure que es un handler
handler = { msgLabel.setText "$it" }
 
// Iteramos la lista
// Llamada a métodos formados de manera dinámica en tiempo de ejecución
for(event in events){
  handlerImpl = handler.asType(Class.forName("java.awt.event.${event}"))
  frame."add${event}"(handlerImpl)
}
 
//// Lo mostramos !!! :D
frame.show()
