public class Main {
    public static void main(String[] args) {
        Card card1 = new Card(Card.Suit.Hearts, Card.Rank.Ace);
        Card card2 = new Card(Card.Suit.Diamonds, Card.Rank.King);
        Card card3 = new Card(Card.Suit.Clubs, Card.Rank.Queen);

        Hand hand = new Hand();
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);

        System.out.println("Unsorted Hand:");
        hand.display();

        hand.sort();

        System.out.println("\nSorted Hand:");
        hand.display();

        hand.deleteCard(Card.Rank.King, Card.Suit.Diamonds);

        System.out.println("\nHand after deleting King of Diamonds:");
        hand.display();

        hand.store("hand.txt");


        Card card4 = new Card(Card.Suit.Clubs, Card.Rank.Queen);
        hand.addCard(card4);
        hand.sort();
    }
}
