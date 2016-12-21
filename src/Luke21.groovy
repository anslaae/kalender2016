def t = new URL("http://pastebin.com/raw/LK5358RH")

def triangleA = []
def triangleB = []
def triangleC = []
t.eachLine {
    triangleA.add(it.split(" "))
    triangleB.add(it.split(" "))
    triangleC.add(it.split(" "))
}

traverse(triangleA)
println "A"+triangleA[0][0]

triangleB = rotate(triangleB)
traverse(triangleB)
println "B"+triangleB[0][0]

triangleC = rotate(rotate(triangleC))
traverse(triangleC)
println "C"+triangleC[0][0]

def traverse(tr){
    (tr.size()-2..0).each{ r ->
        def current = tr[r]
        (0..current.size()-1).each{ i ->
            current[i]=tr[r+1][i]>tr[r+1][i+1]?current[i].toInteger()+tr[r+1][i].toInteger():current[i].toInteger()+tr[r+1][i+1].toInteger()
        }
    }
}

def rotate(tr){
    return (0..tr.size()-1).collect { u ->
        (u..tr.size() - 1).collect { i->
            tr[i][u]
        }
    }.reverse()
}


