package _2017

def t = new URL("https://pastebin.com/raw/sGbqMyCa")

def c = 0
t.eachLine {
    if(!isPalindrome(it) && hasPalindrome(it)){
        c++
    }
}
println c


def hasPalindrome(String word){
    def hasPalindrome = true
    def hasOdd = false
    word.toCharArray().toList().unique().each {
        if(word.count(""+it)%2!=0 && hasOdd)
        {
            hasPalindrome = false
        } else if (word.count(""+it)%2!=0 && !hasOdd){
            hasOdd = true
        }
    }
    return hasPalindrome
}

def isPalindrome(word){
    int s = word.size()
    if(word.size()%2==0){
        return word.substring(0,(s/2).intValue()) == word.substring((s/2).intValue(),s).reverse()
    } else {
        return word.substring(0,((s-1)/2).intValue()) == word.substring(((s-1)/2).intValue()+1,s).reverse()
    }
}

/*brute force*/
//def c = 0
//t.eachLine {
//    if(!isPalindrome(it) && compute(it)){
//        c++
//    }
//}
//println c

def compute(word){
    int i = 0
    while(i<word.size() && !combo("",word, i)){
        i++
    }
    return i<word.size()
}




def combo(anagram, word, index){
    StringBuilder sb = new StringBuilder(word)
    sb.deleteCharAt(index)
    def rest = sb.toString()

    anagram+=word.charAt(index)

    if(rest.size()==2){
        if(isPalindrome(anagram + rest) || isPalindrome(anagram + rest.reverse())){
            return true
        }
        return false

    } else {
        int i = 0
        while(i<rest.size() && !combo(anagram,rest, i)){
            i++
        }
        return i<rest.size()
    }
}