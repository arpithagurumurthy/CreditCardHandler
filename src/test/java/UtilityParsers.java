import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class UtilityParsers {

    private static final String DELIMITER = "\t";

    public static String jsonHelper(String inputFilePath) {
        File file = new File(inputFilePath);
        InputStream fileStream = null;
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        String amexCCNumber = null;
        try {
            fileStream = new FileInputStream(file);
            jsonArray = (JSONArray)jsonParser.parse(
                    new InputStreamReader(fileStream, "UTF-8"));
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            amexCCNumber = jsonObject.get("CardNumber").toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return amexCCNumber;
    }


    public static String csvHelper(String inputFilePath) {
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
                for (String line : lines) {
                    String[] columns = line.split(DELIMITER);
                    String cardNumber = columns[0].trim();
                    return cardNumber;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String xmlHelper(String inputFilePath) {
        File file = new File(inputFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String cardNumber = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();
                return cardNumber;
            }
        }
        return null;
    }


}
