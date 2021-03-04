#GOZAL ARY - Groupe n°# 1
from gturtle import *

#à compléter
def segment(taille):        
    fd(taille)


#à compléter
def triangle():
    rt(30)
    dot(4)
    fd(8)
    dot(4)
    fd(8)
    dot(4)
    fd(8)
    dot(4)
    fd(8)
    dot(4)
    rt(120)
    repeat 4:
        dot(4)
        fd(8)
    dot(4)
    rt(120)
    repeat 4: 
        dot(4)
        fd(8)
        
        
#à compléter
def rangee():
    repeat x:
        triangle()	

#--main--
makeTurtle()
#à compléter
hideTurtle()
penUp()
repeat 5:
    triangle()
    bk(32)
    rt(90)