#SULA LEONORA- Groupe n°1
from gturtle import *

#à compléter
def cercle(P,N):
    repeat N:
        penUp()
        fd(P/N)
        rt(N/N)
        penDown()
def triangle_couleur(m,cote, couleur):
    setPenColor(couleur)
    repeat m:
        rt(150)
        fd(cote)
        rt(120)
        fd(cote)
        rt(120)
        fd(cote)
        penUp()
        fd(cote)
        penDown()
#--main--
makeTurtle()
hideTurtle()
cercle(800,360)
triangle_couleur(12,50, "red")

#à compléter