import javax.swing.*
import java.awt.*
import java.awt.event.*

frame = new JFrame(layout: new FlowLayout(), size:[300, 300], title:"Hola Indigo")

button = new JButton("Click")
label1 = new JLabel("Show me")
positionLabel = new JLabel("")
msgLabel = new JLabel("")

frame.contentPane.add button
frame.contentPane.add label1
frame.contentPane.add positionLabel
frame.contentPane.add msgLabel

button.addActionListener({ println "Hola mundo" } as ActionListener)

displayMouseLocation = { positionLabel.text = "${it.x}, ${it.y}" }

frame.addMouseMotionListener(displayMouseLocation as MouseMotionListener)
frame.addMouseListener(displayMouseLocation as MouseListener)



frame.show()
