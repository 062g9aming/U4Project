import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2
{
    public static void main(String[] args) {

        String[] hand;
        String bid;
        int handLength = 0;

        String[] lines;

        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }

            lines = fileData.split("\n");


            //Helps break it to raw info
            int i =0;
            for (String line : lines){
                bid = line.substring(line.indexOf("|") + 1);
                line = line.substring(0, line.indexOf("|"));
                hand = line.split(",");
                ValueConvert newHand = new ValueConvert();
                String value = (newHand.toValue(hand, bid));
                lines[i] = value;
                i++;
            }
            System.out.println(Arrays.toString(lines));
            String[] refinedID = lines;

            //Helps compare and award points
            String[] part2Value = {"2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K", "A"};
            for (int b = 0; b < refinedID.length; b++)
            {
                int wins = 1;
                for (int c = 0; c < refinedID.length; c++)
                {
                    ValueList part2 = new ValueList();
                    wins += part2.evaluate(part2Value, refinedID[b], refinedID[c]);
                }
                System.out.println(refinedID[b]);
                System.out.println(wins);
            }
        }


        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }



    }
}
