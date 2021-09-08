import chainofresponsibility.Parser;
import chainofresponsibility.ParserClient;

public class CreditCardClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide input and output paths ");
            return;
        }
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        System.out.println("Received 2 arguments " + args[0] + " : " + args[1]);
        ParserClient parserClient = new ParserClient();
        Parser parser = parserClient.getClient();
        parser.handleRequest(inputFilePath, outputFilePath);
    }
}
