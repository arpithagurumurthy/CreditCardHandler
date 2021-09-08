package template;

public class RetrieveCardType {
    String creditCardNumber;
    String cardType = null;

    public RetrieveCardType(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        CreditCardValidator cardValidator = new MasterCCValidator(creditCardNumber);
        if (cardValidator.validateCreditCard()) {
            cardType = "master";
            return cardType;
        }
        cardValidator = new VisaCCValidator(creditCardNumber);
        if (cardValidator.validateCreditCard()) {
            cardType = "visa";
            return cardType;
        }
        cardValidator = new AmexCCValidator(creditCardNumber);
        if (cardValidator.validateCreditCard()) {
            cardType = "amex";
            return cardType;
        }
        cardValidator = new DiscoverCCValidator(creditCardNumber);
        if (cardValidator.validateCreditCard()) {
            cardType = "discover";
            return cardType;
        }
        return cardType;
    }
}
