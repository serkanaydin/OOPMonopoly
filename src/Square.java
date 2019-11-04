public class Square {
    private int index;
    private String name;
    private String message;
private Player owner;
Square(int index,String name){
    this.index=index;
    this.name=name;
}
    public int getIndex() {
        return index;
    }



    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

