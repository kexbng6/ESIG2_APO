#BLANCO CUMPEN Jesus - Groupe n°1#
from gturtle import *
 
def segment(taillep):
     dot(taillep)
     forward(taillep*2)
     dot(taillep)
     forward(taillep*2)
     dot(taillep)
     forward(taillep*2)
     dot(taillep)
     forward(taillep*2)
     dot(taillep)

def triangle(taillep,nbtriangle):
    repeat(nbtriangle):
        right(90)
        segment(taillep)
        back(taillep*taillep)
        left(60)
        segment(taillep)
        right(120)
        segment(taillep)
        left(150)


makeTurtle()
hideTurtle()
triangle(8,5)