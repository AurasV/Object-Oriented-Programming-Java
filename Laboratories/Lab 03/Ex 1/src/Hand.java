import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Storable {
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void deleteCard(Card.Rank rank, Card.Suit suit) {
        for (Card card : cards) {
            if (card.getRank() == rank && card.getSuit() == suit) {
                cards.remove(card);
                break;
            }
        }
    }


    public void sort() {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                int suitComparison = card1.getSuit().compareTo(card2.getSuit());
                if (suitComparison != 0) {
                    return suitComparison;
                }

                int rankComparison = card1.getRank().compareTo(card2.getRank());
                if (rankComparison == 0) {
                    try {
                        throw new CustomCardComparisonException("Two cards are equal.");
                    } catch (CustomCardComparisonException e) {
                        throw new RuntimeException(e);
                    }
                }

                return rankComparison;
            }
        });
    }


    public Card getCard(int index){
        return cards.get(index);
    }

    public int getSize(){
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void store(String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Card card : cards) {
                writer.write(card.getRank() + " of " + card.getSuit());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(){
        for (Card card : cards) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }
}