public class IncomeTaxSquare extends Square {
    private int tax;

    IncomeTaxSquare(int tax){
        this.tax=tax;
    }
    public void landedOn(Player player){
        player.setAccount(player.getAccount()-this.tax);
        printSquareInfo();
    }
public void printSquareInfo(){
   String output=" Square type :  Tax square Square name : "+this.getName()+  " Square index : " + this.getIndex() + " Tax amount " + this.tax;
    System.out.println(output);
}
}
