import static org.junit.jupiter.api.Assertions.*;

class GoSquareTest {
    @org.junit.jupiter.api.Test
void goSquareTest(){
    GoSquare goSquare = new GoSquare(200);
    goSquare.setName("GoSquare");
    assertEquals(200,goSquare.getAmount());
    assertEquals(0,goSquare.getIndex());
   assertTrue("GoSquare".equals(goSquare.getName()));

}
}