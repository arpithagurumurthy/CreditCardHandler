package chainofresponsibility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import creditcards.CreditCard;
import factory.CreditCardFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVExtractor implements Parser{
    private Parser successor = null;

//    private final String DELIMITER = "\t";

    CreditCardFactory creditCardFactory = new CreditCardFactory();

    CreditCard creditCard = null;

    List<CreditCard> creditCards = new ArrayList<>();

    private static final String CSV_SEPARATOR = ",";

    private static final String FILE_NAME = "creditcard_output.csv";

    @Override
    public void handleRequest(String inputFilePath, String outputFilePath) {
        // check if file is .csv
        if (inputFilePath.contains(".csv")) {
            File file = new File(inputFilePath);
            InputStream fileStream = null;
            try {
                fileStream = new FileInputStream(file);
                Reader targetReader = new InputStreamReader(fileStream);
                CSVReader csvReader = new CSVReader(targetReader);
                String[] lines;
                int lineNumber = 0;
                while ((lines = csvReader.readNext()) != null) {
                    if (lineNumber == 0) {
                        lineNumber++;
                        continue;
                    }
                    String cardNumber = lines[0].trim();
                    String expirationDate = lines[1].trim();
                    String cardHolder = lines[2].trim();
                    String cardType = UtilityFunctions.createValidator(cardNumber);
                    setCardDetails(cardType, cardNumber, expirationDate, cardHolder);
                    lineNumber++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("The provided path is incorrect " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Exception while reading the file " + e.getMessage());
            } catch (CsvValidationException e) {
                System.out.println("Unable to parse CSV file  " + e.getMessage());
            }

            // change path here
            saveToCsvFile(outputFilePath + FILE_NAME);
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

    private void setCardDetails(String type, String cardNumber, String expirationDate, String cardHolder) {
        creditCard = creditCardFactory.createCreateCard(type);
        creditCard.setCardNumber(cardNumber);
        creditCard.setCardName(cardHolder);
        creditCard.setExpirationDate(expirationDate);
        creditCards.add(creditCard);
    }

    public void saveToCsvFile(String path) {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            for (CreditCard product : creditCards)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(product.getCardNumber());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getCardName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getExpirationDate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getCardType());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
