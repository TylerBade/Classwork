# Tyler Bade

#Draw a house
#
#import necessary graphics functionality provided by the authors
from graphics import GraphicsWindow

#create the graphics window named win
win = GraphicsWindow(400, 400)

#create a canvas we can draw on
canvas = win.canvas()

#Draw the house.
canvas.setColor("blue")
canvas.drawRect(100,150,200,200)
canvas.setOutline("red")
canvas.drawLine(100,150,200,50)
canvas.setOutline("red")
canvas.drawLine(300,150,200,50)
canvas.setColor("red")
canvas.drawRect(140,270,40,80)
canvas.setColor("green")
canvas.drawOval(120,170,50,50)
canvas.setColor("orange")
canvas.drawLine(120,195,170,195)
canvas.setColor("orange")
canvas.drawLine(145,170,145,220)
canvas.setColor("yellow")
canvas.drawRect(220,270,50,50)
canvas.setColor("yellow")
canvas.drawRect(230,160,50,80)
canvas.setColor("gold")
canvas.drawOval(140,310,10,10)

#this statement will make the window stay open
win.wait()
