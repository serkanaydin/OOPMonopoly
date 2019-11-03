import java.util.ArrayList;
import java.util.Iterator;

public class MonopolyGame {
    private Die[] die;
    private ArrayList <Player> player;
    private Square[] square;
 
public MonopolyGame(String args[]){
    startGame(args);
}    
   private void startGame(String args[]){

createSquares();
       createDies();
       createPlayers(args);

playGame();

   }
  private void playGame(){
while(!checkGameEnd()){
    Iterator itr = this.player.iterator();
    while (itr.hasNext()){
        Player person= (Player) itr.next();
        int diceSums=1;
        if(person.getAccount()>0){
            diceSums=person.getDie()[0].toss()+person.getDie()[1].toss();
        }
      if(diceSums>=1){
          person.setSquare(square[(person.getSquare().getNumber()+diceSums)%40]);
      }
    }
}

  }
   private void createSquares(){
    Square square[] = new Square[40];

      for (int i=0;i<square.length;i++){
          square[i] = new Square();
          square[i].setNumber(i);
      }
       this.square=square;
    
   }
 private void createPlayers( String args[]){
     ArrayList <Player> player = new ArrayList<>(args.length);
     for(int i=0;i<args.length;i++){
         player.add(new Player(args[i],this.die));
     player.get(i).setSquare(square[0]);}
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
}
