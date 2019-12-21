class Board {
    private Square[] square;
    private String [] purchasableSquareNames;
    Board(int taxSquareNumber, int taxAmount, int jailSquareAmount, int goSquarePlus, int purchasablePrice, String[] purhasable){
        this.purchasableSquareNames=purhasable;
        arrangeGoSquare(goSquarePlus);
        arrangeTaxSquares(taxSquareNumber,taxAmount);
        arrangeJailSquares(jailSquareAmount);
        arrangeChanceSquares(2);
        arrangePurchasableSquares(purhasable.length,purchasablePrice);

    }

private void arrangeChanceSquares(int chanceSquaresAmount){
        if(chanceSquaresAmount!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }
            this.square[index]= new ChanceSquare();

            this.square[index].setIndex(index);
            arrangeChanceSquares(chanceSquaresAmount-1);
        }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof ChanceSquare) {
                    value.setName("ChanceSquare" + k);
                    k++;
                }
            }
        }
}
    Square[] getSquareArray() {
        return this.square;
    }
    private void arrangePurchasableSquares(int purchasableNumber, int purchasablePrice){
        if(purchasableNumber!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }
            this.square[index]= new PurchasableSquare(purchasablePrice);

            this.square[index].setIndex(index);
            arrangePurchasableSquares(purchasableNumber-1,purchasablePrice);
        }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof PurchasableSquare) {
                    value.setName("PurchasableSquare" + k);
                    k++;
                }
            }
        }
    }
    private void arrangeGoSquare(int goSquarePlus){
        Square[] square = new Square[40];

        square[0]= new GoSquare(goSquarePlus);
        square[0].setIndex(0);
        square[0].setName("Go Square");

        this.square=square;

    }
    private void arrangeTaxSquares(int taxSquaresNumber, int tax){
        if(taxSquaresNumber!=0){
            int squareIndex = (int)(Math.random()*40);
            while(square[squareIndex]!=null)
                squareIndex = (int)(Math.random()*40);
            this.square[squareIndex]=new IncomeTaxSquare(tax);
            this.square[squareIndex].setIndex(squareIndex);
            arrangeTaxSquares(taxSquaresNumber-1,tax);
        }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof IncomeTaxSquare) {
                    value.setName("TaxSqaure" + k);
                    k++;
                }
            }
        }
    }
    private void arrangeJailSquares(int jailSquaresNumber){
        if(jailSquaresNumber!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }

            this.square[index]= new GoToJailSquare();
            this.square[index].setIndex(index);

            arrangeJailSquares(jailSquaresNumber-1);
        }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof GoToJailSquare) {
                    value.setName("GoToJailSquare" + k);
                    k++;
                }
            }
        }
    }
    public Square getJail(){
        for (int i=0;i<this.square.length;i++){
            if(this.square[i] instanceof GoToJailSquare)
                return this.square[i];
        }
        return null;
    }
    public Square getSquare(Piece piece, int sumDices){
        return this.square[(piece.getSquare().getIndex()+sumDices)%40];
    }

}
