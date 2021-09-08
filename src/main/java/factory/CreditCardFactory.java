package factory;

import creditcards.*;

public class CreditCardFactory {
    public CreditCard createCreateCard(String type){
        CreditCard creditCard = null;

        if (type.equals("Visa")){
            creditCard = new VisaCC();
        }
        else if (type.equals("MasterCard")){
            creditCard = new MasterCC();
        }
        else if (type.equals("AmericanExpress")){
            creditCard = new AmExCC();
        }
        else if (type.equals("Discover")){
            creditCard = new DiscoverCC();
        }
        else {
            creditCard = new InvalidCC();
        }

        return creditCard;
    }
}
