#ROJAS JUSTINIANO FABRICIO - Groupe n°1#
from gturtle import *

#à compléter
def triangle(x,y):
    repeat x:
        penUp()
        fd(y)
        penDown()
        repeat 3:
            lt(120)
            fd(y)
        rt(45)

def cercle(x,y,z):
    setPenColor(z)
    triangle(x,y)
        
#--main--
makeTurtle()
hideTurtle()
#à compléter
cercle(12,100,"red")