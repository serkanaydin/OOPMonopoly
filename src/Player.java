import java.util.ArrayList;

public class Player {
    private int account;
    private int turnCounter;
    Board board;
    private Piece piece;
    private String name;
    private Die[] die;
    private ArrayList<PurchasableSquare> ownerSquares;


Player(String name,Die[] die,int balance,Board board){
    this.board=board;
    this.ownerSquares = new ArrayList<PurchasableSquare>();
    this.turnCounter=0;
    this.name=name;
    this.die=die;
    this.account=balance;
}

    public Board getBoard() { return this.board; }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    private void incrementTurnCounter(){
    this.turnCounter++;
    }
    void playerTurn(MonopolyGame mgame){
    printPlayerInfo(mgame);
    this.piece.getSquare().printSquareInfo();
   int diceSums=0;
   int dice1=0;
   int dice2=0;
    if(this.getAccount()>0){
        this.getDie()[0].toss();
        dice1= this.getDie()[0].getFV();
        this.getDie()[1].toss();
        dice2= this.getDie()[1].getFV();
        diceSums= dice1+dice2;
       this.incrementTurnCounter();
    }
    if(diceSums>=1){
      String output="Turn player : "+ this.name +" Dice 1 face value : " + dice1 + " Dice 2 face value : " + dice2 + " Total value : " + diceSums;
        System.out.println(output);
    if(!(this.piece.getSquare() instanceof GoToJailSquare ) || dice1==dice2) setLocation(diceSums); }
    this.piece.getSquare().landedOn(this);
    printPlayerInfo(mgame);
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
    public void setLocation(int diceSums){
        this.getPiece().setSquare(board.getSquare(this.piece,diceSums));
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
