import Utility.FileHandler;
import Utility.ImageDisplayer;
import card.Card;
import card.CardFactory;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by kalenpw on 4/13/17.
 */
public class Indexer {
    public static void main(String args[]){

        FileHandler fileHandler = new FileHandler("./src/textfiles/Cards.txt");
        List<String> lines = fileHandler.readAllLines();

        CardFactory cardFactory = new CardFactory();
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < lines.size(); i++){
            cardFactory.setCardName(lines.get(i));
            Card newCard = cardFactory.createCard();
            cards.add(newCard);
            ImageDisplayer imageDisplayer = new ImageDisplayer(newCard.getArtWork().getImageLocation());
            imageDisplayer.displayImageFromUrl();
        }

    }


}
