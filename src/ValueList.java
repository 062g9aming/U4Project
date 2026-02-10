public class ValueList {

    private int targetValue;
    private int competitorValue;

    public int evaluate(String[] valueOrder, String target, String competitor) {
        for(int cardIndex = 0; cardIndex < 5; cardIndex++)
        {
            String targetLetter = String.valueOf(target.charAt(cardIndex));
            String competitiorLetter = String.valueOf(competitor.charAt(cardIndex));

            for(int valueIndex = 0; valueIndex < valueOrder.length; valueIndex++)
            {
                if(valueOrder[valueIndex].equals(targetLetter))
                {
                    targetValue = valueIndex;
                    System.out.println(targetValue);
                }
            }
        }
        return(0);
    }
}
