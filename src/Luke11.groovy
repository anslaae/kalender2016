TimeZone tz = TimeZone.getTimeZone("UTC")
Locale l = new Locale("NO", "NO")
GregorianCalendar c = new GregorianCalendar(tz,l)

long max = 2147483647
long soFar = 0

c.set(1970,0,1,0,0,0)
c.setTimeInMillis(0)

while(soFar<=max){
    if((soFar+(25*60*60))<max){
        c.add(GregorianCalendar.DAY_OF_MONTH, 1)
        soFar+=25*60*60
    } else {
        c.add(GregorianCalendar.SECOND,1)
        soFar++
    }
}

println c.toZonedDateTime()
println c.getTimeInMillis()
println soFar

