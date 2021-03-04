#DALIPOVIC KADIR - Groupe n°1
from gturtle import *

def segment():
    repeat 5 :
        dot(8)
        penUp()
        fd(8)
        penDown()

def triangle():
    rt(30)
    repeat 3 :
        segment()
        rt(120)
    rt(60)
    segment()
    lt(90)

def rangee():
    repeat 5 :
       triangle()

makeTurtle()
rangee()