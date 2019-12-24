import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
public class main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(
                    "./src/input.json"));
            JSONObject jsonObject = (JSONObject) obj;
            int totalPlayer = ((Number) jsonObject.get("totalPlayer")).intValue();
            String[] users = new String[totalPlayer+1];
            JSONArray jsonArray = (JSONArray)jsonObject.get("user");
            jsonArray.toArray(users);


            int taxSquareNumber = ((Number) jsonObject.get("taxSquareNumber")).intValue();
            int taxAmount = ((Number) jsonObject.get("taxAmount")).intValue();
            int jailNumber = ((Number)jsonObject.get("jailNumber")).intValue();
            int goSquareAmount = ((Number)jsonObject.get("goSquareAmount")).intValue();

            int constructable=((Number)jsonObject.get("constructable")).intValue();
            int constructablePrice=((Number)jsonObject.get("constructablePrice")).intValue();
            int railway=((Number)jsonObject.get("railway")).intValue();
            int railwayPrice=((Number)jsonObject.get("railwayPrice")).intValue();
            String[] purchasable= new String[railway+constructable ];
            ((JSONArray)jsonObject.get("purchasableSquares")).toArray(purchasable);
            MonopolyGame monopolyGame = new MonopolyGame(users, taxSquareNumber, taxAmount, jailNumber, goSquareAmount,constructable,constructablePrice,railway,railwayPrice,purchasable);
            monopolyGame.play();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    }