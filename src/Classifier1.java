public class Classifier1 {
    String card1Type = "-";
    String card2Type = "-";
    String card3Type = "-";
    String card4Type = "-";
    String card5Type = "-";

    int card1Instance = 0;
    int card2Instance = 0;
    int card3Instance = 0;
    int card4Instance = 0;
    int card5Instance = 0;

    static int fiveKind = 0;
    static int fourKind = 0;
    static int fullHouse = 0;
    static int threeKind = 0;
    static int twoPair = 0;
    static int onePair = 0;
    static int highCard = 0;
    private String handType;

    public Classifier1()
    {
    }

    public Classifier1(String[] rawString)
    {
        card1Type = rawString[0];
        card1Instance = 0;

        //Used to find different types amount
        int i = 0;
        if (i < rawString.length)
        {
            while(i < rawString.length)
            {
                if (!card1Type.equals((rawString[i])))
                {
                    card2Type = rawString[i];
                    break;
                }
                i++;
            }
        }

        if (i < rawString.length)
        {
            while(i < rawString.length)
            {
                if (!card1Type.equals((rawString[i])) && !card2Type.equals((rawString[i])))
                {
                    card3Type = rawString[i];
                    break;
                }
                i++;
            }
        }

        if (i < rawString.length)
        {
            while(i < rawString.length)
            {
                if (!card1Type.equals((rawString[i])) && !card2Type.equals((rawString[i])) && !card3Type.equals((rawString[i])))
                {
                    card4Type = rawString[i];
                    break;
                }
                i++;
            }
        }

        if (i < rawString.length)
        {
            while(i < rawString.length)
            {
                if (!card1Type.equals((rawString[i])) && !card2Type.equals((rawString[i])) && !card3Type.equals((rawString[i])) && !card4Type.equals((rawString[i])))
                {
                    card5Type = rawString[i];
                    break;
                }
                i++;
            }
        }


        //Check amount
        i = 0;
        while(i < rawString.length)
        {
            if (card1Type.equals(rawString[i]))
            {
                card1Instance++;
            }
            i++;
        }
        i = 0;
        while(i < rawString.length)
        {
            if (card2Type.equals(rawString[i]))
            {
                card2Instance++;
            }
            i++;
        }
        i = 0;
        while(i < rawString.length)
        {
            if (card3Type.equals(rawString[i]))
            {
                card3Instance++;
            }
            i++;
        }
        i = 0;
        while(i < rawString.length)
        {
            if (card4Type.equals(rawString[i]))
            {
                card4Instance++;
            }
            i++;
        }
        i = 0;
        while(i < rawString.length)
        {
            if (card5Type.equals(rawString[i]))
            {
                card5Instance++;
            }
            i++;
        }


        boolean declared = false;

        int[] cardAmount = {card1Instance, card2Instance, card3Instance, card4Instance, card5Instance};

        for (int a = 0; a < cardAmount.length && !declared; a++) {
            if (cardAmount[a] == 5)
            {
                declared = true;
                fiveKind++;
                handType = "fiveKind";
            }
        }
        for (int a = 0; a < cardAmount.length && !declared; a++) {
            if (cardAmount[a] == 4)
            {
                declared = true;
                fourKind++;
                handType = "fourKind";
            }
        }
        for (int a = 0; a < cardAmount.length && !declared; a++) {
            if (cardAmount[a] == 3)
            {
                for (int b = 0; b < cardAmount.length && !declared; b++) {
                    if (cardAmount[b] == 2)
                    {
                        declared = true;
                        fullHouse++;
                        handType = "fullHouse";
                        break;
                    }
                }
                if (!declared)
                {
                    declared = true;
                    threeKind++;
                    handType = "threeKind";
                }
            }
        }

        if (!declared)
        {
            int pairAmount = 0;
            for (int a = 0; a < cardAmount.length; a++) {
                if (cardAmount[a] == 2) {
                    pairAmount++;
                }
            }

            if (pairAmount == 0)
            {
                highCard++;
                handType = "highCard";
            }
            else if (pairAmount == 1)
            {
                onePair++;
                handType = "onePair";
            }
            else if (pairAmount == 2)
            {
                twoPair++;
                handType = "twoPair";
            }
        }
    }

    public String getHandType()
    {
        return(handType);
    }
    public void getTypeAmount()
    {
        System.out.println("Number of five of a kind hands: " + fiveKind + "\n" +
                "Number of full house hands: " + fullHouse + "\n" +
                "Number of four of a kind hands: " + fourKind + "\n" +
                "Number of three of a kind hands: " + threeKind + "\n" +
                "Number of two pair hands: " + twoPair + "\n" +
                "Number of one pair hands: " + onePair + "\n" +
                "Number of high card hands: " + highCard);
    }
}

