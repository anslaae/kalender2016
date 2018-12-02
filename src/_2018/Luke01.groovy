package _2018

def t = new URL("https://s3-eu-west-1.amazonaws.com/knowit-julekalender-2018/input-vekksort.txt")

//def t2 = ["5","4","3","6","7","5","2","7","5","1","1","10"]

BigInteger sum = 0
Long prev = 0;
Long cur = 0;
t.eachLine{
    cur = Long.parseLong(it)
    if(cur>=prev){
        sum+=cur
        prev = cur
    }
    //b+=BigInteger.valueOf(Long.parseLong(it));
}
println sum
