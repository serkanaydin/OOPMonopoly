public class Player {
    private int account;
    private Square square;
    private String name;

Player(String name){
    this.account=0;

}
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
    public void setName(String name){
        this.name=name;
    }

    public Square getSquare() {
        return square;
    }
}
