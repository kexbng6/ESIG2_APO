#ZAPATA MARIA - Groupe n°1
from gturtle import *

def triangle():
    repeat 3:
        rt(90)
        fd(50)
        rt(150)
    rt(30)
    fd(50)
    penUp()
    fd(15)
    rt(30)
    penDown()
    
def triangle_boucle():
    repeat 2:
        repeat 360:
            triangle()
            rt(2)
            fd(1)
           
    
#à compléter
def cercle():
    repeat 12:
        fd(1000/12)
        rt(360 / 12)
        repeat 12:
            triangle()
            

    
        

#--main--
makeTurtle()

#à compléter
cercle()