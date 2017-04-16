package card;

import Utility.JsonManager;

/**
 * Created by kalenpw on 4/14/17.
 */
public class CardFactory {
    private String _CardName;

    public CardFactory(){

    }
    public CardFactory(String cardName){
        _CardName = removeSpacesFromString(cardName);
    }

    public void setCardName(String cardName){
        _CardName = removeSpacesFromString(cardName);
    }

    public Card createCard(){
        JsonManager.setUrl(getQueryUrl());
        String cardType = JsonManager.getValueOfKey("types");

        switch(cardType){
            case "creature":
                return createCreature();
        }



        return null;
    }

    /**
     * Creates a Creature Card
     * @return Creature
     */
    private Creature createCreature(){
        JsonManager.setUrl(getQueryUrl());
        String name = JsonManager.getValueOfKey("name");
        ManaCost manaCost = new ManaCost(JsonManager.getValueOfKey("cost"));
        String description = JsonManager.getValueOfKey("text");
        Artwork artwork = new Artwork(JsonManager.getValueOfKey("image_url"));
        int power = Integer.parseInt(JsonManager.getValueOfKey("power"));
        int toughness = Integer.parseInt(JsonManager.getValueOfKey("toughness"));

        return new Creature(name, manaCost, description, power, toughness, artwork);

    }


    /**
     * Gets the query url for card
     * @return
     */
    private String getQueryUrl(){
        return "https://api.deckbrew.com/mtg/cards?name=" + _CardName;
    }

    /**
     * Replaces spaces with %20 so it can be used in http urls
     * @param String str - string to replace spaces in
     * @return String with no spaces
     */
    private String removeSpacesFromString(String str){
        return str.replace(" ", "%20");
    }
}
