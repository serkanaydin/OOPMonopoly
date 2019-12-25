public class ConstrucableSquare extends PurchasableSquare{
    private boolean hotel;
    private int houseCount;
    private int fee;
    ConstrucableSquare(int price) { super(price); }
    public void setHotel(boolean hotel) { this.hotel = hotel; }
    public void setHouseCount(int houseCount) { this.houseCount = houseCount; }
    @Override
    public void landedOn(Player player) {
        tryPurchase(player,this);
    if(this.getOwner()==player){
      if(this.houseCount<=3){
        int acceptBuild = (int)(Math.random()*4+1);
        if(acceptBuild<=2)
        {
            if(player.getAccount()>=200){
                this.houseCount++;
                player.setAccount(player.getAccount()-100);
            }
        }
    }
      else{
        int acceptBuild = (int)(Math.random()*4+1);
        if(acceptBuild<=2) {
            if(player.getAccount()>=300){
                this.hotel=true;
                player.setAccount(player.getAccount()-200);
            }
        }
      }
    }
        calculateFee();
        printSquareInfo();
    }
    private void calculateFee(){
        if(!this.hotel)
            this.fee = 50+this.houseCount*75;
        else
            this.fee=50+400;
    }
    @Override
    public void payFee(Player player) { player.setAccount(player.getAccount()-this.fee);
    }
    @Override
    public void printSquareInfo() {
        String output=" Square type :  Constructable square " + " Square name : " +this.getName() +" Square index : "+ this.getIndex() + " Square owner : " + (this.getOwner()==null? " null " :this.getOwner().getName());
        output+= this.hotel?" Building type : Hotel ":" Building type : House; House count : " + this.houseCount;
        System.out.println(output);
    }
}
