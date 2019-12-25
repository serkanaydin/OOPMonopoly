public class ChanceSquare extends Square {
    @Override
    public void landedOn(Player player) {
        int random = (int) (Math.random() *3);
        if(player.getBoard().getCard()[random].getFunction().equals("JailCard")){
            player.getPiece().setSquare(player.getBoard().getJail());
            System.out.println("Player sent to jail");
        }
        else if(player.getBoard().getCard()[random].getFunction().equals("BonusCard")) {
            player.setAccount(player.getAccount() + 200);
            System.out.println("Player got 200$");
        }
        else if(player.getBoard().getCard()[random].getFunction().equals("HaraçCard")){
            player.setAccount(player.getAccount()-200);
        System.out.println("Player lost 200$");}
            printSquareInfo();
    }
    @Override
    public void printSquareInfo() {
        String output=" Square type :  Chance Square" + "Square name : " +this.getName() + " Square index : "+ this.getIndex();
        System.out.println(output);
    }
}
