public class PurchasableSquare extends UtilitySquare {
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
        String output=" Square type :  Purchasable Square," + "Square name : " +this.getName() + " Square index : " + this.getIndex();
        System.out.println(output);
    }
    private void tryPurchase(Player p){
        int random = (int)(Math.random()*9+1);
        boolean acceptedBuy=false;
        if(random>5) {
            acceptedBuy = true;
        }
        if(this.owner!=null) {
            if(p.getName().equals(getOwner().getName())){
                System.out.println();
            }
            else {
                p.setAccount(p.getAccount() - 50);
                getOwner().setAccount(getOwner().getAccount() + 50);
                System.out.println("Square : " + this.getName() + " owned by " + getOwner().getName() + "." + p.getName() + " will give rental fee 50  " + getOwner().getName());
            }
        }
        if(acceptedBuy && (p.getAccount()>this.price) && (this.owner==null)) {
            completePurchase(p);
            System.out.println("Square : " +this.getName() + "  bought by " + p.getName());
        }
        else{ System.out.println("The square was not bought");}
    }
    private void completePurchase(Player p){
        p.setAccount(p.getAccount()-this.price);
        setOwner(p);
        p.addOwnedSquare(this);
    }
    private Player getOwner(){
        return this.owner;
    }
    @Override
    public int getIndex() {
        return super.getIndex();
    }
    private void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
}
