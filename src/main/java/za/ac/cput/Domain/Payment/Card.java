package za.ac.cput.Domain.Payment;

public class Card implements Transaction {

    private int cardNo;
    private int pin;

    public Card() {
    }

    private Card(Builder builder){
        this.cardNo = builder.cardNo;
        this.pin = builder.pin;
    }

    public int getCardNo() {
        return cardNo;
    }
    public int getPin() {
        return pin;
    }
    public static void CardValidation(){
    }
    public void GenerateBill(){
        return;
    }
    // method implemented from Transaction interface
    public double pay() {
        return 0;
    }

    public static class Builder{
        private int cardNo;
        private int pin;

        public Builder cardNumber(int cardNo){
            this.cardNo = cardNo;
            return this;
        }
        public Builder pin(int pin){
            this.pin = pin;
            return this;
        }
        public Card build() {
            return new Card(this);
        }
    }
}
