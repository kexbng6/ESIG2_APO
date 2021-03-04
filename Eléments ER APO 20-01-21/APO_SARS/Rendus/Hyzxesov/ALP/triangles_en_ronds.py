#AVDULLAHU PERPARIM - Groupe n°#
from gturtle import *

#à compléter
def segment(n,t):
    repeat n:
        dot(t)
        penUp()
        forward(15)
        penDown()        

#à compléter
def triangle():
    repeat 3:
        segment(4,8)
        right(120)    

#à compléter
def rangee(z):
    a=60
    repeat z:
        triangle()
        setPos(a,0)
        a=a+60	

#--main--
makeTurtle()
right(30)
rangee(5)
#à compléter