public class ValueList {

    private int targetValue;
    private int competitorValue;

    public int evaluate(String[] valueOrder, String target, String competitor) {
        for(int i = 0; i < valueOrder.length; i++)
        {
            for(int a = 0; a < target.length(); a++)
            {
                if(valueOrder[a].equals(target.charAt(a)))
                {
                    targetValue = a;
                    break;
                }
            }

            for(int a = 0; a < competitor.length(); a++)
            {
                if(valueOrder[a].equals(competitor.charAt(a)))
                {
                    competitorValue = a;
                    break;
                }
            }

            if(targetValue != competitorValue)
            {
                if(targetValue > competitorValue)
                {
                    return(1);
                }
            }
        }
        return(0);
    }

    public void Valuelist()
    {
    }

}
