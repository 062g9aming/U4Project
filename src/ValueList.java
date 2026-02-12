public class ValueList {

    private int targetValue;
    private int competitorValue;

    public int evaluate(String[] valueOrder, String target, String competitor) {
        for(int cardIndex = 0; cardIndex < 5; cardIndex++)
        {
            if(target.equals(competitor))
            {
                return(0);
            }

            int targetRank = Integer.parseInt(String.valueOf(target.charAt(target.indexOf("-")+1)));
            int competitorRank = Integer.parseInt(String.valueOf(competitor.charAt(competitor.indexOf("-")+1)));

            if(targetRank > competitorRank)
            {
                return(1);
            }
            else if(targetRank < competitorRank)
            {
                return(0);
            }

            String targetLetter = String.valueOf(target.charAt(cardIndex));
            String competitorLetter = String.valueOf(competitor.charAt(cardIndex));


            for(int valueIndex = 0; valueIndex < valueOrder.length; valueIndex++)
            {
                if(valueOrder[valueIndex].equals(targetLetter) && !valueOrder[valueIndex].equals(competitorLetter)) {
                    return (0);
                }
                if(valueOrder[valueIndex].equals(competitorLetter) && !valueOrder[valueIndex].equals(targetLetter)) {
                    return (1);
                }
            }
        }
        return(0);
    }
}
