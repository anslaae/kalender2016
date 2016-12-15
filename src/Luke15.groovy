

def comp(s){
    def newSeq = []
    def count = 1
    (1..s.size()-1).each{
        if(s[it-1] != s[it]){
            newSeq << count.toString()
            newSeq << s[it-1]
            count = 1
        } else {
            count++
        }
    }

    newSeq << count.toString()
    newSeq << s[s.size()-1]
    return newSeq
}

def seq = "1111321112321111".toCharArray()
def seq1 = "13".toCharArray()

(1..50).each{

    seq = comp(seq)

    println it + ": " + seq.size()// + " -> " + seq.join()
}
