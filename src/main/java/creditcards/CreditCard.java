package creditcards;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface CreditCard {
    public void setCardNumber(String cardNumber);

    public void setCardName(String cardName);

    public void setExpirationDate(String expirationDate);

    public String getCardNumber();

    public String getCardName();

    public String getExpirationDate();

    public String getCardType();
}
