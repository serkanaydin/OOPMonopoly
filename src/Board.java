class Board {
    private Square[] square;
    private String [] purchasableSquareNames;
    Board(int taxSquareNumber, int taxAmount, int jailSquareAmount, int goSquarePlus, int purchasablePrice, String[] purhasable){
        this.purchasableSquareNames=purhasable;
        arrangeGoSquare(goSquarePlus);
        arrangeTaxSquares(taxSquareNumber,taxAmount);
        arrangeJailSquares(jailSquareAmount);
        arrangePurchasableSquares(purhasable.length,purchasablePrice);
    }


    Square[] getSquare() {
        return this.square;
    }
    private void arrangePurchasableSquares(int purchasableNumber, int purchasablePrice){
        if(purchasableNumber!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }
            this.square[index]= new PurchasableSquare(purchasablePrice);
            this.square[index].setName(purchasableSquareNames[purchasableNumber-1]);
            this.square[index].setIndex(index);
            arrangePurchasableSquares(purchasableNumber-1,purchasablePrice);
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
            this.square[squareIndex].setName("Tax Square");
            this.square[squareIndex].setIndex(squareIndex);
            arrangeTaxSquares(taxSquaresNumber-1,tax);
        }
    }
    private void arrangeJailSquares(int jailSquaresNumber){
        if(jailSquaresNumber!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }

            this.square[index]= new GoToJailSquare();
            this.square[index].setName("JailSquare");
            this.square[index].setIndex(index);

            arrangeJailSquares(jailSquaresNumber-1);
        }
    }

}
