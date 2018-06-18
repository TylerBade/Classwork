# Beans test driver

from simple2 import player as otherPlayer  # load opponent's player code
from Lab5 import player as me           # load your player code

def play(player0, player1):
    """Plays a single game of 'Heap of Beans'.  Winning player's # (0 or 1) is returned"""
    beans = 16  # Starting bean heap
    while True:
        take = player0(beans) # find out how many beans player0 takes
        if 1 <= take <= 3 and take <= beans:  # legal # of beans taken?
            beans -= take                     # adjust count of remaining beans
        else:  # user made bad move
            print("Bad move:", beans, "bean(s) and", take, "taken.")
            beans = 0  # force lose for bad move
        if beans == 0: # does player0 lose?
            return 1   # player 1 wins
        take = player1(beans) # find out how many beans player1 takes
        if 1 <= take <= 3 and take <= beans:  # legal # of beans taken?
            beans -= take                     # adjust count of remaining beans
        else:  # user made bad move
            print("Bad move:", beans, "bean(s) and", take, "taken.")
            beans = 0  # force lose for bad move
        if beans == 0: # does player1 lose?
            return 0   # player 0 wins    
    
def main():
    """Play 100 games of 'Heap of Beans' with each player starting 50 times."""
    wins = [0,0] # win accumulators for player0 and player1
    for i in range(100):
        if i%2:
            winner = play(me,otherPlayer)
        else:  
            winner = play(otherPlayer,me)
            winner = (winner+1)%2
        wins[winner] += 1
    print("My wins:", wins[0], "  Other wins:", wins[1])
    
main()  
