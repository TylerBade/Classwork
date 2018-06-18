# Tyler Bade

def player(beans):
    while beans > 0:
        if beans >= 3:
            if beans % 2 == 1:
                return 2
            if beans % 2 == 0:
                return 3
        if beans == 2:
            return 1
        if beans == 1:
            return 1
