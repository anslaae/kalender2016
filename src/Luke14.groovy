
//2.25 * 10^32

BigInteger minimum = 2.25*(10.power(32))

def metals = [:]
(1..16).each{
    metals[it]=it.power(it)
}
println metals

def result = []

BigInteger findFactorialGroovy(BigInteger n) {
    return (n == 1) ? 1 : n * findFactorialGroovy(n - 1)
}

combo([], metals, result,minimum)

def low = 99999999999
def lowValue

result.each { it2 ->
    //println it2.join(",")
    def fac = it2.sum{findFactorialGroovy(it.key)}
    //println it2 + " : " + fac
    if(fac < low){
        low = fac
        lowValue = it2
    }
}

def d = [9,8].sum{findFactorialGroovy(it)}
println d

println minimum
println lowValue
println compute(lowValue)
lowValue.each{
    print it.key
}

def compute(c){
    BigInteger b = 1
    c.each{
        b=b*it.value
    }
    return b
}

def combo(current, met, result, minimum){
    //println "next [" + current +"] -> "+met
    met.each{ it ->
        def m = met.findAll{ it2 -> it2.key > it.key}
        def c = current + it
        combo(c, m,result, minimum)
    }

    if(current.size()%2==0 && compute(current)>minimum)
        result << current
}
