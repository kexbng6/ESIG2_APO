#SULA LEONORA - Groupe n°1
from gturtle import *

#à compléter
def segment():
    repeat 5:
        dot(8)
        fd(8)
    
#à compléter
def triangle():
    rt(30)
    segment()
    rt(120)
    segment()
    rt(120)
    segment()
    rt(90)
    left(30)
    segment()
    left(120)
    segment()
    left(120)
    segment()
#à compléter
def rangee():
    rt(0)
#--main--
makeTurtle()
triangle()
segment()
rangee()
#à compléter