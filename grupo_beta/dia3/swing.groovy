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
frame.contentPane.add new JTextField()

button.addActionListener({ println "Hola mundo" } as ActionListener)

displayMouseLocation = { positionLabel.text = "${it.x}, ${it.y}" }

frame.addMouseMotionListener(displayMouseLocation as MouseMotionListener)
frame.addMouseListener(displayMouseLocation as MouseListener)

handleFocus = [
  focusGained: { msgLabel.text = "You're in..." },
  focusLost: { msgLabel.text = "You're OUT!!! " }
]

button.addFocusListener(handleFocus as FocusListener)

frame.show()
