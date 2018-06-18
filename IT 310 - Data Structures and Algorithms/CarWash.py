# For lab on 9/22
# Code is an adaptation from
# http://interactivepython.org/runestone/static/pythonds/BasicDS/SimulationPrintingTasks.html
# Modifications made to work with built in queues and to be more fiesable for a carwash program

from queue import *
import random

class CarWash:
    def __init__(self, wph):
        self.washperhour = wph
        self.currentTask = None
        self.timeRemaining = 0

    def tick(self):
        if self.currentTask != None:
            self.timeRemaining = self.timeRemaining - 1
        if self.timeRemaining <= 0:
            self.currentTask = None

    def busy(self):
        if self.currentTask != None:
            return True
        else:
            return False

    def startNext(self,newtask):
        self.currentTask = newtask
        self.timeRemaining = newtask.getTime() * 60/self.washperhour

class Task:
    def __init__(self,time):
        self.timestamp = time
        self.runTime = random.randrange(1,16)

    def getStamp(self):
        return self.timestamp

    def getTime(self):
        return self.runTime

    def waitTime(self, currenttime):
        return currenttime - self.timestamp


def simulation(numMinutes, washPerHour):

    carwash = CarWash(washPerHour)
    washQueue = Queue(maxsize = 0)
    waitingtimes = []

    for currentMinute in range(numMinutes):

        if newWashTask():
            task = Task(currentMinute)
            washQueue.put(task)

        if (not carwash.busy()) and (not washQueue.empty()):
            nexttask = washQueue.get()
            waitingtimes.append(nexttask.waitTime(currentMinute))
            carwash.startNext(nexttask)

        carwash.tick()

    averageWait=sum(waitingtimes)/len(waitingtimes)
    print("Average Wait %6.2f mins %3d tasks remaining."%(averageWait,washQueue.qsize()))

def newWashTask():
    num = random.randrange(1,181)
    if num == 180:
        return True
    else:
        return False

for i in range(10):
    simulation(1440, 15)
