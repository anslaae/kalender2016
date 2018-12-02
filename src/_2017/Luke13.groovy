package _2017

def t = new URL("https://gist.githubusercontent.com/sverrejb/deb3d94f76d493ce9bac185a303c081f/raw/e0943731bd8594b6e4e78c46a1b4755ecf620e74/loot.txt")

def loot = []

t.eachLine{loot.add(it.split(", "))}

def sortedLoot = loot.sort {a, b -> Long.valueOf(a[1]) <=> Long.valueOf(b[1])}.reverse()

def sequence = [false, true, true, false]

sequence.addAll(sequence.collect {!it})
while(sequence.size()< sortedLoot.size()){
    sequence.addAll(sequence.collect {!it})
}

long b = 0


def max = sortedLoot.size()-1
(0..max).each {
    if(sequence[it]){
        b+=Long.valueOf(sortedLoot[it][1])
    }
}

println b



