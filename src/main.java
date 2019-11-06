import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

try{
    int totalPlayer = Integer.parseInt(args[0]);
    if(totalPlayer <2 || totalPlayer>8){
        System.out.println("Total player number must be between 2 and 8");
        System.exit(1);
    }
    String[] users =new String[totalPlayer+1];
for(int i=1;i<totalPlayer+2;i++){
   users[i-1]=args[i];
}
int taxSquareNumber = Integer.parseInt(args[totalPlayer+2]);
    int taxAmount = Integer.parseInt(args[totalPlayer+3]);
    MonopolyGame monopolyGame = new MonopolyGame(users,taxSquareNumber,taxAmount);
    monopolyGame.play();
}
catch(NumberFormatException ex){
System.out.println("False input");
}
catch(NullPointerException ex){
    ex.printStackTrace();
}
    }
    public static void  print(String output){
        System.out.println(output);
    }
}
