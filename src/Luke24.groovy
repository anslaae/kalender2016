def alpha = ['','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

def t = 90101894

def solution = ""

while(t>0){
   solution += alpha[(t % 26)]
   t = (int)(t/26)
}

println solution.reverse()