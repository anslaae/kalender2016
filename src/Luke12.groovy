def message = "Your message was received with gratitude! We do not know about you, but Christmas is definitely our favourite holiday. The tree, the lights, all the presents to unwrap. Could there be anything more magical than that?! We wish you a happy holiday and a happy new year!"
def test = "a!Bc.,"

def binaryToRoman(int binary) {
    if(binary == 0)
        return "0"

    def RCODE = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
    def BVAL  = [1000, 900, 500, 400,  100,   90,  50, 40,   10,    9,   5,   4,    1]

    if (binary <= 0 || binary >= 4000) {  throw new NumberFormatException("Value outside roman numeral range.")  }

    String roman = "";         // Roman notation will be accumualated here.
    // Loop from biggest value to smallest, successively subtracting,
    // from the binary value while adding to the roman representation.
    for (int i = 0; i < RCODE.size(); i++) {
        while (binary >= BVAL[i]) {

            binary -= BVAL[i];
            roman  += RCODE[i];
        }
    }
    return roman;
}

def split(int c){
    def first = (int)((c+1)/2)
    def second = c - first
    return [first,second]
}

def alpha(String c){
    def alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    def i = 0
    while(alpha[i]!=c.toLowerCase()){
        i++
    }
    if(alpha[i]==c.toLowerCase())
        return i+1
    else
        return -1
}

def enc(String s){
    def s2 = s.replaceAll("[^A-z]","")
    println s2
    def c = s2.collect{
        split(alpha(it))
    }
    println c
    def start = c.collect{
        binaryToRoman(it[0])
    }
    def end = c.reverse().collect{
        binaryToRoman(it[1])
    }
    def result =  start + end
    println result.join(",")
}

enc(message)
