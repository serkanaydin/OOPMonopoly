import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

try{
    File file = new File("./src/input.txt");
    Scanner sc = new Scanner(file);
    String input =sc.nextLine();
    String[] split = input.split(" ");
    int totalPlayer
            = Integer.parseInt(split[0]);

    if(totalPlayer <2 || totalPlayer>8){
        System.out.println("Total player number must be between 2 and 8");
        System.exit(1);
    }
    String[] users =new String[totalPlayer];
for(int i=1;i<totalPlayer+1;i++){
   users[i-1]=split[i];

}

int taxSquareNumber = Integer.parseInt(split[totalPlayer+1]);
    int taxAmount = Integer.parseInt(split[totalPlayer+2]);


    MonopolyGame monopolyGame = new MonopolyGame(users,taxSquareNumber,taxAmount);
    monopolyGame.play();

}
catch(FileNotFoundException ex){
System.out.println("File not found");
System.exit(1);
}
catch(NumberFormatException ex){
System.out.println("False input");

}
catch(NullPointerException ex){
    ex.printStackTrace();
}



    }
}
