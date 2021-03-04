
#DA SILVA DANIEL - Groupe n°1
from gturtle import *
makeTurtle()
penUp()

def segment():
    fd(5)
    
def triangle():
 fd(8)
 dot(4)
 right(120)
 dot(4)
 fd(8)
 dot(4)
 repeat 4:
    dot(4)
    fd(8)
 triangle()

def rangee():
    repeat 5:
     dot(4)
triangle()
        
rangee()
makeTurtle()
    
    	

#--main--
makeTurtle()
hideTurtle()