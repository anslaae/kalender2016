package _2017

def grid = new boolean[10][10]
def gridValue = new int[10][10]



def moves = []
moves.add([1, 2])
moves.add([1, -2])
moves.add([2, 1])
moves.add([2, -1])
moves.add([-1, 2])
moves.add([-1, -2])
moves.add([-2, 1])
moves.add([-2, -1])

(0..9).each { x ->
    (0..9).each{ y ->
        gridValue[x][y]=value(x,y)
    }
}

def x = 0, y = 0
def max = 200


(1..max).each{

    def move =  moves.findAll{x+it[0]>=0 && x+it[0]<10 && y+it[1]>=0 && y+it[1]<10 && grid[x+it[0]][y+it[1]] == grid[x][y]}.sort { a, b ->
        gridValue[x+a[0]][y+a[1]]<=>gridValue[x+b[0]][y+b[1]]
    }[0]

    if(!move){
        move =  moves.findAll{x+it[0]>=0 && x+it[0]<10 && y+it[1]>=0 && y+it[1]<10}.sort { a, b ->
            gridValue[x+a[0]][y+a[1]]<=>gridValue[x+b[0]][y+b[1]]
        }.reverse()[0]
    }

    grid[x][y] = !grid[x][y]
    x += move[0]
    y += move[1]

//    println grid
//    println x + ":" + y

    //find best move
    //change current

    //move x+1 y+2
    //     x+1 y-2
    //     x+2 y+1
    //     x+2 y-1
    //     x-1 y+2
    //     x-1 y-2
    //     x-2 y+1
    //     x-2 y-1
}

println "---------------"
println grid.collect {it}.flatten().findAll{it}.size()

def value(x, y){
    return 10*x + y
}