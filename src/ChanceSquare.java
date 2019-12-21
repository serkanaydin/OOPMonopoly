public class ChanceSquare extends Square {
    @Override
    public void landedOn(Player player) {
        int random = (int) (Math.random() * 9 + 1);
        if (random < 3) {

    player.getPiece().setSquare(player.getBoard().getJail());
    System.out.println("Player sent to jail");
        }
        else if(random <6) {
            player.setAccount(player.getAccount() + 200);
            System.out.println("Player got 200$");
        }
        else
            player.setAccount(player.getAccount()-200);
        System.out.println("Player lost 200$");
    }

    @Override
    public void printSquareInfo() {
        String output=" Square type :  Chance Square" + "Square name : " +this.getName();
        System.out.println(output);
    }
}
