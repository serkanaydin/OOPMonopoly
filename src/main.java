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
            int purchasableNumber = ((Number)jsonObject.get("purchasableNumber")).intValue();
            String[] purchasable= new String[purchasableNumber ];
             ((JSONArray)jsonObject.get("purchasableSquares")).toArray(purchasable);
            int taxSquareNumber = ((Number) jsonObject.get("taxSquareNumber")).intValue();
            int taxAmount = ((Number) jsonObject.get("taxAmount")).intValue();
            int jailNumber = ((Number)jsonObject.get("jailNumber")).intValue();
            int goSquareAmount = ((Number)jsonObject.get("goSquareAmount")).intValue();

            int purchasablePrice = ((Number) jsonObject.get("purchasablePrice")).intValue();
            MonopolyGame monopolyGame = new MonopolyGame(users, taxSquareNumber, taxAmount, jailNumber, goSquareAmount,purchasablePrice,purchasable);
            monopolyGame.play();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    }