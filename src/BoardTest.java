/*import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    void testBoard() {
        String[] str = {"Besiktas", "Kadikoy",
                "Sariyer", "Bebek", "Gokturk",
                "Atasehir", "Zekeriyakoy", "Acibadem",
                "Kurucesme", "Bostanci", "Beylikduzu",
                "Bahcesehir", "Osmanbey", "Gayrettepe",
                "Atakoy", "Caddebostan", "Uskudar",
                "Beylerbeyi", "Cihangir", "Sisli",
                "Istinye", "Beykoz", "Baltalimani",
                "Emirgan", "Eminonu", "Tarabya", "Kanlıca"
                , "Balat", "Yenikoy", "Kartal"};
        Card[] cards = new Card[3];

      Board board = new Board(4,200, 5,300,str,cards);
    int totalSquare =testPurchasable(board,500,str.length)+
    testGoSquare(board,300)+
    testIncomeTaxSquare(board,4,200)+
    testGoToJailSquare(board,5);
    assertEquals(40,totalSquare);
    }
    int testPurchasable(Board board,int price,int count){
        int boardCount=0;
        for(int i = 0; i<board.getSquareArray().length; i++){
            assertFalse(board.getSquareArray() == null);
            if(board.getSquareArray()[i] instanceof  PurchasableSquare){
                boardCount++;
                assertEquals(price,((PurchasableSquare)(board.getSquareArray()[i])).getPrice());

            }

        }
        assertEquals(count,boardCount);
        return boardCount;
    }
    int testGoSquare(Board board,int goSquarePlus){
        for(int i=0;i<board.getSquareArray().length;i++){
            assertFalse(board.getSquareArray() == null);
            if(board.getSquareArray()[i] instanceof  GoSquare){
              assertEquals(0,i);
                assertEquals(goSquarePlus,((GoSquare)(board.getSquareArray()[i])).getAmount());

            }

        }
        return 1;
    }
    int testIncomeTaxSquare(Board board,int count,int tax){
        int boardCount=0;
        for(int i = 0; i<board.getSquareArray().length; i++){
            assertFalse(board.getSquareArray() == null);
            if(board.getSquareArray()[i] instanceof  IncomeTaxSquare){
                boardCount++;
                assertEquals(tax,((IncomeTaxSquare)(board.getSquareArray()[i])).getTax());

            }

        }
        assertEquals(count,boardCount);
        return boardCount;
    }
    int testGoToJailSquare(Board board,int count){
        int boardCount=0;
        for(int i = 0; i<board.getSquareArray().length; i++){
            assertFalse(board.getSquareArray() == null);
            if(board.getSquareArray()[i] instanceof  GoToJailSquare){
                boardCount++;
            }

        }
        assertEquals(count,boardCount);
        return boardCount;
    }
}*/