import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int totalPlayer = 0 ;

        try{
            totalPlayer = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException ex) {
            System.out.println("False input format");
        }
        if((totalPlayer < 2 || totalPlayer > 8) && totalPlayer!= (args.length - 4)){
            System.out.println("Total player number must be between 2 and 8");
        }
        System.out.println("Please enter your input again.Number of player will be in range 2 - 8");
        Scanner input = new Scanner(System.in);
        while((totalPlayer < 2 || totalPlayer > 8) || totalPlayer!= (args.length - 4)){
            totalPlayer = input.nextInt();
            System.out.println("You have " + (args.length - 4) + " players.Please enter " + (args.length - 4) + " to play.");
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


    public static void  print(String output){

        System.out.println(output);
    }
}

