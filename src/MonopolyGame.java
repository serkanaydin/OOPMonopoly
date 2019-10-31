import java.util.ArrayList;

public class MonopolyGame {
    private Die[] die;
    private ArrayList <Player> player;
    private Square square[];
 
public MonopolyGame(String args[]){
    startGame(args);
}    
   private void startGame(String args[]){
    createPlayers(args);
createSquares();
createDies();
startGame();

   }
  private void startGame(){

  }
   private void createSquares(){
    Square square[] = new Square[40];

      for (int i=0;i<square.length;i++){
          square[i] = new Square();
          square[i].setNumber(i);
      }
       this.square=square;
    
   }
 private void createPlayers(String args[]){
     Player systemPlayer = new Player("System Player" );

 }
  private void createDies(){
    Die die[] = new Die[2];
    die[0]= new Die();
    die [1]= new Die();
  }
}
