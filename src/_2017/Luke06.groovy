package _2017

def h = new URL("http://fil.nrk.no/yr/viktigestader/verda.txt")

BigDecimal osloLat = 59.911491
BigDecimal osloLong = 10.757933

def dist = []

h.eachLine {
//    def l = it.split()

        if(it.matches(".*[\\s]Hovedstad[\\s].*")) {
            def l = it.replaceAll("^..([\\s].*){3}[\\d]+[\\s]Hovudstad[\\s].*[\\s]([-]?[\\d]*\\.[\\d]*)[\\s]([-]?[\\d]*\\.[\\d]*)[\\s]([-]?[\\d]*)[\\s](http:.*\$)", "\$2 \$3 \$1")
            def ls = l.split()
            println l
            println ls
            dist.add([getDistanceFromLatLng(osloLat, osloLong, ls[0].toBigDecimal(), ls[1].toBigDecimal()),ls[2]])
        }
}

dist = dist.sort{ it[0]}
dist = dist.unique{it[1] + it[0]}
println dist
def sum = 0.0
def count = 0
def speed = 7274

sum += dist[count][0]/ speed
count++
while(sum<=24){
    println "Visited " + dist[count-1][1] + " " + sum + "km"
    sum += dist[count-1][0] / speed
    sum += dist[count][0] / speed
    count++
}

println count-1
println sum

static BigDecimal getDistanceFromLatLng(BigDecimal lat1, BigDecimal lng1, BigDecimal lat2, BigDecimal lng2) {
    def r = 6371 // radius of the earth in km
    lat1 = deg2rad(lat1)
    lat2 = deg2rad(lat2)
    BigDecimal lat_dif = lat2-lat1
    BigDecimal lng_dif = deg2rad(lng2-lng1)
    def a = square(Math.sin(lat_dif/2)) + Math.cos(lat1) * Math.cos(lat2) * square(Math.sin(lng_dif/2))
    def d = 2 * r * Math.asin(Math.sqrt(a))
    return d
}

static BigDecimal deg2rad(BigDecimal deg)
{
    return deg * (Math.PI/180)
}

static BigDecimal square(BigDecimal x){
    return Math.pow(x, 2)
}