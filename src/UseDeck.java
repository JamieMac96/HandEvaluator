public class UseDeck {

    public static void main(String [] args){
        Deck deck = new Deck();

        System.out.println(deck.toString() + "\n");

        deck.shuffle();

        System.out.println(deck.toString());
    }
}
