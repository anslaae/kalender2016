package _2017

def max = 1000

def d = (1..max).findAll {isPrime(it) && isPrime(it.toString().reverse().toInteger()) && !isPalindrome(it.toString())}

println d
println d.size()

def isPrime(number){
    def div = 2
    while(div < number && number%div > 0)
        div++
    return div>=number
}

def isPalindrome(word){
    int s = word.size()
    if(word.size()%2==0){
        return word.substring(0,(s/2).intValue()) == word.substring((s/2).intValue(),s).reverse()
    } else {
        return word.substring(0,((s-1)/2).intValue()) == word.substring(((s-1)/2).intValue()+1,s).reverse()
    }
}
