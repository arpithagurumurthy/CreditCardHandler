package template;

public class AmexCCValidator extends CreditCardValidator {

    public AmexCCValidator(String creditCardNumber) {
        super(creditCardNumber);
    }

    @Override
    public boolean validateFirstFewDigits() {
        if(creditCardNumber.charAt(0) == '3'){
            if(creditCardNumber.charAt(1) == '4' ||  creditCardNumber.charAt(1) == '7'){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateLength() {
        if(creditCardNumber.length() == 15){
            return true;
        }
        return false;
    }
}
