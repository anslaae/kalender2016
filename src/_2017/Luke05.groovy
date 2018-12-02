package _2017

def max = 1000000

def t = new int[max]
t[0] = 1
t[1] = 2
t[2] = 2
t[3] = 3
t[4] = 3
t[5] = 4

def queue = []
queue.add(0,2)

def res = []
res.add((long)1)
res.add((long)2)

(2..(max-1)).each{
    def n = it+1
    def q = queue.pop()
    res.add((long)q)
    if(queue.size()<(max-it)){
        (1..q).each {
            queue.add(0,n)
        }
    }
}

println "\n\nFinished\n"
println res.size()
println res.sum()



// 1 * 1
// 2 * 2
// 2 * 3
// 3 * 4
