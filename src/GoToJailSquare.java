public class GoToJailSquare extends Square {

    GoToJailSquare(){

    }
    public void landedOn(Player player){
        printSquareInfo();

    }
    public void printSquareInfo(){
        String output=" Square type : Jail Square Square name : " + this.getName() + " player was gone to jail";
        System.out.println(output);

    }
}
