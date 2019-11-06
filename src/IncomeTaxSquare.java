public class IncomeTaxSquare extends Square {
    int tax;
    private int index;
    private String name;
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


}
