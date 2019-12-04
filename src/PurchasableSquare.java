public class PurchasableSquare extends Square {
    private Player owner;
    private int price;
    @Override
    public void landedOn(Player player) {
        printSquareInfo();
        tryPurchase(player);
    }

    @Override
    public void printSquareInfo() {
        String output=" Square type :  Purchasable Square " + "Square name : " +this.getName();
        System.out.println(output);
    }
    private void tryPurchase(Player p){
        int random = (int)(Math.random()*9+1);
        boolean acceptedBuy=false;
        if(random>5)
            acceptedBuy=true;

        if(acceptedBuy && p.getAccount()>this.price && this.owner!=null)
            completePurchase(p);
        else System.out.println("The square was not bought");

    }
   private void completePurchase(Player p){
        p.setAccount(p.getAccount()-this.price);
        setOwner(p);
   }
   public Player getOwner(){
        return this.owner;
   }

    @Override
    public int getIndex() {
        return super.getIndex();
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
