import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] hand;

        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                hand = line.split(",");
                System.out.println(Arrays.toString(hand));
                Classifier cardHand = new Classifier(hand);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
