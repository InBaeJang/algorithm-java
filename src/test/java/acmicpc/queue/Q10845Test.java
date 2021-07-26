package acmicpc.queue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class Q10845Test {
    private static final String filename = "src/test/resources/test-case.txt";

    @Before
    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write("15\n" +
                "push 1\n" +
                "push 2\n" +
                "front\n" +
                "back\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "pop\n" +
                "pop\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "push 3\n" +
                "empty\n" +
                "front");
        fw.close();
    }

    @AfterClass
    public static void deleteFile() {
        File file = new File(filename);
        if (file.exists()) {
            if(file.delete()){
                System.out.println("File deletion success");
            }else{
                System.out.println("File deletion failed");
            }
        }else{
            System.out.println("No file");
        }
    }

    @Test
    public void Q10845_test() throws Exception {
        //given
        InputStream inputStream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        //when
        String answer = Q10845.solve(br);

        //then
        String correctAnswer = "1\n" +
                "2\n" +
                "2\n" +
                "0\n" +
                "1\n" +
                "2\n" +
                "-1\n" +
                "0\n" +
                "1\n" +
                "-1\n" +
                "0\n" +
                "3";
        assertEquals(correctAnswer, answer);
    }
}