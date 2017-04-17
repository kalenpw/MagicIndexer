package card;
/*
name
cost
text
power
toughness
image
 */

import java.io.Serializable;

/**
 * Created by kalenpw on 4/13/17.
 */
public class Creature extends  Card implements Serializable {
    //Fields
    private int _Power;
    private int _Toughness;

    //Constructors
    public Creature(){

    }

    //Accessors and mutators
    public int getPower(){
        return _Power;
    }

    //Methods
    public Creature(String name){
        super._Name = name;

    }

    public Creature(String name, ManaCost manaCost, String text, int power, int toughness, Artwork artwork){
        super._Name = name;
        super._ManaCost = manaCost;
        super._Description = text;
        this._Power = power;
        this._Toughness = toughness;
        super._ArtWork = artwork;

    }


}
