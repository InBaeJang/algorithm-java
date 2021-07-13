import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Main.class.getResourceAsStream("test-case.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String[] strings = br.readLine().split(" ");
        for (String str : strings) {
            System.out.println(str);
        }
        br.close();
    }
}
