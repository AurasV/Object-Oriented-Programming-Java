public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (playingCard.Suit suit : playingCard.Suit.values()) {
            for (playingCard.Rank rank : playingCard.Rank.values()) {
                deck.addCard(new playingCard(rank, suit));
            }
        }
        deck.shuffle();
        for (playingCard card : deck.getCards()) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        System.out.println("-----------------------------------");
        deck.sort();
        for (playingCard card : deck.getCards()) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        deck.shuffle();
        System.out.println("-----------------------------------");
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        for (int i = 0; i < 26; i++) {
            deck1.addCard(deck.removeCard());
            deck2.addCard(deck.removeCard());
        }
        War war = new War(deck1, deck2);
        war.play();
    }
}