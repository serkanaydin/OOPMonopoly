import java.util.ArrayList;
import java.util.Iterator;

public class MonopolyGame {
    private int cycleCount;
    private Die[] die;
    private ArrayList <Player> player;
    Board board;
public MonopolyGame(String args[]){
    Board board = new Board();
    board.createBoard();
    this.board=board;
    createDies();
    createPlayers(args);

}    

  public void play(){
while(!checkGameEnd() &&cycleCount<1000){
    Iterator itr = this.player.iterator();
    while (itr.hasNext()){
        Player person= (Player) itr.next();
        person.incrementTurnCounter();
        person.playerTurn(this.board,this);

    }

    this.cycleCount++; //??
}

  }

 private void createPlayers( String args[]){
     ArrayList <Player> player = new ArrayList<>(args.length);
     for(int i=0;i<args.length;i++){
         player.add(new Player(args[i],this.die));
     player.get(i).setSquare(board.getSquare()[0]);}
     this.player=player;
 }
  private void createDies(){
    Die die[] = new Die[2];
    die[0]= new Die();
    die[1]= new Die();
    this.die=die;
  }
  public boolean checkGameEnd(){
      Iterator itr = this.player.iterator();
      int i=0;
    while (itr.hasNext()){
       Player person= (Player) itr.next();
        if(person.getAccount()>=0)
            i++;
    }
    if(i>=2)
        return false;
    return true;
  }

    public int getCycleCount() {
        return cycleCount;
    }

}
