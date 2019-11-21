public class GoSquare extends Square{
    public void landedOn(Player play){
printSquareInfo();
    }
    public void printSquareInfo(){
        String output=" Square type :  Go Square " + "Square name : " +this.getName();
        System.out.println(output);
    }
}
