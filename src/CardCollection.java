import card.Card;

import java.util.ArrayList;

/**
 * Created by kalenpw on 4/13/17.
 */
public class CardCollection {
    ArrayList<Card> _CardLibrary;

    public CardCollection(){
        _CardLibrary = new ArrayList<Card>();
    }
    public CardCollection(ArrayList<Card> newLibrary){
        _CardLibrary = newLibrary;
    }

    //Methods
    public void addCard(Card newCard){
        _CardLibrary.add(newCard);
    }

    public void removeCard(Card toRemove){
        _CardLibrary.remove(toRemove);
    }




}
