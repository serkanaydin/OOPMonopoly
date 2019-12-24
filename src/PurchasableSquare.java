public abstract class PurchasableSquare extends Square {
    private Player owner;
    private int price;

    PurchasableSquare(int price){
        this.price=price;
    }
    public abstract void payFee(Player player);
    void tryPurchase(Player p,PurchasableSquare s){
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
               s.payFee(p);
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
     Player getOwner(){
        return this.owner;
    }
    @Override
    public int getIndex() {
        return super.getIndex();
    }
     void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
}
