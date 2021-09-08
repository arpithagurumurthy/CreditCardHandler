package creditcards;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "creditcard")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisaCC implements CreditCard{

    private String cardNumber;

    private String cardName;

    private String expirationDate;

    private String type = "Visa";

    @Override
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getCardNumber() {
        return this.cardNumber;
    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public String getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public String getCardType() {
        return this.type;
    }
}
