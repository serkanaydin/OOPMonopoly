public class Player {
    private int account;
    private int turnCounter;
    private Square square;
    private String name;
    private Die[] die;


Player(String name,Die[] die){
    this.turnCounter=0;
    this.name=name;
    this.die=die;
    this.account=500;

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
    }
    if(diceSums>=1){
        this.setSquare(board.getSquare()[(this.getSquare().getIndex()+diceSums)%40]);
    }
    if(this.square.getMessage()!=null &&this.square.getMessage().equals("Tax square"))
        this.payTax();
    printPlayerInfo(mgame);
}
public void payTax(){
    this.account=this.account-this.square.getTax();
}

public void printPlayerInfo(MonopolyGame mgame){
    System.out.println("Player name : " +this.name + " Player balance : "+ this.account +" Player turn counter : " + this.turnCounter +" Cycle counter"+ mgame.getCycleCount()+" Player location : "+ this.square.getName() );
}
    public String getName() {
        return name;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    public Square getSquare() {
        return square;
    }



    public void setSquare(Square square) {
        this.square = square;
    }

    public Die[] getDie() {
        return die;
    }

    public int getAccount() {
        return this.account;
    }

    public int getTurnCounter() {
        return turnCounter;
    }


}
