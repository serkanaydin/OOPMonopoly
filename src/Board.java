public class Board {
    private Square[] square;

    public Square[] getSquare() {
        return square;
    }
    public void createBoard(){
        Square square[] = new Square[40];

        for (int i=0;i<square.length;i++){
            square[i] = new Square(i,"Square "+i);

        }
        this.square=square;

    }
}
