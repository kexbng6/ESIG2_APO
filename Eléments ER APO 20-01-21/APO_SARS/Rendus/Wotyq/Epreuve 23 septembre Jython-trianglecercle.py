#BLANCO CUMPEN Jesus - Groupe n°1#
from gturtle import *

def triangle(couleur):
    setPenColor(couleur)
    right(150)
    forward(30)
    right(120)
    forward(30)
    right(120)
    forward(30)

def cercle(nbtri,peri,couleur):
    triangle(couleur)
    repeat(nbtri):
        forward(peri/nbtri)
        triangle(couleur)#ajouté###############
        right(360/nbtri)


makeTurtle()
hideTurtle()
cercle(12,500,"red")