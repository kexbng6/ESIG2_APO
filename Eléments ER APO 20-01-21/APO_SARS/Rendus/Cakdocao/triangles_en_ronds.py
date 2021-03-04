#ROJAS JUSTINIANO FABRICIO - Groupe n°1#
from gturtle import *

#à compléter
def segment(x):
    penUp() 
    repeat x: 
        dot(x)
        fd(x*2)      

#à compléter
def triangle(x): 
    segment(x)
    rt(120)
    segment(x)
    rt(120)
    segment(x)  
    rt(120)

#à compléter
def rangee(y,x):
    repeat y:
        triangle(x)
        setPos(x*x*2,0)
               
            
#x = taille du triangle en "points"
#y = nombre de rangée            
                    

#--main--
makeTurtle()
hideTurtle()
#à compléter
rt(30)
rangee(8,8)


