def combo(current){
    if(current.size()<6){
        (0..9).each{
            def c = []
            c.addAll(current)
            c.add(it)
            combo(c)
        }
    }else if(current.sum()==43  && current.join().toInteger()<500000 && square(current.join().toInteger())){
        println current.join()
    }
}

def square(c){
    def r = false
    (1..c/2).each{
        if(!r && it*it == c){
            r=true
        }
    }
    return r
}



(1..9).each{
    combo([it])
}