package chainofresponsibility;

public interface Parser {
    public void handleRequest(String inputFilePath, String outputFilePath);

    public void setSuccessor(Parser next);
}
