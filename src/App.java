import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class App {
    public static void main(String[] args) throws Exception {

        for(int a = 0; a < 10000;a++)
        {
            sendPost();
        }
    }

    private static void sendPost() {
        String url = "http://localhost/MyApp/app/#/admin/user";
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
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
