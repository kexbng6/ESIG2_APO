#Kamsu Curtis
from gturtle import *
makeTurtle()  
#à compléter
def segment():
    dot(8)
    penUp()
    fd(8)
    penDown()
segment() 
#à compléter
def triangle():
    rt(30)
    repeat 3:
        segment()
        rt(120)
        rt(60)
        segment()
        lt(90)
triangle()

#à compléter
def rangee(nombre):
    repeat 5:
        triangle()
rangee()
#--main--
#à compléter 
     

  
    
