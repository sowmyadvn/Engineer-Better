/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/
public class Codec {

    // Encodes a URL to a shortened URL.
    //TinyURL to URL
    Map<String,String> shortMap = new HashMap<>();
    private final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final int count = 6;
    public String encode(String longUrl) {
        String uniqID = "http://tinyurl.com/"+generateID();
        if(shortMap.containsKey(uniqID)) {
            String url = shortMap.get(uniqID);
            if(!url.equals(longUrl))
                return encode(longUrl);
            else
                return uniqID;
        }
        else {
            shortMap.put(uniqID,longUrl);
            return uniqID;
        }
        
    }

    private String generateID() {
        StringBuilder builder = new StringBuilder();
        int temp = count;
        while (temp-- != 0) {
            //Generate random alphanumeric string
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
     // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));