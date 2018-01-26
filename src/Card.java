import java.util.HashSet;
import java.util.Objects;
import java.util.Arrays;
import java.util.Set;

public class Card {

    // The value and suit of the card
    private final String value;
    private final String suit;

    // Sets that contain all of the valid values and suits
    // Used to validate the values passed to the constructor
    private Set<String> validValues;
    private Set<String> validSuits;

    // Publically declare the strings that represent
    // the suits and values to ease use of the class
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

        if(!validValues.contains(value)) throw new IllegalArgumentException(value);
        if(!validSuits.contains(suit)) throw new IllegalArgumentException(suit);

        this.value = value;
        this.suit = suit;
    }

    public Card(String card){
        String tempValue = card.substring(0, card.length() - 1);
        String tempSuit = card.substring(card.length() - 1, card.length());

        if(!validValues.contains(tempValue)) throw new IllegalArgumentException(tempValue);
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

    @Override
    public String toString(){
        char suitChar = (char)'\u2660';

        switch (suit){
            case CLUBS:
                suitChar = (char)'\u2663';
                break;
            case DIAMONDS:
                suitChar = (char)'\u2666';
                break;
            case HEARTS:
                suitChar = (char)'\u2764';
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


        validSuits = new HashSet(Arrays.asList(suitsArray));
        validValues = new HashSet(Arrays.asList(valuesArray));
    }
}
