public class Player {
    private int account;
    private int turnCounter;
    private Square square;
    private String name;
    private Die[] die;


Player(String name,Die[] die,int balance){
    this.turnCounter=0;
    this.name=name;
    this.die=die;
    this.account=balance;

}

    public void incrementTurnCounter(){
    this.turnCounter++;
    }
    public boolean lostControl(){
        if(this.account<=0)
            return true;
        return false;
    }
public void playerTurn(Board board,MonopolyGame mgame ){
    printPlayerInfo(mgame);
   int diceSums=0;
    if(this.getAccount()>0){
        int dice1=this.getDie()[0].toss();
        int dice2=this.getDie()[1].toss();
        diceSums= dice1+dice2;
       this.incrementTurnCounter();
    }
    if(diceSums>=1){
        this.setSquare(board.getSquare()[(this.getSquare().getIndex()+diceSums)%40]);
    }
    if(this.square instanceof IncomeTaxSquare)
        this.payTax();
    printPlayerInfo(mgame);
}
public void payTax(){
    this.account=this.account-((IncomeTaxSquare)(this.square)).getTax();
}

public void printPlayerInfo(MonopolyGame mgame){
    String output="Player name : " +this.name  +" Player balance : "+
            this.account +" Player turn counter : " + this.turnCounter +
            " Cycle counter "+ mgame.getCycleCount() ;
    if(this.square instanceof  RegularSquare){
        output+=" Player location : "+ this.square.getName()+" Square type :  Regular Square ";

    }
    else if(this.square instanceof IncomeTaxSquare && !this.lostControl()){
        output+=" Player location : "+ this.square.getName() +" Square type :  Tax square  Tax amount " + ((IncomeTaxSquare)this.square).getTax();
    }

  main.print(output);
}
    public String getName() {
        return this.name;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    public Square getSquare() {
        return this.square;
    }



    public void setSquare(Square square) {
        this.square = square;
    }

    public Die[] getDie() {
        return this.die;
    }

    public int getAccount() {
        return this.account;
    }

    public int getTurnCounter() {
        return this.turnCounter;
    }


}
