public class RailwaySquare extends PurchasableSquare {
    RailwaySquare(int price) { super(price); }
    @Override
    public void landedOn(Player player) { tryPurchase(player,this); printSquareInfo(); }
    @Override
    public void payFee(Player player) {
        player.setAccount(player.getAccount()-75);
    }
    @Override
    public void printSquareInfo() {
        String output=" Square type :  Railway Square" + "Square name : "+this.getName()+ " Square index : "+ this.getIndex()+ " Square owner : " + (this.getOwner()==null? " null " :this.getOwner().getName());
        System.out.println(output);
    }
}
