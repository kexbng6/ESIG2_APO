#ZAPATA MARIA- Groupe n°1
from gturtle import *

#à compléter
def segment():  
    dot(rayon)      
    
#à compléter
def triangle(x): 
    repeat 5:
        rt(90)
        dot(rayon)
        fd(x)
        dot(rayon)
        lt(120)
        fd(x)
        dot(rayon)
        lt(120)
        dot(rayon)
        fd(x)
        lt(120)
        dot(rayon)
        fd(x)
        dot(rayon)
        lt(90)

#à compléter
def rangee(x):
    repeat 5:
        triangle()
        segment()
        fd(x)	

#--main--
makeTurtle()
hideTurtle()
#à compléter
triangle(100)
segment(8)
rangee(8)