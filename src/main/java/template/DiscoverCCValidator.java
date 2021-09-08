package template;

public class DiscoverCCValidator extends CreditCardValidator {
    public DiscoverCCValidator(String creditCardNumber) {
        super(creditCardNumber);
    }

    @Override
    public boolean validateFirstFewDigits() {
        String subCreditCard = creditCardNumber.substring(0,4);
        if(subCreditCard.equals("6011")){
            return true;
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
