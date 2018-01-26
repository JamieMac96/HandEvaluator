import java.util.LinkedList;
import java.util.Collections;

public class Deck {

    private LinkedList<Card> deck;

    public Deck(){
        initializeDeck();
    }

    public Card pop(){
        return deck.pop();
    }

    public void removeCard(Card card){
        for(Card deckCard: deck){
            if(deckCard.equals(card)){
                deck.remove(card);
            }
        }
    }

    public void removeCard(String card){
        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).toString().equals(card)){
                deck.remove(i);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    @Override
    public String toString(){
        return deck.toString();
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
