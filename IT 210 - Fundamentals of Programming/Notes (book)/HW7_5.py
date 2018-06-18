# Tyler Bade

inputFileName = input("Input file name: ")

infile = open(inputFileName, "r")

lines = 0
words = 0
chars = 0

line = infile.readline()
for line in infile:
    lines += 1
words = len(infile.split())


infile.close()

print("There are", lines, "lines in the file.")
print("There are", words, "words in the file.")
print("There are", chars, "characters in the file.")
