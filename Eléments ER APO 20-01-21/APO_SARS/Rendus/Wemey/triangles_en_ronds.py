#PINTO MARCIO - Groupe n°1
from gturtle import *

#à compléter
def segment():        
    triangle()
    setPos(40,0)
    triangle()
    setPos(80,0)
    triangle()
    setPos(120,0)
    triangle()
    setPos(160,0)
    triangle()
#à compléter
def triangle():    
    rt(120)
    rangee()
    repeat 2:
        rt(120)
        rangee()
#à compléter
def rangee():	
    repeat 4:
        dot(8)
        penUp()
        fd(8)
        penDown()
    dot(8)
#--main--
makeTurtle()
#à compléter
hideTurtle()
lt(90)
segment()