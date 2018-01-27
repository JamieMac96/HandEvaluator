import java.util.Scanner;

public class Evaluator {

    private Deck deck;
    private Hand hand;
    private Scanner sc;

    public Evaluator(){
        sc = new Scanner(System.in);
        deck = new Deck();
        hand = new Hand();
    }

    public static void main(String [] args){
        Evaluator eval = new Evaluator();
        eval.run();
    }

    public void run(){
        enterPocket();
        enterFlop();
        enterTurn();
        enterRiver();
    }

    private void enterPocket(){
        System.out.println("Enter pocket Cards: ");
        System.out.println("\tFirst Card:");
        String pocketOneStr = sc.nextLine();
        System.out.println("\tSecond Card:");
        String pocketTwoStr = sc.nextLine();

        Card pocketOne = new Card(pocketOneStr);
        Card pocketTwo = new Card(pocketTwoStr);

        deck.removeCard(pocketOne);
        deck.removeCard(pocketTwo);

        hand.addPocket(pocketOne);
        hand.addPocket(pocketTwo);
        System.out.println(hand);
    }

    private void enterFlop(){
        System.out.println("Enter flop: ");
        System.out.println("\tFirst Card:");
        String flopOneStr = sc.nextLine();
        System.out.println("\tFirst Card:");
        String flopTwoStr = sc.nextLine();
        System.out.println("\tFirst Card:");
        String flopThreeStr = sc.nextLine();

        Card flopOne = new Card(flopOneStr);
        Card flopTwo = new Card(flopTwoStr);
        Card flopThree = new Card(flopThreeStr);

        deck.removeCard(flopOne);
        deck.removeCard(flopTwo);
        deck.removeCard(flopThree);

        hand.addCommunity(flopOne);
        hand.addCommunity(flopTwo);
        hand.addCommunity(flopThree);

        System.out.println(hand);
    }

    private void enterTurn(){
        System.out.println("Enter turn: ");
        String turnStr = sc.nextLine();

        Card turn = new Card(turnStr);

        deck.removeCard(turn);

        hand.addCommunity(turn);

        System.out.println(hand);
    }

    private void enterRiver(){
        System.out.println("Enter river: ");
        String riverStr = sc.nextLine();

        Card river = new Card(riverStr);

        deck.removeCard(river);

        hand.addCommunity(river);

        System.out.println(hand);
    }
}
