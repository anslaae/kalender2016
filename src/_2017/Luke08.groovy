package _2017

class Compute08 {
    def juletall = [:]
    long max

    Compute08(m) {
        max = m
    }

    def solve(){
        (0..max).each {
//            println "Solving " + it
            juletall[(long)it] = next(it)
        }
        println juletall.findAll {it.value}.collect {it.key}.sum()
    }

    def next(number) {
//        println "\t" + number
        def sum = number.toString().toCharArray().collect() {
            (Long.valueOf(it.toString())**2)
        }.sum()

        if (sum > 10000000) {
            return false
        }

        if(juletall.containsKey(sum)){
            return juletall[sum]
        }

        if (sum > 9) {
            return next(sum)
        } else if(sum == 1){
            return true
        } else {
            return false
        }
    }
}

new Compute08(10000000).solve()