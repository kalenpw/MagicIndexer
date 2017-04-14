package card;
/**
 * Represents a Magic the Gathering Card
 * Abstract class: to instantiate use a specific type ex Creature, instant,etc
 * Created by kalenpw on 4/13/17.
 */
public abstract class Card {

    protected String _Name;
    protected ManaCost _ManaCost;
    protected String _Description;
    protected Artwork _ArtWork;


    public String getName(){
        return _Name;
    }

    public ManaCost getManaCost(){
        return _ManaCost;
    }

    public String getDescription(){
        return _Description;
    }


}
