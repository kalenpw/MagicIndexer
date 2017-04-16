package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kalenpw on 4/14/17.
 */
public class JsonManager {

    private static String _Json;
    private static String _Url;

    public JsonManager() {
        _Json = "Jsosn not set";
    }



    public static void setJson(String newJson){
        _Json = newJson;
    }
    public static void setUrl(String newUrl){
        _Url = newUrl;
    }
    //Methods

    /**
     * Gets the value of a given key from Json File
     * @param String key - the key for the data
     * @return String - the data matching key
     */
    public static String getValueOfKey(String key){
        //Account for trailing quotes because value is actually "yourValue
        int accountForTrailingQuote = 1;
        //findingValues are representative of how many quotation marks we have iterated over
        int stillFindingValue = 2;
        int doneFindingValue = 3;
        String value = "";
        int quoteCount = 0;
        getJson();
        int index = _Json.indexOf(key);

        for(int i = index; i < _Json.length(); i++){
            if(_Json.charAt(i) == '"'){
                quoteCount++;
                if(quoteCount == doneFindingValue){
                    return value.substring(accountForTrailingQuote);
                }
            }
            if(quoteCount == stillFindingValue){
                value += _Json.charAt(i);
            }
        }
        return "";
    }

    /**
     * Cleaner version of getJsonImplemented that uses the _Url field and timeout value of 1000ms
     * @return String - complete Json from url
     */
    public static String getJson(){
        try{
            return getJsonImplemented(_Url, 1000);

        }
        catch(IOException e){
            e.printStackTrace();
            return e.toString();
        }


    }

    /**
     * Implemntation of getting Json as string from URl
     * @param String url - the URL of Json
     * @param int timeout - duration in milliseconds before timing out
     * @return String - Complete Json from URL
     * @throws IOException - Can't find JSON
     */
    private static String getJsonImplemented(String url, int timeout) throws IOException {

        URL u = new URL(url);
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setUseCaches(false);
        c.setAllowUserInteraction(false);
        c.setConnectTimeout(timeout);
        c.setReadTimeout(timeout);
        c.connect();
        int status = c.getResponseCode();

        switch (status) {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                _Json = sb.toString();
                return sb.toString();
        }

        return null;
    }
}


//SAMPLE JSON OUTPUT
/*

[
  {
    "name": "Longtusk Cub",
    "id": "longtusk-cub",
    "url": "https://api.deckbrew.com/mtg/cards/longtusk-cub",
    "store_url": "http://store.tcgplayer.com/magic/kaladesh/longtusk-cub?partner=DECKBREW",
    "types": [
      "creature"
    ],
    "subtypes": [
      "cat"
    ],
    "colors": [
      "green"
    ],
    "cmc": 2,
    "cost": "{1}{G}",
    "text": "Whenever Longtusk Cub deals combat damage to a player, you get {E}{E} (two energy counters).\nPay {E}{E}: Put a +1/+1 counter on Longtusk Cub.",
    "power": "2",
    "toughness": "2",
    "formats": {
      "commander": "legal",
      "legacy": "legal",
      "modern": "legal",
      "standard": "legal",
      "vintage": "legal"
    },
    "editions": [
      {
        "set": "Kaladesh",
        "set_id": "KLD",
        "rarity": "uncommon",
        "artist": "Zoltan Boros",
        "multiverse_id": 417734,
        "flavor": "It won't be small forever.",
        "number": "161",
        "layout": "normal",
        "price": {
          "low": 0,
          "median": 0,
          "high": 0
        },
        "url": "https://api.deckbrew.com/mtg/cards?multiverseid=417734",
        "image_url": "https://image.deckbrew.com/mtg/multiverseid/417734.jpg",
        "set_url": "https://api.deckbrew.com/mtg/sets/KLD",
        "store_url": "http://store.tcgplayer.com/magic/kaladesh/longtusk-cub?partner=DECKBREW",
        "html_url": "https://deckbrew.com/mtg/cards/417734"
      }
    ]
  }
]

*/