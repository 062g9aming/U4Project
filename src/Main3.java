import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main3
{
    public static void main(String[] args) {

        String[] hand;
        String bid;
        int handLength = 0;
        int totalValue = 0;

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
                ValueConvert3 newHand = new ValueConvert3();
                String value = (newHand.toValue(hand, bid));
                lines[i] = value;
                i++;
            }
            String[] refinedID = lines;

            //Helps compare and award points
            String[] part3Value = {"J", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Q", "K", "A"};
            for (int b = 0; b < refinedID.length; b++)
            {
                int currentBid = Integer.parseInt(refinedID[b].substring(refinedID[b].indexOf(">") + 1));
                int wins = 1;
                for (int c = 0; c < refinedID.length; c++)
                {
                    ValueList part3 = new ValueList();
                    wins += part3.evaluate(part3Value, refinedID[b], refinedID[c]);
                }
                totalValue += wins * currentBid;

            }
        }


        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("Total Bid: " + totalValue);

    }
}
