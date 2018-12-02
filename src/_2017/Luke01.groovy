package _2017

def t = new URL("https://s3-eu-west-1.amazonaws.com/julekalender-knowit-2017-vedlegg/wordlist.txt")

def goal = "aeteesasrsssstaesersrrsse"
//goal = "itseotltmlelteoitetss"
def lettersInGoal = goal.toCharArray().toList().sort().toUnique()

println "Goal: " + goal
println "Letters: " + lettersInGoal

def comp = []
t.eachLine {
    if(lettersInGoal.every { l -> it.contains(l.toString()) } && it.toCharArray().toList().toUnique().every {l -> lettersInGoal.contains(l)})
        comp+=it
}

def i = 1
while(i<7){
    comp.each {
        if(anagram(it, i) == goal.toCharArray().toList().sort()){
            println i+"-"+it
            return
        }
    }
    i++
}

def anagram(word, max){
    def res = []

    (0..(max-1)).each { m ->
        def i = 1
        def curr = ""
        word.substring(m).each { l ->
            if(i < max) {
                curr += l
                i++
            }
            else{
                curr += l
                i=1
                res+=curr
                curr = ""
            }
        }
    }
    return res.join().toCharArray().toList().sort()
}
