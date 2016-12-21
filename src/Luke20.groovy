/*

Å nei, i julestresset har Alvin glemt det eneste han skulle huske hele julen; det hemmelige tallet!
Det eneste han husker er at tallet er det høyeste mulige produktet hvis du multipliserer to tall som består av sifrene 0-9 hvor man bare kan bruke hvert siffer én gang.

F.eks er dette to gyldige tall å multiplisere: 12340 * 56789, mens dette er ikke to gyldige tall å multiplisere: 220135 * 74896

Hva er det hemmelige tallet Alvin har glemt?


 */



def combo(current, list, result){

    if(list.size()>0){
        list.each{
            def c = []
            c.addAll(current)
            c.add(it)

            def l = []
            l.addAll(list.findAll{f->f!=it})
            combo(c,l,result)
        }
    }else {
        result.add(current.join())
    }
}

def best(list){
    def best = 0
    list.each{ String s ->
        (1..s.length()-1).each{
            if(s.substring(0,it).toBigInteger()*s.substring(it).toBigInteger()>best){
                best = s.substring(0,it).toBigInteger()*s.substring(it).toBigInteger()
                println "Best so far: " + best
            }
        }
    }
}

def digits = (0..9)

def res = []
combo([],digits, res)
best(res)

