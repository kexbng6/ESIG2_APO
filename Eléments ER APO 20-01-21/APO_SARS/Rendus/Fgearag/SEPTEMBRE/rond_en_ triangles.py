#MULLER Theodor - Groupe n°1
from gturtle import *

def triangle():
    lt(70)  
    fd(60*1.414214)
    rt(135)
    fd(60)
    rt(90)
    fd(60)
    right(45)
#à compléter
def cercle():
    repeat 12:
        triangle()
        penUp()
        rt(190)
        fd(50)
        penDown()
#--main--
makeTurtle()
cercle()
#à compléter