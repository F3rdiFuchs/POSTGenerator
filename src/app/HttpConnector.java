/**
 * Created by Ferdinand Bauer on 15.10.2015.
 */
package app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpConnector {
    private String url;
    private String context;
    private int hops;
    private boolean waitForResponse = true;
    private String temp;

    public int getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------http-post-crafter--------------");
        System.out.println("");
        System.out.println("Please enter your UML (http://localhost/MyApp/app)");
        url = br.readLine();
        System.out.println("Please enter your Context)");
        context = br.readLine();
        System.out.println("How many posts? ");
        hops = Integer.parseInt(br.readLine());
        System.out.println("Wait for response? Y/N (default: true");
        temp = br.readLine();

        if (temp.equals("Y") || temp.equals("y"))
        {
            waitForResponse = true;
            return hops;
        }
        else if (temp.equals("N") ||  temp.equals("n"))
        {
            waitForResponse = false;
            return hops;
        }
        else
        {
            waitForResponse = true;
            return hops;
        }

    }

    public void sendPost() {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");
            String content = "{}";

            con.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(con.getOutputStream());
            writer.writeBytes(content);
            writer.flush();
            writer.close();

            System.out.println("POST:");

            if (waitForResponse == true) {
                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String input;
                StringBuffer response = new StringBuffer();
                while ((input = in.readLine()) != null) {
                    response.append(input);
                }
                in.close();
                System.out.println(response.toString());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
