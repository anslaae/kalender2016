package _2017

println count(1024)

def count(Long number){
    return (number..1).collect {
        it
    }.sum()
}
