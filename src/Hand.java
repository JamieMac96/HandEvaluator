import java.util.ArrayList;
import java.util.List;

public class Hand {

    private Pair<Card> pocketCards;
    private List<Card> communityCards;

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

    @Override
    public String toString(){
        String string = "Community: " + communityCards.toString();
        string += "\nPocket: " + pocketCards.toString();
        return string;
    }
}
