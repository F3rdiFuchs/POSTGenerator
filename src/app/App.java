/**
 * Created by Ferdinand Bauer on 15.10.2015.
 */
package app;

public class App {
    public static void main(String[] args) {
        int hops;
        HttpConnector hp1 = new HttpConnector();
        try {
            hops = hp1.getInput();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int a = 0; a < hops; a++)
        {
            hp1.sendPost();
        }
    }
}
