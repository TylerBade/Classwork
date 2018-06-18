def revstr(str):
    if str == "":
        return str;
    else:
        return revstr(str[1:])+str[0];

string = "Backward";
print(revstr(string));
