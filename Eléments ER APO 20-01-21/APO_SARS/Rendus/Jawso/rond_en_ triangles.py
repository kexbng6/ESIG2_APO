#MANZAMBI HOLLY - Groupe n°1
from gturtle import *

def triangle(longueur,couleur):
    lt(180)
    setPenColor(couleur)
    repeat 3:
        fd(longueur)
        lt(360/3)
        
        
#à compléter
def cercle():
    triangle(30,"red")
    repeat 12:
        right(30)
        fd(15)
        back(30)
        rt(60)
        fd(30)
        lt(120)
        fd(30)
        
    
    
        
#--main--
makeTurtle()

cercle()








#à compléter