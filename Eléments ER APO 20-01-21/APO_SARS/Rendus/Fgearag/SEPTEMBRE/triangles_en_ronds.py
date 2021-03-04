#MULLER Theodor - Groupe n°1
from gturtle import *

#à compléter
def segment():
    repeat 5:
        penUp() 
        dot(5)       
        fd(12)
        penDown()
        
def angle1():
    dot(5)
    rt(45)
    
def angle2():
    dot(5)
    rt(90)
    
def angle3():
    dot(5)
    rt(135)

    
#à compléter
def rangee():
    repeat 5:
        penUp() 
        dot(5)       
        fd(60*1.414214/5)
        penDown()
        
def suite():
    penUp()
    back(60*1.414214)
    dot(5)
    rt(90)
    penDown()
    
def triangles():
    repeat 5:
        angle1()
        segment()
        angle2()
        segment()
        angle3()
        rangee()
        suite() 
#--main--
makeTurtle()
triangles()