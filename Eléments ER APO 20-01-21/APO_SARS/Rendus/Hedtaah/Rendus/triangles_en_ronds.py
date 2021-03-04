#AMBROSI MATHIAS - Groupe n°1#
from gturtle import *

#à compléter
def segment(w,e):  
    repeat e:
            dot(w)
            penUp()
            fd(8)
            penDown()      

#à compléter
def triangle(w,e):
    repeat 3:
        segment(w,e)
        rt(120)
        

#à compléter
def rangee(q,w,e):
    x=0
    repeat(q):
        triangle(w,e)
        setPos(x,0)
        x=x+40

#--main--
makeTurtle()
#à compléter
hideTurtle()
setPos(0,0)
rt(30)
rangee(6,8,5)
