package template;

public abstract class CreditCardValidator {
    // template method
    String creditCardNumber;

    public CreditCardValidator(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public final boolean validateCreditCard() {
        boolean areDigitsValid = validateFirstFewDigits();
        if (areDigitsValid)
            return validateLength();
        return false;
    }

    public abstract boolean validateFirstFewDigits();

    public abstract boolean validateLength();
}
