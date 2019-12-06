import java.util.ArrayList;

public class Player {
    private int account;
    private int turnCounter;
    private Square square;
    private String name;
    private Die[] die;
    private ArrayList<PurchasableSquare> ownerSquares;


Player(String name,Die[] die,int balance){
    this.ownerSquares = new ArrayList<PurchasableSquare>();
    this.turnCounter=0;
    this.name=name;
    this.die=die;
    this.account=balance;
}

private void incrementTurnCounter(){
    this.turnCounter++;
    }
void playerTurn(Board board, MonopolyGame mgame){
    printPlayerInfo(mgame);
    this.square.printSquareInfo();
   int diceSums=0;
   int dice1=0;
   int dice2=0;
    if(this.getAccount()>0){
        dice1=this.getDie()[0].toss();
        dice2=this.getDie()[1].toss();
        diceSums= dice1+dice2;
       this.incrementTurnCounter();
    }
    if(diceSums>=1){
      String output="Turn player : "+ this.name +" Dice 1 face value : " + dice1 + " Dice 2 face value : " + dice2 + " Total value : " + diceSums;

        printPlayerInfo(mgame);
        System.out.println(output);
if(!(this.square instanceof GoToJailSquare ) || dice1==dice2)
        this.setSquare(board.getSquare()[(this.getSquare().getIndex()+diceSums)%40]);
    }
    this.square.landedOn(this);
    System.out.println();
}
void printPlayerInfo(MonopolyGame mgame){
    String output="Player name : " +this.name  +" Player balance : "+
            this.account +" Player turn counter : " + this.turnCounter +
            " Cycle counter "+ mgame.getCycleCount() ;
    System.out.println(output);
}
    String getName() {
        return this.name;
    }
    void setAccount(int account) {
        this.account = account;
    }
    private Square getSquare() {
        return this.square;
    }
    void setSquare(Square square) {
        this.square = square;
    }
    private Die[] getDie() {
        return this.die;
    }
    int getAccount() {
        return this.account;
    }
void addOwnedSquare(PurchasableSquare purchasable){
    this.ownerSquares.add(purchasable);
}
}
