package _2017

class Compute {
    def max
    def arr

    def visited

    Compute(m) {
       max = m
       arr = new boolean[max][max]
       visited = new boolean[max][max]
    }

    def prepare(){
        (1..max).each { y ->
            (1..max).each { x ->
                arr[y - 1][x - 1] = wall(x, y)
            }
        }
    }

    def wall(long x, long y){
        def answ = (x*x*x) + (12*x*y) + (5*x*y*y)
        return Long.toBinaryString(answ).count("1")%2!=0
    }

    def setWallsAsVisited(){
        (0..max-1).each { y ->
            (0..max-1).each { x ->
                if(arr[y][x])
                    visited[y][x]=true
            }
        }
    }

    def print(){
        println "Array"
        arr.each { y ->
            y.each{ x ->
                if(!x)
                    print "_ "
                else
                    print "# "
            }
            print "\n"
        }

        println "\nVisited"
        visited.each { y ->
            y.each{ x ->
                if(x)
                    print "_ "
                else
                    print "# "
            }
            print "\n"
        }
    }

    def countUnvisited(){
        def total = 0
        visited.each { l ->
            total += l.findAll{v -> !v}.size()
        }
        return total
    }

    def move(x, y){
        if(x>=max || y>=max || y<0 || x<0 || visited[y][x])
            return
        if(!arr[y][x]){
            visited[y][x]=true
            goDown(x, y)
            goUp(x, y)
            goLeft(x, y)
            goRight(x, y)
        }
    }

    def goDown(oldX, oldY){
        def x = oldX
        def y = oldY+1
        move(x, y)
    }

    def goUp(oldX, oldY){
        def x = oldX
        def y = oldY-1
        move(x, y)
    }

    def goLeft(oldX, oldY){
        def x = oldX-1
        def y = oldY
        move(x, y)
    }

    def goRight(oldX, oldY){
        def x = oldX+1
        def y = oldY
        move(x, y)
    }

}

def compute = new Compute(10)
compute.prepare()
compute.goDown(0,0)//traverse

//compute.print()
compute.setWallsAsVisited()
println compute.countUnvisited()



