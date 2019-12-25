public class GoSquare extends Square{
  private int amount;
  GoSquare(int amount){
      this.amount=amount;
  }
    public void landedOn(Player player){
      player.setAccount(player.getAccount()+this.amount);
      printSquareInfo();
    }
    public void printSquareInfo(){
        String output=" Square type :  Go Square " + "Square name : " +this.getName();
        System.out.println(output);
    }

    public int getAmount() { return this.amount; }
}
