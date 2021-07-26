import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("src/main/resources/test-case.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String[] strings = br.readLine().split(" ");
        for (String str : strings) {
            System.out.println(str);
        }
        br.close();
    }
}
