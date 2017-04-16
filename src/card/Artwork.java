package card;

/**
 * Created by kalenpw on 4/13/17.
 */
public class Artwork {

    //Fields
    private String _ImageLocation;

    public Artwork(String newCardImageDirectory){
        _ImageLocation = newCardImageDirectory;
    }

    public String getImageLocation(){
        return _ImageLocation;
    }



}

