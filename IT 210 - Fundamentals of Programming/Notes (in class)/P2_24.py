# P2_24

# import necessary graphics functionality provided by the authors
# graphics.py must be in the same folder as this file.
from graphics import GraphicsWindow

# Create the graphics window named win
win = GraphicsWindow(400, 400)

# Create a canvas we can draw on
canvas = win.canvas()

canvas.setColor("pink")
canvas.drawRect(100, 150, 100, 100) # draw pink square
canvas.setColor(200,30,180)
canvas.drawRect(250, 250, 100, 100) # draw custom purple square


win.wait()  # keep window open until user closes it.
