package card;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kalenpw on 4/15/17.
 */
public class CardCollection implements Serializable{

    ArrayList<Card> _CardLibrary;

    public CardCollection(ArrayList<Card> library){
        _CardLibrary = library;
    }

    //Methods
    public void addCard(Card newCard){
        _CardLibrary.add(newCard);
    }

    public void removeCard(Card toRemove){
        _CardLibrary.remove(toRemove);
    }
}
