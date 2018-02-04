import java.util.*;

public class Card {

    // The value and suit of the card.
    private final String value;
    private final String suit;

    // The keys of this map are the string values associated with each card
    // value. Ie ace = "A". The values of this map are numbers indicating
    // the value of the card. eg ace = 1, 2 = 2, jack = 11
    private Map<String, Integer> validValues;

    // The set of suits is used to validate that when a card is created
    // A valid suit has been specified.
    private Set<String> validSuits;

    // Publically declare the strings that represent
    // the suits and values to ease use of the class.
    public static final String ACE = "A";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";
    public static final String NINE = "9";
    public static final String TEN = "10";
    public static final String JACK = "J";
    public static final String QUEEN = "Q";
    public static final String KING = "K";

    public static final String SPADES = "s";
    public static final String CLUBS = "c";
    public static final String DIAMONDS = "d";
    public static final String HEARTS = "h";

    public Card(String value, String suit){
        initializeSets();

        if(!validValues.containsKey(value)) throw new IllegalArgumentException(value);
        if(!validSuits.contains(suit)) throw new IllegalArgumentException(suit);

        this.value = value;
        this.suit = suit;
    }

    public Card(String card){
        initializeSets();

        String tempValue = card.substring(0, card.length() - 1);
        String tempSuit = card.substring(card.length() - 1, card.length());

        if(!validValues.containsKey(tempValue)) throw new IllegalArgumentException(tempValue);
        if(!validSuits.contains(tempSuit)) throw new IllegalArgumentException(tempSuit);

        this.value = tempValue;
        this.suit = tempSuit;
    }

    public String getSuit(){
        return suit;
    }

    public String getValue(){
        return value;
    }

    public int getIntValue(){
        return validValues.get(value);
    }

    // We use the unicode characters to display the suits
    // Eg the spades symbol = '\u2660'
    @Override
    public String toString(){

        // Default value for initialization
        char suitChar = '\u0000';

        switch (suit){
            case SPADES:
                suitChar = (char)'\u2660';
                break;
            case CLUBS:
                suitChar = (char)'\u2663';
                break;
            case DIAMONDS:
                suitChar = (char)'\u2666';
                break;
            case HEARTS:
                suitChar = (char)'\u2764';
                break;
        }

        return value + suitChar;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Card){
            Card comparisonCard = (Card)o;
            if(suit.equals(comparisonCard.getSuit())){
                if(value.equals(comparisonCard.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value, suit);
    }

    private void initializeSets(){
        String [] suitsArray =  {SPADES, CLUBS, DIAMONDS, HEARTS};
        String [] valuesArray = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                                 EIGHT, NINE, TEN, JACK, QUEEN, KING};
        int [] valueInts = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


        validValues = new HashMap<>();
        validSuits = new HashSet<>(Arrays.asList(suitsArray));

        for(int i = 0; i < valuesArray.length; i++){
            validValues.put(valuesArray[i], valueInts[i]);
        }
    }
}
