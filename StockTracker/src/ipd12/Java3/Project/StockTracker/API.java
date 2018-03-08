package ipd12.Java3.Project.StockTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class API {  
    
    //getting String from BufferedReader
    private static String readAll(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
        } catch (IOException ex) {
        }
        return sb.toString();
    }

    //returns JSON object from HTTP request
    public static JSONObject getJson(String url) {
        JSONObject json = null;
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        } catch (IOException | JSONException ex) {
        }
        return json;
    }

}
