#PINTO MARCIO - Groupe n°1
from gturtle import *

#à compléter
def cerclet(n,p,c):
    repeat(n):
        triangle(n,c)
        fd(p/n)
        rt(360/n)

def cercle(p, n):
    hideTurtle()
    repeat (p):
        fd(n)
        rt(360/p)
    showTurtle()

def peri(p):
    cercle(360, n / 360)        
    
def triangle(n,c):
    setPenColor(c)
    repeat (3):
        bk(n)
        lt(360/3)
        
#--main--
makeTurtle()
#à compléter
hideTurtle()
cerclet(30,800,"blue")
    