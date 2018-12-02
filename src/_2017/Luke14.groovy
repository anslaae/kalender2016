package _2017

def steps = 30
start(steps)


def start(steps){
    println step(steps-3, [3])+step(steps-2, [2])+step(steps-1,[1])
}


def step(stepsLeft, order){
    if(stepsLeft==0)
        return 1

    def c = 0

    if(stepsLeft>2){
        def o = [3]
        o.addAll(order)
        c += step(stepsLeft-3, o)
    }


    if(stepsLeft>1){
        def o = [2]
        o.addAll(order)
        c += step(stepsLeft-2, o)
    }

    if(stepsLeft>0){
        def o = [1]
        o.addAll(order)
        c += step(stepsLeft-1, o)
    }
    return c
}




