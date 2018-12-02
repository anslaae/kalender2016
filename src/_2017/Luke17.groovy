package _2017

def r = 6
def found = false
while(!found && r<Long.MAX_VALUE){
    if(r.toString().charAt(r.toString().size()-1)=="6" && switchNumber(r) == r*4)
        found = true
    else
        r++
}
println r

def switchNumber(long number){
    number.toString().replaceAll("(.*)([6])", "\$2\$1").toLong()
}


