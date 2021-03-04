#AVDULLAHU PERPARIM - Groupe n°1
from gturtle import *

#à compléter
def triangle():
    repeat 3:
        right (120)
        forward(100)
        
        

def cercle(n,couleur):
    setPenColor(couleur)
    repeat n:
        triangle()
        penUp()
        forward (87)
        right(360/n)
        penDown()
        
#--main--
makeTurtle()
#à compléter

cercle(12,"blue")
