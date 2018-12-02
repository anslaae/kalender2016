package _2017

def people = []

def max = 1500

(0..max-1).each {
    people[it] = true
}

int server = 0
while(people.findAll{it}.size()>1){

    def drinker = (server+1)%max
    while(!people[drinker])
        drinker=(drinker+1)%max
    people[drinker] = false

    server = (drinker+1)%max
    while(!people[server])
        server=(server+1)%max
}


println server+1
