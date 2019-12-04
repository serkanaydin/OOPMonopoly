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
    printPlayerInfo(mgame,"");
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
       /* String output="Turn player : "+ this.name +" Dice 1 face value : " + dice1 + " Dice 2 face value : " + dice2 + " Total value : " + diceSums;
        main.print(output);*/
        printPlayerInfo(mgame,"\n");
if(!(this.square instanceof GoToJailSquare ) || dice1==dice2)
        this.setSquare(board.getSquare()[(this.getSquare().getIndex()+diceSums)%40]);
    }
    this.square.landedOn(this);
}
public void printPlayerInfo(MonopolyGame mgame,String n){
    String output="Player name : " +this.name  +" Player balance : "+
            this.account +" Player turn counter : " + this.turnCounter +
            " Cycle counter "+ mgame.getCycleCount() ;
    System.out.println(output);


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
