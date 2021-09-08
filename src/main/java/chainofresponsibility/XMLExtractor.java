package chainofresponsibility;

import creditcards.CreditCard;
import creditcards.CreditCards;
import factory.CreditCardFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLExtractor implements Parser {

    private Parser successor = null;

    CreditCardFactory creditCardFactory = new CreditCardFactory();

    CreditCard creditCard = null;

    List<CreditCard> creditCards = new ArrayList<>();

    private static final String FILE_NAME = "creditcard_output.xml";

    @Override
    public void handleRequest(String inputFilePath, String outputFilePath) {
        if (inputFilePath.contains(".xml")) {
            File file = new File(inputFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            Document doc = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(file);

            } catch (ParserConfigurationException e) {
                System.out.println("Unable to parse XML file " + e.getMessage());
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Exception while reading the file " + e.getMessage());
            }
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String cardNumber = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();
                    String expirationDate = eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent();
                    String cardHolder = eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent();
                    String cardType = UtilityFunctions.createValidator(cardNumber);
                    setCardDetails(cardType, cardNumber, expirationDate, cardHolder);
                }
            }
            saveToXmlFile(outputFilePath + FILE_NAME);
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

    private void saveToXmlFile(String path) {
        CreditCards creditCardList = new CreditCards();
        creditCardList.setCreditCards(creditCards);
        JAXBContext jaxbContext = null;
        Marshaller jaxbMarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance(CreditCards.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(creditCardList, System.out);
            jaxbMarshaller.marshal(creditCardList, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
