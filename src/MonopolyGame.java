import java.util.ArrayList;
import java.util.Iterator;
class MonopolyGame {
    private Card[] card;
    private int cycleCount;
    private Die[] die;
    private ArrayList <Player> player;
    private Board board;
MonopolyGame(String[] args, int taxSquareNumber, int taxAmount, int jailAmount,
             int goSquarePlus, int constructable,int constructablePrice,
             int railway,int railwayPrice, String[] purchasable){
    createCards();
    this.board= new Board(taxSquareNumber,taxAmount,jailAmount,goSquarePlus, constructable,constructablePrice,railway,railwayPrice,purchasable,this.card);
    createDies();
    createPlayers(args);
}
  void play(){
do{
    Iterator itr = this.player.iterator();
    while (itr.hasNext()){
        Player person= (Player) itr.next();
        if(person.getAccount()>0) {
            person.playerTurn(this);
        }
    }
    System.out.println("\nCycle end informations\n----------------------------------------");
    itr = this.player.iterator();
    this.cycleCount++;
    while (itr.hasNext()){
        Player person= (Player) itr.next();
        person.printPlayerInfo(this);
    }
    System.out.println("----------------------------------------");
}while(!checkGameEnd());
for(Player person:this.player){
    if(person.getAccount()>0)
        System.out.println("Player : " + person.getName() + " won the game");
}
  }
  private void createCards(){
    Card[] card = new Card[3];
    card[0]= new Card("JailCard");
    card[1]=new Card("BonusCard");
    card[2]= new Card("HaraçCard");
    this.card=card;
  }
 private void createPlayers(String[] args){
     ArrayList <Player> player = new ArrayList<>(args.length);
     for(int i=0;i<args.length-1;i++){
         player.add(new Player(args[i],this.die,Integer.parseInt(args[args.length-1]),this.board));
         player.get(i).setPiece(new Piece(board.getSquareArray()[0]));
    }
     this.player=player;
 }
  private void createDies(){
    Die[] die = new Die[2];
    die[0]= new Die();
    die[1]= new Die();
    this.die=die;
  }
  private boolean checkGameEnd(){
      Iterator itr = this.player.iterator();
      int i=0;
    while (itr.hasNext()){
       Player person= (Player) itr.next();
        if(person.getAccount()>0)
            i++;
    }
    return (i<2);
  }
    int getCycleCount() {
        return this.cycleCount;
    }
}
