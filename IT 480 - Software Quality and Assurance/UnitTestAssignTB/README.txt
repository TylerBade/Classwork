Commands to run the code:

COMPILE:

Program:
javac newCoffee.java Game.java House.java Player.java Room.java

Testing program:
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar coffeeMakerTest.java


RUN:

Program:
java newCoffee

Test:
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore coffeeMakerTest