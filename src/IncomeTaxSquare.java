public class IncomeTaxSquare extends Square {
    private int tax;

    IncomeTaxSquare(int tax){
        this.tax=tax;
    }

    public int getTax() {
        return this.tax;
    }
    public void landedOn(Player player){

        player.setAccount(player.getAccount()-this.getTax());
        printSquareInfo();

    }
public void printSquareInfo(){
   String output=" Square type :  Tax square Square name : "+this.getName()+ " Tax amount " + this.tax;
    System.out.println(output);

}

}
