package _2018

def t = new URL("https://s3-eu-west-1.amazonaws.com/knowit-julekalender-2018/input-rain.txt")

def s = []
t.eachLine{
    def i = it.split("[,();]")
    def d = i.findAll{ p ->
        p.size()>0
    }
    x = Integer.valueOf(d[2])-Integer.valueOf(d[0])
    y = Integer.valueOf(d[3])-Integer.valueOf(d[1])
    s += y/x
}

def v = s.groupBy {it}
println v.collect {it.value.size()}.max()