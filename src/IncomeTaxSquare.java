public class IncomeTaxSquare extends Square {
    int tax;
    private int index;
    private String name;
    private String message;
    IncomeTaxSquare(int index,String name,int tax){
        this.tax=tax;
        this.index=index;
        this.name=name;
    }
    public int getIndex() {
        return this.index;
    }

    public int getTax() {
        return this.tax;
    }


    public String getName() {
        return name;
    }

    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
