import java.util.ArrayList;
import java.util.List;

public class Hand {

    private Pair<Card> pocketCards;
    private List<Card> communityCards;

    public static int HIGH_CARD = 0;
    public static int PAIR = 1;
    public static int TWO_PAIR = 2;
    public static int SET = 3;
    public static int STRAIGHT = 4;
    public static int FLUSH = 5;
    public static int FULL_HOUSE = 6;
    public static int STRAIGHT_FLUSH = 7;
    public static int ROYAL_FLUSH = 8;


    public Hand(){
        pocketCards = new Pair<>();
        communityCards = new ArrayList<>();
    }

    public void addPocket(Card card){
        pocketCards.add(card);
    }

    public void addCommunity(Card card){
        communityCards.add(card);
    }

    public List<Pair<Card>> getPairs(){
        return new ArrayList<Pair<Card>>();
    }

    public List<Card> getStraight(){
        return new ArrayList<>();
    }

    public List<Card> getFlush(){
        return new ArrayList<>();
    }

    public List<Card> getCardsOfSameKind(){
        return new ArrayList<>();
    }

    @Override
    public String toString(){
        String string = "Community: " + communityCards.toString();
        string += "\nPocket: " + pocketCards.toString();
        return string;
    }
}
