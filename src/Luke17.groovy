class Compute {
    def best
    def blackholes
    def max
    def visited = [:]
    def visits

    Compute(best, blackholes, max) {
        this.best = best
        this.max = max
        this.blackholes = blackholes
        visits = 0
    }

    def getBlackHolesOrderedByDistance(x, y){
        return blackholes.collectEntries{
            [it.key, computeDistance(x,y,it.key[0],it.key[1])]
        }.sort {
            it.value
        }
    }

    def computeDistance(x, y, x2, y2){
        return (x2>x?(x2-x):(x-x2))+(y2>y?(y2-y):(y-y2))
    }

    void move2(x,y,count) {
        visits++
        if (x == max && y == max) {
            if (count < best) {
                println "\tArrived at the end in " + count + " moves"
                best = count
            }
        } else if (!visited[x, y] || visited[x, y] > count) {
            visited[[x, y]] = count
            def ch = getBlackHolesOrderedByDistance(x, y)
            def r = computeDistance(x, y, max, max)

            move2(max, max, count + r)
            ch.each {
                def h = blackholes[[it.key[0], it.key[1]]]
                move2(h.value[0], h.value[1], count + it.value)
            }
        }
    }
}

def holes = [:]
holes[[1,2]]=[5,3]
holes[[3,4]]=[7,8]
holes = holes + holes.collectEntries {
    [it.value, it.key]
}

def max = 9

println "Computing test matrix..."
def compute = new Compute((max*2) + 1, holes, max)
compute.move2(0,0,0)
println "Found " + compute.best + " with " + compute.visits + " iterations"

holes = [:]
holes[[4027,98283]]=[83695,63613]
holes[[7527,68937]]=[22294,31187]
holes[[8800,49312]]=[11296,83909]
holes[[14519,47295]]=[54910,18357]
holes[[34172,74888]]=[38215,50481]
holes[[41187,8287]]=[94719,64497]
holes[[41952,229]]=[88333,84187]
holes[[45202,1108]]=[9617,37834]
holes[[49969,28072]]=[21579,16713]
holes[[88405,32174]]=[54748,58082]
holes[[96264,65077]]=[17247,22643]
holes = holes + holes.collectEntries {
    [it.value, it.key]
}

max  = 99999

println "\nComputing large matrix..."
compute = new Compute((max*2) + 1, holes, max)
compute.move2(0,0,0)
println "Found " + compute.best + " with " + compute.visits + " iterations"