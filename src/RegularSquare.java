public class RegularSquare extends Square {
    @Override
    public void landedOn(Player player) { printSquareInfo(); }
    @Override
    public void printSquareInfo() {
        String output=" Square type :  Regular Square " + " Square name : " +this.getName() +" Square index : "+ this.getIndex();
        System.out.println(output);
    }
}
