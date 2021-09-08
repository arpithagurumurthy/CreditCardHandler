import chainofresponsibility.UtilityFunctions;
import org.junit.Test;
import template.AmexCCValidator;
import template.CreditCardValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InvalidCreditCardTest {
    private static String invalidInputFilePathJSON = "src/test/resources/invalidcc.json";
    private static String invalidInputFilePathCSV = "src/test/resources/invalidcc.csv";
    private static String invalidInputFilePathXML = "src/test/resources/invalidcc.xml";

    //Testing JSON parser and invalid card type
    @Test
    public void testInvalidCC_JSON() {
        String invalidCCNumber = UtilityParsers.jsonHelper(invalidInputFilePathJSON);
        String cardType = UtilityFunctions.createValidator(invalidCCNumber);
        assertEquals(UtilityFunctions.INVALID_CARD_TYPE,cardType);
    }

    //Testing CSV parser and invalid card type
    @Test
    public void testInvalidCC_CSV() {
        String invalidCCNumber = UtilityParsers.csvHelper(invalidInputFilePathCSV);
        String cardType = UtilityFunctions.createValidator(invalidCCNumber);
        assertEquals(UtilityFunctions.INVALID_CARD_TYPE,cardType);
    }

    //Testing XML parser and invalid card type
    @Test
    public void testInvalidCC_XML() {
        String invalidCCNumber = UtilityParsers.xmlHelper(invalidInputFilePathXML);
        String cardType = UtilityFunctions.createValidator(invalidCCNumber);
        assertEquals(UtilityFunctions.INVALID_CARD_TYPE,cardType);
    }
}
