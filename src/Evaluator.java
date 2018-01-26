import java.util.Scanner;

public class Evaluator {

    public static void main(String [] args){
        Evaluator eval = new Evaluator();
        eval.run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        Deck deck = new Deck();
        Hand hand = new Hand();

        deck.shuffle();

        System.out.println("Take pocket Cards: ");
        sc.nextLine();

        hand.addPocket(deck.pop());
        hand.addPocket(deck.pop());
        System.out.println(hand);

        System.out.println("Take flop: ");
        sc.nextLine();

        deck.pop();
        hand.addCommunity(deck.pop());
        hand.addCommunity(deck.pop());
        hand.addCommunity(deck.pop());

        System.out.println(hand);

        System.out.println("Take turn: ");
        sc.nextLine();

        deck.pop();
        hand.addCommunity(deck.pop());

        System.out.println(hand);

        System.out.println("Take river: ");
        sc.nextLine();

        deck.pop();
        hand.addCommunity(deck.pop());

        System.out.println(hand);
    }
}
