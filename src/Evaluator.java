import java.util.ArrayList;
import java.util.List;
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

    public void run(){
        enterPocket();
        evaluate();

        enterFlop();
        evaluate();

        enterTurn();
        evaluate();

        enterRiver();
        evaluate();
    }

    public void evaluate(){
        List<Card> evaluatedHand = new ArrayList<>();
        if((evaluatedHand = hand.getStraightFlush()).size() != 0){
            String currentSuit = evaluatedHand.get(0).getSuit();
            if(evaluatedHand.contains(new Card("A", currentSuit))){
                System.out.println("You have a roual flush:");
            }
            else {
                System.out.println("You have a straight flush:");
            }
        }
        else if((evaluatedHand = hand.getFourOfAKind()).size() != 0){
            System.out.println("You have four of a kind:");
        }
        else if((evaluatedHand = hand.getFullHouse()).size() != 0){
            System.out.println("you have a full house:");
        }
        else if((evaluatedHand = hand.getFlush()).size() != 0){
            System.out.println("you have a flush:");
        }
        else if((evaluatedHand = hand.getStraight()).size() != 0){
            System.out.println("You have a straight:");
        }
        else if((evaluatedHand = hand.getThreeOfAKind()).size() != 0){
            System.out.println("You have three of a kind: ");
        }
        else if((evaluatedHand = hand.getPairs()).size() != 0){
            if(evaluatedHand.size() > 2){
                System.out.println("You have two pair: ");
            }
            else{
                System.out.println("You have a pair: ");
            }
        }
        else{
            evaluatedHand.add(hand.getHighCard());
            System.out.println("you have high card: ");
        }
        System.out.println(evaluatedHand + "\n");
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
        System.out.println("\tSecond Card:");
        String flopTwoStr = sc.nextLine();
        System.out.println("\tThird Card:");
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

    public static void main(String [] args){
        Evaluator eval = new Evaluator();
        eval.run();
    }
}
