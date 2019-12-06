class Die {
   private int value;

 int toss(){
    this.value=(int)(Math.random()*6)+1;
    return this.value;
 }
}
