package _2017

def alpha = ["","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]

def key = [:]
def reverseKey = [:]

(1..alpha.size()-1).each {
    def pos = (it*2 + (int)alpha[it].toUpperCase()) % (alpha.size()-1)
    pos = pos==0?alpha.size()-1:pos
    key[alpha[it].toUpperCase()] = alpha[pos].toUpperCase()
    reverseKey[alpha[pos].toUpperCase()] = alpha[it].toUpperCase()
}

println "JULEMANN = " + solve("JULEMANN", key)
println "PWVAYOBB = " + solve("PWVAYOBB", reverseKey)
println "OTUJNMQTYOQOVVNEOXQVAOXJEYA = " + solve("OTUJNMQTYOQOVVNEOXQVAOXJEYA", reverseKey)

def solve(String word, key){
    def  res = word.toCharArray()
    (0..res.size()-1).each {
        res[it] = key[word[it]]
    }
    return res.toString().toUpperCase()
}
