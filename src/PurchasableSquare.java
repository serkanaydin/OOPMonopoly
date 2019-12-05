public class PurchasableSquare extends Square {
    private Player owner;
    private int price;

 PurchasableSquare(int price){
        this.price=price;
    }
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


        if(acceptedBuy && p.getAccount()>this.price && this.owner==null)
            completePurchase(p);
        else {
            System.out.println("The building was not bought");
            if(p.getAccount()>this.price &&acceptedBuy )
                System.out.println("Player doesn't have enough money");
            else if(!acceptedBuy)
                System.out.println("Player didn't accepted buy");
            else if(this.owner!=null)
            System.out.println("This building's owner is " + this.owner.getName());

        }

    }
   private void completePurchase(Player p){
        p.setAccount(p.getAccount()-this.price);
        setOwner(p);
        p.addOwnedSquare(this);
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

    public void setPrice(int price) {
        this.price = price;
    }
}
