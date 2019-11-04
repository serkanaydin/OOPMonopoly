public class Square {
    int tax;
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

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
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

