#DALIPOVIC KADIR - Groupe n°1
from gturtle import *

def cercle(nombre_triangles, perimetre, couleur): # au lieu de ():
    setPenColor(couleur)
    repeat nombre_triangles :
        rt(150)
        repeat 3:
            fd(100)
            rt(120)
        lt(150)
        
        n= 30 #ajouté
        repeat n : 
            print "n = nombre de segments"
            fd(perimetre/n)#au lieu de permietre/n)
            rt(360/n)
        

#--main--
makeTurtle()

#au lieu cercle(nombre_triangles, perimetre, couleur()
cercle(12, 1000, "Blue") # au lieu de ()
