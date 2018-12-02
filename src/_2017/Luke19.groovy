package _2017

def url = new URL("https://gist.githubusercontent.com/sverrejb/5206a64c649544619fd9c4fced5107a4/raw/f4ed471dd4f01d3a276d6241a565072bf250f5ba/path.txt")

def path = []
def ori = []

def last = [0,0]
def x = 0
def y = 0
url.eachLine {
    def l = it.split(", ")
    if(l[1]=="east"){
        x += Integer.valueOf(l[0])
        path.add([last,[last[0] + Integer.valueOf(l[0]),last[1]]])
    } else if(l[1]=="south"){
        y -= Integer.valueOf(l[0])
        path.add([last,[last[0],last[1] - Integer.valueOf(l[0])]])
    } else if(l[1]=="west"){
        x -= Integer.valueOf(l[0])
        path.add([[last[0] - Integer.valueOf(l[0]),last[1]],last])
    }else if(l[1]=="north"){
        y += Integer.valueOf(l[0])
        path.add([[last[0],last[1] + Integer.valueOf(l[0])],last])
    }
    last = [x,y]
    ori.add(last)
}


def min_x =  ori.sort{ a, b -> a[0] <=> b[0]}.first()[0]
def max_x = ori.sort{ a, b -> a[0] <=> b[0]}.last()[0]
def min_y = ori.sort{ a, b -> a[1] <=> b[1]}.first()[1]
def max_y = ori.sort{ a, b -> a[1] <=> b[1]}.last()[1]

(min_x..max_x).each { xx ->
    (min_y..max_y).each{ yy ->
        if(path.any{
            it[0][0]<=xx && it[1][0]>=xx && it[0][1]<=yy && it[1][1]>=yy
        })
            print "0O"
        else
            print "  "
    }
    print "\n"
}
