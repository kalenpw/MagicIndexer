import Utility.FileHandler;
import Utility.ImageDisplayer;
import Utility.JsonManager;
import card.Card;
import card.CardFactory;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by kalenpw on 4/13/17.
 */
public class Indexer {
    public static void main(String args[]){

        JsonManager.setUrl("https://api.deckbrew.com/mtg/cards?name=Electrostatic%20Pummeler");
        System.out.println(JsonManager.getJson());

        FileHandler fileHandler = new FileHandler("./src/textfiles/Cards.txt");
        List<String> lines = fileHandler.readAllLines();

        CardFactory cardFactory = new CardFactory();
        //Throwing nullpointer for electrostaic pummeler?
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
