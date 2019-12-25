class Die {
    private int value;
    void toss() { this.value = (int) (Math.random() * 6) + 1; }
    int getFV() { return this.value; }
}