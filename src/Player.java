public class Player {
    private int account;
    private Square square;
    private String name;
private Die[] die;
Player(String name,Die[] die){
    this.name=name;
    this.die=die;
    this.account=500;

}
    public int getAccount() {
        return this.account;
    }

    public String getName() {
        return name;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    public Square getSquare() {
        return square;
    }

    public boolean lostControl(){
    if(this.account<=0)
        return true;
return false;
}

    public void setSquare(Square square) {
        this.square = square;
    }

    public Die[] getDie() {
        return die;
    }
}
