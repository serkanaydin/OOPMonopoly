class Board {
    private Card[] card;
    private Square[] square;
    private String [] purchasableSquareNames;
    Board(int taxSquareNumber, int taxAmount, int jailSquareAmount, int goSquarePlus, int constructable,int constructablePrice,
          int railway,        int railwayPrice, String[] purhasable,Card[] card){
        this.card=card;
        this.purchasableSquareNames=purhasable;
        arrangeGoSquare(goSquarePlus);
        arrangeTaxSquares(taxSquareNumber,taxAmount);
        arrangeJailSquares(jailSquareAmount);
        arrangeChanceSquares(2);
        arrangeConstructableSquares(constructable,constructablePrice);
        arrangeRailwaySquares(railway,railwayPrice);
        arrangeRegularSquares();
    }
    public Card[] getCard() { return this.card; }
private void arrangeRegularSquares(){
        int k=0;
        for(int i=0;i<40;i++){
            if(this.square[i]==null){

                this.square[i]=new RegularSquare();
                this.square[i].setIndex(i);
                this.square[i].setName("RegularSquare"+k);
                k++;
            }
        }
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
    Square[] getSquareArray() { return this.square; }
    private void arrangeConstructableSquares(int constructable, int constructablePrice){
        if(constructable!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }
            this.square[index]= new ConstrucableSquare(constructablePrice);
            ((ConstrucableSquare)(this.square[index])).setHotel(false);
            ((ConstrucableSquare)(this.square[index])).setHouseCount(0);

            this.square[index].setIndex(index);
            arrangeConstructableSquares(constructable-1,constructablePrice);
        }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof ConstrucableSquare) {
                    value.setName("ConstructableSquare" + k);
                    k++;
                }
            }
        }}
        private void arrangeRailwaySquares(int railway,int railwayPrice){
            if(railway!=0){
                int index = (int)(Math.random()*40);

                while(square[index]!=null){
                    index = (int)(Math.random()*40);
                }
                this.square[index]= new RailwaySquare(railwayPrice);

                this.square[index].setIndex(index);
                arrangeConstructableSquares(railway-1,railwayPrice);
            }
        else{
            int k=0;
            for (Square value : this.square) {
                if (value instanceof RailwaySquare) {
                    value.setName("RailwaySquare" + k);
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
    public Square getSquare(Piece piece, int sumDices){ return this.square[(piece.getSquare().getIndex()+sumDices)%40];
    }
}
