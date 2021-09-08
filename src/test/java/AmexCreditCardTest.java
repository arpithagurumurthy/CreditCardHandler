import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import template.*;

import java.io.*;

import static org.junit.Assert.*;
public class AmexCreditCardTest {
    private static String amexInputFilePathJSON = "src/test/resources/amexcc.json";
    private static String amexInputFilePathCSV = "src/test/resources/amexcc.csv";
    private static String amexInputFilePathXML = "src/test/resources/amexcc.xml";

    //Testing JSON parser and card type
    @Test
    public void testAmexCCPositive_JSON() {
        String amexCCNumber = UtilityParsers.jsonHelper(amexInputFilePathJSON);
        CreditCardValidator creditCardValidator = new AmexCCValidator(amexCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_1_JSON() {
        String amexCCNumber = UtilityParsers.jsonHelper(amexInputFilePathJSON);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_2_JSON() {
        String amexCCNumber = UtilityParsers.jsonHelper(amexInputFilePathJSON);
        CreditCardValidator creditCardValidator = new MasterCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_3_JSON() {
        String amexCCNumber = UtilityParsers.jsonHelper(amexInputFilePathJSON);
        CreditCardValidator creditCardValidator = new VisaCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing CSV parser and card type
    @Test
    public void testAmexCCPositive_CSV() {
        String amexCCNumber = UtilityParsers.csvHelper(amexInputFilePathCSV);
        CreditCardValidator creditCardValidator = new AmexCCValidator(amexCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_1_CSV() {
        String amexCCNumber = UtilityParsers.csvHelper(amexInputFilePathCSV);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_2_CSV() {
        String amexCCNumber = UtilityParsers.csvHelper(amexInputFilePathCSV);
        CreditCardValidator creditCardValidator = new MasterCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_3_CSV() {
        String amexCCNumber = UtilityParsers.csvHelper(amexInputFilePathCSV);
        CreditCardValidator creditCardValidator = new VisaCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    //Testing XML parser and card type
    @Test
    public void testAmexCCPositive_XML() {
        String amexCCNumber = UtilityParsers.xmlHelper(amexInputFilePathXML);
        CreditCardValidator creditCardValidator = new AmexCCValidator(amexCCNumber);
        assertTrue(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_1_XML() {
        String amexCCNumber = UtilityParsers.xmlHelper(amexInputFilePathXML);
        CreditCardValidator creditCardValidator = new DiscoverCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_2_XML() {
        String amexCCNumber = UtilityParsers.xmlHelper(amexInputFilePathXML);
        CreditCardValidator creditCardValidator = new MasterCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }

    @Test
    public void testAmexCCNegative_3_XML() {
        String amexCCNumber = UtilityParsers.xmlHelper(amexInputFilePathXML);
        CreditCardValidator creditCardValidator = new VisaCCValidator(amexCCNumber);
        assertFalse(creditCardValidator.validateCreditCard());
    }
}
