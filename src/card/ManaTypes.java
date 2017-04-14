package card;

/**
 * Created by kalenpw on 4/13/17.
 */
public enum  ManaTypes {
    WHITE, BLUE, BLACK, RED, GREEN, COLORLESS;

    @Override
    public String toString(){
        switch (this){
            case WHITE:
                return "white";

            case BLUE:
                return "blue";

            case BLACK:
                return "black";

            case GREEN:
                return "green";

            case RED:
                return "red";

            case COLORLESS:
                return "colorless";

        }
        //Shouldn't happen
        return "";
    }

    public String getAbbreviation(){
        switch (this){
            case WHITE:
                return "W";

            case BLUE:
                return "U";

            case BLACK:
                return "B";

            case GREEN:
                return "G";

            case RED:
                return "R";

            case COLORLESS:
                return "Z";

        }
        //Shouldn't happen
        return "";
    }

}
