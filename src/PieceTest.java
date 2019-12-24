import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @org.junit.jupiter.api.Test
    void testPiece(){
        Square testSqaure1 = new RegularSquare();
        Square testSqaure = new RegularSquare();
        Piece piece = new Piece(testSqaure);
        assertEquals(testSqaure,piece.getSquare());
        assertNotEquals(testSqaure1,piece.getSquare());
    }

}