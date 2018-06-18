import random

class CustQueue:
    def __init__(self):
        self.data = []

    # Puts customers into queue
    def enqueue(self, item):
        self.data.append(item)

    # Removes them for service
    def dequeue(self):
        if len(self.data) != 0:
            return self.data.pop(0)

    # Returns line length
    def size(self):
        return len(self.data)

    # Adds a minute to waiting time of everyone in queue
    def tick(self):
        for item in self.data:
            item.waiting()

    #allows reading of the queue
    def __str__(self):
        return repr(self.data)

class Customer:

    def __init__(self, wait, time):
        self.arrival = wait
        self.serviceTime = time
        self.totalwait = 0

    def arriving(self): # Takes a minute off arrival time
        self.arrival -= 1

    def estArrTime(self): # Returns arrival time
        return self.arrival

    def service(self): # Takes a minute off service time
        self.serviceTime -= 1

    def svcTime(self): # returns remaining service time
        return self.serviceTime

    def waiting(self): #adds a minute to wait time for this customer
        self.totalwait += 1

    def getTime(self): #returns wait time in queue
        return self.totalwait

def simulation(minutes):

    waitQueue = CustQueue()
    totWaitTime = 0 # Total time spent in the waiting queue
    totalCust = 0 # Total number of customers served
    maximum = 0 #max number of customers in line
    maxWaitTime = 0 #maximum wait time

    firstRand = random.randint(1,4)
    secondRand = random.randint(1,4)

    firstCust = Customer(firstRand, secondRand)#Generates the first customer
    travelling = firstCust # First customer assigned to the travelling customer
    servicing = None # Initiates the servicing customer, nobody occupies now
    
    for currMin in range(minutes):
        
        travelling.arriving() #Takes a minute off of travel time
        if travelling.estArrTime() == 0:
            waitQueue.enqueue(travelling) # Puts customer in line when the arrive
            if waitQueue.size() > maximum: # If the size of the queue is greater than the maximum, next line makes current size maximum
                maximum = waitQueue.size()
            travelling = Customer(random.randint(1,4), random.randint(1,4)) # New customer in transit
            #print("A new customer has arrived (" + str(waitQueue.size()) + ")") #Alert for when a new customer arrives

        if servicing == None: # If there's no customer in service, gets one
            servicing = waitQueue.dequeue()
            
        if servicing != None: # If a customer is in service
            servicing.service() # Takes a minute off service
            if servicing.svcTime() == 0:
                if servicing.getTime() > maxWaitTime: #If wait time was greater than maximum, next line makes current wait time maximum
                    maxWaitTime = servicing.getTime()
                #Next two add to totals, first total wait time, then total customers served
                totWaitTime += servicing.getTime()
                totalCust += 1
                #print("A customer has finished service") #Alert for when a customer has finished sevice
                servicing = None #Means customer is no longer being serviced

        waitQueue.tick()

    avgWait = totWaitTime / totalCust
    print("Avg time in wait queue %6.2f mins %3d people left %3d served." %(avgWait, waitQueue.size(), totalCust))
    print("Maximum in line was %3d, maximum wait was %3d minutes." %(maximum, maxWaitTime))
    print("")

#runs 12 hour simulation 10 times
for i in range(10):
    simulation(720)
print("Done")
