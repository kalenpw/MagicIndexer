import Utility.ImageDisplayer;
import card.Creature;
import card.ManaCost;
import card.ManaTypes;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;
import sun.net.www.http.HttpClient;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kalenpw on 4/13/17.
 */
public class Indexer {
    public static void main(String args[]){
//        ArrayList<ManaTypes> mana = new ArrayList<ManaTypes>();
//        mana.add(ManaTypes.RED);
//        mana.add(ManaTypes.BLACK);
//        mana.add(ManaTypes.BLUE);
//        mana.add(ManaTypes.COLORLESS);
//        mana.add(ManaTypes.WHITE);
//        mana.add(ManaTypes.COLORLESS);
//        mana.add(ManaTypes.BLUE);
//        mana.add(ManaTypes.BLUE);
//        mana.add(ManaTypes.BLUE);
//
//        ManaCost mc = new ManaCost(mana);
//
//        String formatted = mc.getFormattedMana();
//        System.out.println(formatted);
//        Creature creature = new Creature("Longtusk Cub");
//
//        try {
//            String path = "/media/kalenpw/HDD/Documents/JavaProjects/MagicIndexer/src/Images/Cards/LongtuskCub.png";
//            path = "./src/Images/Cards/LongtuskCub.png";
//            ImageDisplayer id = new ImageDisplayer(path);
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }

        BufferedReader reader = null;
        String json = "";
//        try{
//            URL url = new URL("api.deckbrew.com/mtg/cards");
//            reader = new BufferedReader(new InputStreamReader(url.openStream()));
//            StringBuffer buffer = new StringBuffer();
//            int read;
//            char[] chars = new char[1024];
//            while ((read = reader.read(chars)) != -1)
//                buffer.append(chars, 0, read);
//
//            json = buffer.toString();
//
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//        System.out.println(json);

        Gson g = new Gson();

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


        try {
            json = getJSON("https://api.deckbrew.com/mtg/cards?name=longtusk%20cub", 1100);
            //json = getJSON("https://api.deckbrew.com/mtg/cards?name=incinerate", 1100);
            //json  = getJSON("https://api.deckbrew.com/mtg/types", 10000);
            //System.out.println(json);
            Gson gson = new Gson();
            String str = gson.fromJson("name", String.class);
            //System.out.println(str);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //System.out.println(fromJson);

        String test = getValueOfKey("name", json);

        //System.out.print(json.charAt(fromJson));
        //System.out.println(json.charAt(fromJson + 1));
        System.out.println(test);
    }



    public static String getValueOfKey(String key, String json){
        int index = json.indexOf(key);
        String value = "";
        int quoteCount = 0;
        for(int i = index; i < json.length(); i++){
            if(json.charAt(i) == '"'){
                quoteCount++;
                if(quoteCount == 3){
                    return value.substring(1);
                }
            }
            if(quoteCount == 2){
                value += json.charAt(i);
            }
        }
        return "";
    }

    public static String getJSON(String url, int timeout) throws IOException {

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
                return sb.toString();
        }

        return null;
    }

}
