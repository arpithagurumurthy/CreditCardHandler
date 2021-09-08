import org.junit.Test;
import template.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MasterCreditCardTest {
    private static String masterInputFilePathJSON = "src/test/resources/mastercc.json";
    private static String masterInputFilePathCSV = "src/test/resources/mastercc.csv";
    private static String masterInputFilePathXML = "src/test/resources/mastercc.xml";
    //Testing JSON parser and card type
    @Test
    public void testMasterCCPositive_JSON() {
        String masterCCNumber = UtilityParsers.jsonHelper(masterInputFilePathJSON);
        CreditCardValidator creditCardValidator = new MasterCCValidator(masterCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_1_JSON() {
        String masterCCNumber = UtilityParsers.jsonHelper(masterInputFilePathJSON);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_2_JSON() {
        String masterCCNumber = UtilityParsers.jsonHelper(masterInputFilePathJSON);
        CreditCardValidator creditCardValidator = new VisaCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_3_JSON() {
        String masterCCNumber = UtilityParsers.jsonHelper(masterInputFilePathJSON);
        CreditCardValidator creditCardValidator = new AmexCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing CSV parser and card type
    @Test
    public void testMasterCCPositive_CSV() {
        String masterCCNumber = UtilityParsers.csvHelper(masterInputFilePathCSV);
        CreditCardValidator creditCardValidator = new MasterCCValidator(masterCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_1_CSV() {
        String masterCCNumber = UtilityParsers.csvHelper(masterInputFilePathCSV);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_2_CSV() {
        String masterCCNumber = UtilityParsers.csvHelper(masterInputFilePathCSV);
        CreditCardValidator creditCardValidator = new VisaCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_3_CSV() {
        String masterCCNumber = UtilityParsers.csvHelper(masterInputFilePathCSV);
        CreditCardValidator creditCardValidator = new AmexCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing XML parser and card type
    @Test
    public void testMasterCCPositive_XML() {
        String masterCCNumber = UtilityParsers.xmlHelper(masterInputFilePathXML);
        CreditCardValidator creditCardValidator = new MasterCCValidator(masterCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_1_XML() {
        String masterCCNumber = UtilityParsers.xmlHelper(masterInputFilePathXML);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_2_XML() {
        String masterCCNumber = UtilityParsers.xmlHelper(masterInputFilePathXML);
        CreditCardValidator creditCardValidator = new VisaCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testMasterCCNegative_3_XML() {
        String masterCCNumber = UtilityParsers.xmlHelper(masterInputFilePathXML);
        CreditCardValidator creditCardValidator = new AmexCCValidator(masterCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }
}
