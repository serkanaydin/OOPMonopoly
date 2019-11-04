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
    public void arrangeTaxSquares(int taxSquaresNumber,int tax){
        if(taxSquaresNumber!=0){
            int squareIndex = (int)(Math.random()*40);
            this.square[squareIndex].setMessage("Tax square");
            this.square[squareIndex].setTax(tax);
            arrangeTaxSquares(taxSquaresNumber-1,tax);
        }
    }
}
