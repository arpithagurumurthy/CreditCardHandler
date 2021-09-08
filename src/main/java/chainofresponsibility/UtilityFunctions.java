package chainofresponsibility;

import template.*;

public class UtilityFunctions {
    // Utility class to store constants and helper methods

    public static final String AMEX_CARD_TYPE = "AmericanExpress";

    public static final String DISCOVER_CARD_TYPE = "Discover";

    public static final String Master_CARD_TYPE = "MasterCard";

    public static final String VISA_CARD_TYPE = "Visa";

    public static final String INVALID_CARD_TYPE = "invalid";

    public static String createValidator(String cardNumber) {
        CreditCardValidator amexCCValidator = new AmexCCValidator(cardNumber);
        CreditCardValidator discoverCCValidator = new DiscoverCCValidator(cardNumber);
        CreditCardValidator masterCCValidator = new MasterCCValidator(cardNumber);
        CreditCardValidator visaCCValidator = new VisaCCValidator(cardNumber);
        String cardType = null;
        if (amexCCValidator.validateCreditCard())
            cardType = UtilityFunctions.AMEX_CARD_TYPE;
        else if (discoverCCValidator.validateCreditCard())
            cardType = UtilityFunctions.DISCOVER_CARD_TYPE;
        else if (masterCCValidator.validateCreditCard())
            cardType = UtilityFunctions.Master_CARD_TYPE;
        else if (visaCCValidator.validateCreditCard())
            cardType = UtilityFunctions.VISA_CARD_TYPE;
        else
            cardType = UtilityFunctions.INVALID_CARD_TYPE;

        return cardType;
    }
}
