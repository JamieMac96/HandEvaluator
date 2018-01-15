import java.util.Map;
import java.util.HashMap;

public class Card {

    private final int suit;
    private final int value;

    public static final int SPADES = 0;
    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    //Mappings from string to int and int to string for suits
    private Map<String, Integer> SIsuits;
    private Map<Integer, String> ISsuits;

    //Mapping from string to int and int to string for values
    private Map<String, Integer> SIvalues;
    private Map<Integer, String> ISvalues;


    public Card(int suit, int value){
        initializeMappings();
        this.suit = suit;
        this.value = value;
    }

    public Card(String suit, String value){
        initializeMappings();
        this.suit = getSuitNumber(suit);
        this.value = getValueNumber(value);
    }

    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public int getSuitNumber(String suit){
        return SIsuits.get(suit);
    }

    public String getSuitString(int suit){
        return ISsuits.get(suit);
    }

    public int getValueNumber(String value){
        return SIvalues.get(value);
    }

    public String getValueString(int value){
        return ISvalues.get(value);
    }

    public String toString(){
        return getValueString(value) + getSuitString(suit);
    }

    private void initializeMappings(){
        SIsuits = new HashMap<>();
        ISsuits = new HashMap<>();
        SIvalues = new HashMap<>();
        ISvalues = new HashMap<>();

        SIvalues.put("A", 1);
        SIvalues.put("a", 1);
        SIvalues.put("ace", 1);
        SIvalues.put("ACE", 1);
        SIvalues.put("2", 2);
        SIvalues.put("3", 3);
        SIvalues.put("4", 4);
        SIvalues.put("5", 5);
        SIvalues.put("6", 6);
        SIvalues.put("7", 7);
        SIvalues.put("8", 8);
        SIvalues.put("9", 9);
        SIvalues.put("10", 10);
        SIvalues.put("J", 11);
        SIvalues.put("j", 11);
        SIvalues.put("Q", 12);
        SIvalues.put("q", 12);
        SIvalues.put("QUEEN", 12);
        SIvalues.put("queen", 12);
        SIvalues.put("K", 13);
        SIvalues.put("k", 13);
        SIvalues.put("KING", 13);
        SIvalues.put("king", 13);


        ISvalues.put(1, "A");
        ISvalues.put(2, "2");
        ISvalues.put(3, "3");
        ISvalues.put(4, "4");
        ISvalues.put(5, "5");
        ISvalues.put(6, "6");
        ISvalues.put(7, "7");
        ISvalues.put(8, "8");
        ISvalues.put(9, "9");
        ISvalues.put(10, "10");
        ISvalues.put(11, "J");
        ISvalues.put(12, "Q");
        ISvalues.put(13, "K");

        SIsuits.put("S", 0);
        SIsuits.put("s", 0);
        SIsuits.put("SPADES", 0);
        SIsuits.put("spades", 0);
        SIsuits.put("C", 1);
        SIsuits.put("c", 1);
        SIsuits.put("CLUBS", 1);
        SIsuits.put("spades", 1);
        SIsuits.put("D", 2);
        SIsuits.put("d", 2);
        SIsuits.put("DIAMONDS", 2);
        SIsuits.put("diamonds", 2);
        SIsuits.put("H", 3);
        SIsuits.put("h", 3);
        SIsuits.put("HEARTS", 3);
        SIsuits.put("hearts", 3);

        ISsuits.put(0, "s");
        ISsuits.put(1, "c");
        ISsuits.put(2, "d");
        ISsuits.put(3, "h");
    }
}
