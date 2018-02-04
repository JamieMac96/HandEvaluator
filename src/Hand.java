import java.util.*;

public class Hand {

    private List<Card> pocketCards;
    private List<Card> communityCards;

    public static int HIGH_CARD = 0;
    public static int PAIR = 1;
    public static int TWO_PAIR = 2;
    public static int SET = 3;
    public static int STRAIGHT = 4;
    public static int FLUSH = 5;
    public static int FULL_HOUSE = 6;
    public static int FOUR_OF_A_KIND = 7;
    public static int STRAIGHT_FLUSH = 8;
    public static int ROYAL_FLUSH = 9;


    public Hand(){
        pocketCards = new ArrayList<>();
        communityCards = new ArrayList<>();
    }

    public List<Card> getPocketCards() {
        return pocketCards;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void addPocket(Card card){
        pocketCards.add(card);
    }

    public void addCommunity(Card card){
        communityCards.add(card);
    }

    public List<Card> getPairs()
    {
        List<Card> returnPair = new ArrayList<>();
        List<Card> pairs = new ArrayList<>();
        List<Card> allCards = getAllCards();
        Deck.sortByValue(allCards);

        while((returnPair = getCardsOfSameKind(allCards, 2)).size() != 0){
            pairs.addAll(returnPair);
            allCards.removeAll(returnPair);
        }

        return pairs;
    }

    public List<Card> getPair(){
        List<Card> allCards = getAllCards();
        Deck.sortByValue(allCards);

        return getCardsOfSameKind(allCards, 2);
    }

    public List<Card> getThreeOfAKind()
    {
        List<Card> allCards = getAllCards();

        Deck.sortByValue(allCards);

        return getCardsOfSameKind(allCards, 3);
    }

    public List<Card> getStraight(){
        int straightCount = 1;
        List<Card> straight = new ArrayList<>();

        List<Card> allCards = getAllCards();
        Deck.sortByValue(allCards);

        for (int i = allCards.size() - 2; i >= 0; i--){
            if(allCards.get(i + 1).getIntValue() == allCards.get(i).getIntValue() + 1){
                straightCount++;
            }
            else{
                straightCount = 1;
            }
            if(straightCount == 5){
                for(int j = i; j < i + 5; j++){
                    straight.add(allCards.get(j));
                }
                return straight;
            }
        }

        return new ArrayList<>();
    }

    public List<Card> getFlush()
    {
        List<Card> spades = new ArrayList<>();
        List<Card> clubs = new ArrayList<>();
        List<Card> diamonds = new ArrayList<>();
        List<Card> hearts = new ArrayList<>();

        List<Card> allCards = getAllCards();

        for(Card card: allCards){
            switch (card.getSuit()){
                case Card.CLUBS:
                    clubs.add(card);
                    break;
                case Card.SPADES:
                    spades.add(card);
                    break;
                case Card.DIAMONDS:
                    diamonds.add(card);
                    break;
                case Card.HEARTS:
                    hearts.add(card);
                    break;
            }
        }

        if(spades.size() == 5) return spades;
        if(clubs.size() == 5) return clubs;
        if(diamonds.size() == 5) return diamonds;
        if(hearts.size() == 5) return hearts;
        return new ArrayList<>();
    }

    public List<Card> getFullHouse(){
        List<Card> house = new ArrayList<>();

        // Sort the cards
        List<Card> allCards = getAllCards();
        Deck.sortByValue(allCards);
        // Identify the three of a kind that con
        List<Card> threeOfAKind = getCardsOfSameKind(allCards, 3);

        house.addAll(threeOfAKind);
        allCards.removeAll(threeOfAKind);

        List<Card> pair = getCardsOfSameKind(allCards, 2);
        house.addAll(pair);

        // Return the relevant cards.
        if(house.size() == 5){
            return house;
        }
        else{
            return new ArrayList<>();
        }
    }

    public List<Card> getFourOfAKind(){
        List<Card> allCards = getAllCards();
        Deck.sortByValue(allCards);

        return getCardsOfSameKind(allCards, 4);
    }

    public List<Card> getStraightFlush(){
        List<Card> flush = getFlush();

        Deck.sortByValue(flush);

        for(int i = 1; i < flush.size(); i++){
            if(flush.get(i).getIntValue() !=
                    flush.get(i - 1).getIntValue() + 1){
                return new ArrayList<>();
            }
        }

        return flush;
    }

    public Map<String, Integer> getCardValueFrequencies(){
        List<Card> availableCards = new ArrayList<>();
        Map<String, Integer> frequencies = new HashMap<>();

        availableCards.addAll(pocketCards);
        availableCards.addAll(communityCards);

        for(Card card: availableCards){
            if(!frequencies.containsKey(card.getValue())){
                frequencies.put(card.getValue(), 1);
            }
            else{
                frequencies.put(card.getValue(), frequencies.get(card.getValue()) + 1);
            }
        }

        return frequencies;
    }

    @Override
    public String toString(){
        String string = "Community: " + communityCards.toString();
        string += "\nPocket: " + pocketCards.toString();
        return string;
    }

    private List<Card> getAllCards(){
        List<Card> allCards = new ArrayList<>();

        allCards.addAll(pocketCards);
        allCards.addAll(communityCards);

        return allCards;
    }

    // This helper method takes a list of cards (sorted by value - ascending)
    // and returns cards of the same value. The number of cards of the same
    // value is determined by numCards. For example if numCards = 4 then we are
    // looking for four of a kind in sortedCards.
    private List<Card> getCardsOfSameKind(List<Card> sortedCards, int numCards){
        int kindCount = 1;
        List<Card> cardsOfSameKind = new ArrayList<>();

        // Iterate backwards to identify largest cards first.
        for (int i = sortedCards.size() - 2; i >= 0 ; i--){
            String currentCardValue = sortedCards.get(i + 1).getValue();
            String nextCardValue = sortedCards.get(i).getValue();

            if(currentCardValue.equals(nextCardValue)){
                kindCount++;
            }
            else{
                kindCount = 1;
            }

            if(kindCount == numCards){
                for(int j = i; j < i + numCards; j++) {
                    cardsOfSameKind.add(sortedCards.get(j));
                }
                return cardsOfSameKind;
            }
        }
        return new ArrayList<>();
    }

    public Card getHighCard() {
        if(pocketCards.get(0).getIntValue() >
                pocketCards.get(1).getIntValue()){
            return pocketCards.get(0);
        }
        else{
            return pocketCards.get(1);
        }
    }
}
