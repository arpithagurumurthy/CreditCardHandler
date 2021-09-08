package template;

public class VisaCCValidator extends CreditCardValidator {

    public VisaCCValidator(String creditCardNumber) {
        super(creditCardNumber);
    }

    @Override
    public boolean validateFirstFewDigits() {
        if(creditCardNumber.charAt(0) == '4'){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateLength() {
        if(creditCardNumber.length() == 13 || creditCardNumber.length() == 16){
            return true;
        }
        return false;
    }
}
