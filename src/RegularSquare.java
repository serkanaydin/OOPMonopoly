public class RegularSquare extends Square{

    RegularSquare(){

    }
    public void landedOn(Player player) {
printSquareInfo();    }
    public void printSquareInfo(){
        String output=" Square type :  Regular Square Square name : " +this.getName();
        System.out.println(output);

    }
}
