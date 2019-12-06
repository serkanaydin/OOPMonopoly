public abstract class
Square {
   private int index;
    private String name;
    Square (){ }
    public int getIndex(){
        return this.index;
    }
    public void setName(String name) {
        this.name = name;
    }
    public  String getName(){
        return this.name;
    }
    public void setIndex(int index){
        this.index=index;
    }
    public abstract void landedOn(Player player);
    public abstract void printSquareInfo();
}

