public class Board {
    private Square[] square;
    public Board(int taxSquareNumber,int taxAmount,int jailSquareAmount,int goSquarePlus,int purchasableNumber,int purchasablePrice){
        arrangeGoSquare(goSquarePlus);
        arrangeTaxSquares(taxSquareNumber,taxAmount);
        arrangeJailSquares(jailSquareAmount);
        arrangePurchasableSquares(purchasableNumber,purchasablePrice);
        arrangeRegularSquares();
    }
    protected String [] purchasableSquareNames = {"Besiktas", "Kadikoy", "Sariyer", "Bebek", "Gokturk", "Atasehir", "Zekeriyakoy", "Acibadem", "Kurucesme", "Bostanci", "Beylikduzu", "Bahcesehir", "Osmanbey", "Gayrettepe", "Atakoy", "Caddebostan", "Uskudar", "Beylerbeyi", "Cihangir", "Sisli", "Istinye", "Beykoz", "Baltalimani", "Emirgan", "Eminonu", "Tarabya", "Kanlıca", "Balat", "Yenikoy", "Kartal", "Zeytinburnu", "Unkapanı", "Mahmutbey", "Cubuklu", "Eyup", "Avcılar", "Sefakoy", "Mecidiyekoy", "Kasımpasa", "RumeliHisari"};


    public Square[] getSquare() {
        return this.square;
    }
    public void arrangePurchasableSquares(int purchasableNumber,int purchasablePrice){
        if(purchasableNumber!=0){
            int index = (int)(Math.random()*40);

            while(square[index]!=null){
                index = (int)(Math.random()*40);
            }
            this.square[index]= new PurchasableSquare(purchasablePrice);
            this.square[index].setName(purchasableSquareNames[index]);
            this.square[index].setIndex(index);
            arrangeJailSquares(purchasableNumber-1);
        }
    }
    public void arrangeGoSquare(int goSquarePlus){
        Square square[] = new Square[40];

        square[0]= new GoSquare(goSquarePlus);
        square[0].setIndex(0);
        square[0].setName("Go Square");

        this.square=square;

    }
    public void arrangeTaxSquares(int taxSquaresNumber,int tax){
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
    public void arrangeJailSquares(int jailSquaresNumber){
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
    public void arrangeRegularSquares(){
        int k=0;
        for(int i=0 ;i<this.square.length;i++){
            if(square[i]==null){
                square[i] = new PurchasableSquare(100);
                square[i].setIndex(i);
                square[i].setName(purchasableSquareNames[k]);
                k++;
            }
        }
    }
}
