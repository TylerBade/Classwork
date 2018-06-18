# A simple player that will win occasionally
# Selects a random number of beans between 1 and 3 but ensures that a legal 
# number of beans is selected when the remaining number is small.

import random

def player(beans):
    if beans > 4:
	    return random.randrange(1,4)
    if beans == 1:
	    return 1
    return beans - 1
    
