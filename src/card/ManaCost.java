package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The cost of a spell
 * Created by kalenpw on 4/13/17.
 */
public class ManaCost {
    protected int _TotalCost;
    protected ArrayList<ManaTypes> _ManaTypes;


    //Constructors
    public ManaCost(int totalCost){
        _TotalCost = totalCost;
    }

    public ManaCost(String apiFormattedString){
        //TODO get info from api format

    }

    public ManaCost(ArrayList<ManaTypes> costs){
        int totalCost = 0;
        for(int i = 0; i < costs.size(); i++){
            totalCost++;
        }
        _ManaTypes = costs;
        _TotalCost = totalCost;
    }


    //Accessors and mutators

    //Methods

    /**
     * Returns the formatted mana string
     * Example 3 colorless 2 blue and a black: 3UUB
     * @return String - Formatted converted mana cost
     */
    public String getFormattedMana(){
        int totalColorless = 0;
        String coloredMana = "";

        Collections.sort(_ManaTypes, new Comparator<ManaTypes>() {
            public int compare(ManaTypes mOne, ManaTypes mTwo) {
                return mOne.toString().compareToIgnoreCase(mTwo.toString());
            }
        });

        for(int i = 0; i < _ManaTypes.size(); i++){
            if(_ManaTypes.get(i).toString().equals(ManaTypes.COLORLESS.toString())){
                totalColorless++;
            }
            else {
                coloredMana += _ManaTypes.get(i).getAbbreviation();
            }
        }
        return totalColorless + coloredMana;
    }



}
