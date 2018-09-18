import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();
        return contents;
    }

    public static int wordCount (String contents) {
        int wordCount = 0;
        String newWord = "";
        for (int i = 0; i < contents.length(); i++) {
            newWord = "";
            while ((int) contents.charAt(i) != (int) ' ') {
                if (i == contents.length() - 1) {
                    break;
                }
                newWord = newWord + contents.charAt(i);
                i++;
            }
            if (newWord.equalsIgnoreCase("prince")) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
