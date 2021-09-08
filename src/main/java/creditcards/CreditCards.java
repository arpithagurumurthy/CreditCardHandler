package creditcards;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlSeeAlso({MasterCC.class, VisaCC.class, AmExCC.class, DiscoverCC.class, InvalidCC.class})

@XmlRootElement(name = "creditcards")
public class CreditCards {
    private List<CreditCard> creditCardList = null;

    public List<CreditCard> getCreditCards() {
        return creditCardList;
    }

    public void setCreditCards(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }
}
