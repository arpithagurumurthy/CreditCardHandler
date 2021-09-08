import org.junit.Test;
import template.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiscoverCreditCardTest {
    private static String discoverInputFilePathJSON = "src/test/resources/discovercc.json";
    private static String discoverInputFilePathCSV = "src/test/resources/discovercc.csv";
    private static String discoverInputFilePathXML = "src/test/resources/discovercc.xml";
    //Testing JSON parser and card type
    @Test
    public void testDiscoverCCPositive_JSON() {
        String discoverCCNumber = UtilityParsers.jsonHelper(discoverInputFilePathJSON);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(discoverCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_1_JSON() {
        String discoverCCNumber = UtilityParsers.jsonHelper(discoverInputFilePathJSON);
        CreditCardValidator creditCardValidator = new MasterCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_2_JSON() {
        String discoverCCNumber = UtilityParsers.jsonHelper(discoverInputFilePathJSON);
        CreditCardValidator creditCardValidator = new VisaCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_3_JSON() {
        String discoverCCNumber = UtilityParsers.jsonHelper(discoverInputFilePathJSON);
        CreditCardValidator creditCardValidator = new AmexCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing CSV parser and card type
    @Test
    public void testDiscoverCCPositive_CSV() {
        String discoverCCNumber = UtilityParsers.csvHelper(discoverInputFilePathCSV);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(discoverCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_1_CSV() {
        String discoverCCNumber = UtilityParsers.csvHelper(discoverInputFilePathCSV);
        CreditCardValidator creditCardValidator = new MasterCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_2_CSV() {
        String discoverCCNumber = UtilityParsers.csvHelper(discoverInputFilePathCSV);
        CreditCardValidator creditCardValidator = new VisaCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_3_CSV() {
        String discoverCCNumber = UtilityParsers.csvHelper(discoverInputFilePathCSV);
        CreditCardValidator creditCardValidator = new AmexCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing XML parser and card type
    @Test
    public void testDiscoverCCPositive_XML() {
        String discoverCCNumber = UtilityParsers.xmlHelper(discoverInputFilePathXML);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(discoverCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_1_XML() {
        String discoverCCNumber = UtilityParsers.xmlHelper(discoverInputFilePathXML);
        CreditCardValidator creditCardValidator = new MasterCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_2_XML() {
        String discoverCCNumber = UtilityParsers.xmlHelper(discoverInputFilePathXML);
        CreditCardValidator creditCardValidator = new VisaCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testDiscoverCCNegative_3_XML() {
        String discoverCCNumber = UtilityParsers.xmlHelper(discoverInputFilePathXML);
        CreditCardValidator creditCardValidator = new AmexCCValidator(discoverCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

}
