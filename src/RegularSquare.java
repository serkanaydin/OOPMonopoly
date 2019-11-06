public class RegularSquare extends Square{
    private int index;
    private String name;

    RegularSquare(int index,String name){
        this.index=index;
        this.name=name;
    }
    public int getIndex() {
        return this.index;
    }
    public  String getMessage(){
        return this.name;
    };


    public String getName() {
        return this.name;
    }


}
