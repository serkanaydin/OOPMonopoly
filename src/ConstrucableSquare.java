public class ConstrucableSquare extends PurchasableSquare{
    private boolean hotel;
    private int houseCount;

    ConstrucableSquare(int price) {
        super(price);
    }

    public boolean isHotel() {
        return this.hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public int getHouseCount() {
        return this.houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

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
        if(acceptBuild<=2)
        {
            if(player.getAccount()>=300){
                this.hotel=true;
                player.setAccount(player.getAccount()-200);
            }

        }
    }
}
    }

    @Override
    public void payFee(Player player) {
        int fee;
        if(!this.hotel)
      fee = 50+this.houseCount*75;
        else
            fee=50+400;
        player.setAccount(player.getAccount()-fee);
    }

    @Override
    public void printSquareInfo() {
        String output=" Square type :  Constructable square" + "Square name : " +this.getName();
        System.out.println(output);
    }
}
