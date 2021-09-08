package template;

public class MasterCCValidator extends CreditCardValidator {

    public MasterCCValidator(String creditCardNumber) {
        super(creditCardNumber);
    }

    @Override
    public boolean validateFirstFewDigits() {
        if(creditCardNumber.charAt(0) == '5'){
            if(creditCardNumber.charAt(1) >= '1' &&  creditCardNumber.charAt(1) <= '5'){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateLength() {
        if(creditCardNumber.length() == 16){
            return true;
        }
        return false;
    }
}
