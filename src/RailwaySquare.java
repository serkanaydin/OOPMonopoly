public class RailwaySquare extends PurchasableSquare {

    RailwaySquare(int price) {
        super(price);
    }

    @Override
    public void landedOn(Player player) {
        tryPurchase(player,this);
    }

    @Override
    public void payFee(Player player) {
        player.setAccount(player.getAccount()-75);
    }


    @Override
    public void printSquareInfo() {
        String output=" Square type :  Railway Square" + "Square name : " +this.getName();
        if(this.getOwner()!=null)
            output+= " Owner : " + this.getOwner();

        System.out.println(output);
    }
}
