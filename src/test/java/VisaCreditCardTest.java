import org.junit.Test;
import template.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VisaCreditCardTest {
    private static String visaInputFilePathJSON = "src/test/resources/visacc.json";
    private static String visaInputFilePathCSV = "src/test/resources/visacc.csv";
    private static String visaInputFilePathXML = "src/test/resources/visacc.xml";
    //Testing JSON parser and card type
    @Test
    public void testVisaCCPositive_JSON() {
        String visaCCNumber = UtilityParsers.jsonHelper(visaInputFilePathJSON);
        CreditCardValidator creditCardValidator = new VisaCCValidator(visaCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_1_JSON() {
        String visaCCNumber = UtilityParsers.jsonHelper(visaInputFilePathJSON);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_2_JSON() {
        String visaCCNumber = UtilityParsers.jsonHelper(visaInputFilePathJSON);
        CreditCardValidator creditCardValidator = new MasterCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_3_JSON() {
        String visaCCNumber = UtilityParsers.jsonHelper(visaInputFilePathJSON);
        CreditCardValidator creditCardValidator = new AmexCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing CSV parser and card type
    @Test
    public void testVisaCCPositive_CSV() {
        String visaCCNumber = UtilityParsers.csvHelper(visaInputFilePathCSV);
        CreditCardValidator creditCardValidator = new VisaCCValidator(visaCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_1_CSV() {
        String visaCCNumber = UtilityParsers.csvHelper(visaInputFilePathCSV);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_2_CSV() {
        String visaCCNumber = UtilityParsers.csvHelper(visaInputFilePathCSV);
        CreditCardValidator creditCardValidator = new MasterCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_3_CSV() {
        String visaCCNumber = UtilityParsers.csvHelper(visaInputFilePathCSV);
        CreditCardValidator creditCardValidator = new AmexCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing XML parser and card type
    @Test
    public void testVisaCCPositive_XML() {
        String visaCCNumber = UtilityParsers.xmlHelper(visaInputFilePathXML);
        CreditCardValidator creditCardValidator = new VisaCCValidator(visaCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_1_XML() {
        String visaCCNumber = UtilityParsers.xmlHelper(visaInputFilePathXML);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_2_XML() {
        String visaCCNumber = UtilityParsers.xmlHelper(visaInputFilePathXML);
        CreditCardValidator creditCardValidator = new MasterCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testVisaCCNegative_3_XML() {
        String visaCCNumber = UtilityParsers.xmlHelper(visaInputFilePathXML);
        CreditCardValidator creditCardValidator = new AmexCCValidator(visaCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }
}
