#AMBROSI MATHIAS- Groupe n°1#
from gturtle import *

#à compléter

def cercle(x,y,z):
    setPenColor(z)
    def triangle(x,y):
            repeat 3:
                fd(y/x)
                left(360/3)
    repeat (y):
        triangle(x,y)
        lt(60)
        fd(y/x)
        penUp()
        lt(60)
        fd(10)
        rt(160)
        penDown()
       
    
    
        
#--main--
makeTurtle()
#à compléter
hideTurtle()
cercle(12,500,"red")
