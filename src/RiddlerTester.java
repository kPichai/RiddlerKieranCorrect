import java.io.*;
import org.junit.jupiter.api.Test;

public class RiddlerTester {

    private Riddler solver = new Riddler();
    private String encrypted = "";

    @Test
    public void testOne() {
        setTestData("1");
        String s = solver.decryptOne(encrypted);
        System.out.println(s);
    }

    @Test
    public void testTwo() {
        setTestData("2");
        String s = solver.decryptTwo(encrypted);
        System.out.println(s);
    }

    @Test
    public void testThree() {
        setTestData("3");
        String s = solver.decryptThree(encrypted);
        System.out.println(s);
    }

    @Test
    public void testFour() {
        setTestData("4");
        String s = solver.decryptFour(encrypted);
        System.out.println(s);
    }

    private void setTestData(String text) {
        // Open files
        try {
            BufferedReader encryptedReader = new BufferedReader(new FileReader("test_files/" + text + "_encrypted.txt"));
            String line;
            while((line = encryptedReader.readLine()) != null) {
                encrypted += line;
            }
        } catch (IOException e) {
            System.out.println("Error opening test file " + text + "_encrypted.txt");
            e.printStackTrace();
        }
    }
}