# Tyler Bade
# Sebastian Millin
# Edoardo Tagliaferri

infile1 = input("Enter a filename: ")
infile2 = input("Enter a second file: ")
OUTFILE = "output.txt"

in1 = open(infile1, "r")
in2 = open(infile2, "r")
out = open(OUTFILE, "w")

lines1 = in1.readlines()
lines2 = in2.readlines()

newfile = ""

i = 0
while i < len(lines1) and i < len(lines2):
    newfile = newfile + lines1[i] + lines2[i]
    i += 1
    if i == len(lines1) - 1:
        newfile = newfile + lines1[i] + "\n" + lines2[i]
        i += 1

out.write(newfile)

in1.close()
in2.close()
out.close()
