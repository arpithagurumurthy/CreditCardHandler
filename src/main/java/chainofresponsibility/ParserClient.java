package chainofresponsibility;

public class ParserClient {
    Parser csvParser = new CSVExtractor();
    Parser jsonParser = new JSONExtractor();
    Parser xmlParser = new XMLExtractor();
    public Parser getClient() {
        csvParser.setSuccessor(jsonParser);
        jsonParser.setSuccessor(xmlParser);
        return csvParser;
    }
}
