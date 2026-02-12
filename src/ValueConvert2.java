public class ValueConvert2 {
    private String value = "";

    public String toValue(String[] inputtedHand, String bid)
    {
        for(int i = 0; i < inputtedHand.length; i++)
        {
            if (inputtedHand[i].equals("10"))
            {
                value = value + "0";
            }
            else
            {
                value = value + inputtedHand[i].charAt(0);
            }
        }

        Classifier2 cardHand = new Classifier2(inputtedHand);
        value = value + "-" + cardHand.getHandType() + ">" + bid;

        return(value);
    }
}
