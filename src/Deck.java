import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private LinkedList<Card> deck;

    public Deck(){
        initializeDeck();
    }

    public Card pop(){
        return deck.pop();
    }

    public void removeCard(Card card){
        if(!deck.remove(card)){
            throw new IllegalArgumentException("Could not remove card: "
                                               + card);
        }
    }

    public void removeCard(String card){
        Card removableCard = new Card(card);
        deck.remove(removableCard);
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    @Override
    public String toString(){
        return deck.toString();
    }

    public static void sortByValue(List<Card> deck){
        // Using insertion sort as the input data size will be small
        // most of the time
        // Making insertion sort the best job for this task.

        for (int i=1; i < deck.size(); i++)
        {
            int index = deck.get(i).getIntValue();
            Card cardIndex = deck.get(i);
            int j = i;
            while (j > 0 && deck.get(j-1).getIntValue() > index)
            {
                deck.set(j, deck.get(j-1));
                j--;
            }
            deck.set(j, cardIndex);
        }
    }

    private void initializeDeck(){
        deck = new LinkedList<>();

        String [] suits = {"s", "c", "d", "h"};
        String [] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
                            "10", "J", "Q", "K"};

        for (String value : values) {
            for (String suit : suits) {
                deck.add(new Card(value, suit));
            }
        }
    }
}
