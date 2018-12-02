package _2017

def url = new URL("https://gist.githubusercontent.com/sverrejb/ee637135f5161220f83ef443c44b093c/raw/702802a54adf311f0dec8fc4598346f69e76e1e5/moves.txt")
def moves = url.getText().toCharArray().collect{
    Integer.valueOf(it.toString())
}

def board = resetBoard()
def winners = [:]
winners[0]=0
winners[1]=0
winners[2]=0

int current = 1
int starter = 1
int ties = 0
moves.each { move ->
    board[moveRow(move)][moveCol(move)]=current
    def r = winner(board)
    if(r!=null){
        winners[r]++
        if(r!=0){
            current=toggle(current)
            //println "Winner: " + r + " - Next: " + i + " - Last move: " + move + " - Starter: " + starter
            //printBoard(board)
            starter=current
            ties=0
        } else {
            ties++
            if(ties==3){
                ties=0
                current=toggle(starter)
                starter=current
            } else {
                current=starter
            }
        }
        board = resetBoard()
    } else{
        current=toggle(current)
    }
}

println winners

def resetBoard(){
    return new int[3][3]
}

def toggle(i){
    return i==1?2:1
}

def moveRow(move){
    return(Math.ceil((move)/3).toInteger()-1)
}

def moveCol(move){
    if(move%3==0)
        return 2
    else
        return (move%3)-1
}

def winner(int[][] board) {
    if(board[1][1]!=0 && (board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0]))
        return board[1][1]
    else if(board[0][0]!=0 && (board[0][0] == board[0][1] && board[0][1] == board[0][2] || board[0][0] == board[1][0] && board[1][0] == board[2][0]))
        return board[0][0]
    else if(board[1][1]!=0 && (board[1][0] == board[1][1] && board[1][1] == board[1][2] || board[0][1] == board[1][1] && board[1][1] == board[2][1]))
        return board[1][1]
    else if(board[2][2]!=0 && (board[2][0] == board[2][1] && board[2][1] == board[2][2] || board[0][2] == board[1][2] && board[1][2] == board[2][2]))
        return board[2][2]
    else if(board.any{row -> return row.any{return it==0}})
        return null
    else
        return 0
}

def printBoard(board){
    board.each{
        println it
    }
    println "--------"
}