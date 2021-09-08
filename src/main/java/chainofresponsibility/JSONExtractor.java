package chainofresponsibility;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import creditcards.CreditCard;
import factory.CreditCardFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONExtractor implements Parser {

    private Parser successor = null;

    CreditCardFactory creditCardFactory = new CreditCardFactory();

    CreditCard creditCard = null;

    List<String> jsonList = new ArrayList<>();

    private static final String FILE_NAME = "creditcard_output.json";

    @Override
    public void handleRequest(String inputFilePath, String outputFilePath) {
        if (inputFilePath.contains(".json")) {
            File file = new File(inputFilePath);
            InputStream fileStream = null;
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = null;
            try {
                fileStream = new FileInputStream(file);
                jsonArray = (JSONArray)jsonParser.parse(
                        new InputStreamReader(fileStream, "UTF-8"));
            } catch (FileNotFoundException e) {
                System.out.println("The provided path is incorrect " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Exception while reading the file " + e.getMessage());
            } catch (ParseException e) {
                System.out.println("Unable to parse JSON file " + e.getMessage());
            }

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                // 1. Here we parse the JSON Object and get the card number. Using this, we'll call the template method.
                // 2. This template method calls the factory to create the appropriate object.
                // 3. This object will contain the type of the credit card and write it to output file.
                String cardNumber = jsonObject.get("CardNumber").toString();
                String cardType = UtilityFunctions.createValidator(cardNumber);
                setCardDetails(jsonObject, cardType);
            }

            // change path here
            writeToJsonFile(outputFilePath + FILE_NAME);
        }
        else {
            if (successor != null)
                successor.handleRequest(inputFilePath, outputFilePath);
            else
                System.out.println("No supported parser found for the given file " + inputFilePath);
        }
    }

    @Override
    public void setSuccessor(Parser next) {
        this.successor = next;
    }

    private void setCardDetails(JSONObject jsonObject, String type) {
        creditCard = creditCardFactory.createCreateCard(type);
        creditCard.setCardNumber(jsonObject.get("CardNumber").toString());
        creditCard.setCardName(jsonObject.get("NameOfCardholder").toString());
        creditCard.setExpirationDate(jsonObject.get("ExpirationDate").toString());
        ObjectMapper mapper = new ObjectMapper();
        // pretty print
        String cardObject = null;
        try {
            cardObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(creditCard);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jsonList.add(cardObject);
    }

    private void writeToJsonFile(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            // Writing to a file
            mapper.writeValue(new File(path), jsonList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
