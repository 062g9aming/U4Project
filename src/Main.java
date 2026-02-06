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
                line = line.substring(0, line.indexOf("|"));
                hand = line.split(",");
                Classifier1 cardHand = new Classifier1(hand);
            }
            Classifier1 getResult = new Classifier1();
            getResult.getTypeAmount();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
