import java.util.ArrayList;

public class War {
    private Deck deck_player1;
    private Deck deck_player2;


    public War(Deck deck1, Deck deck2) {
        this.deck_player1 = deck1;
        this.deck_player2 = deck2;
    }

    public void play() {
        int turns = 0;
        while (deck_player1.getCards().length > 0 && deck_player2.getCards().length > 0) {
            turns++;
            playingCard card1 = deck_player1.removeCard();
            playingCard card2 = deck_player2.removeCard();
            try{
                card2.getRank();
                card2.getSuit();
            }
            catch (NullPointerException e) {
                System.out.println("Player 2 ran out of cards");
                break;
            }
            try{
                card1.getRank();
                card1.getSuit();
            }
            catch (NullPointerException e) {
                System.out.println("Player 1 ran out of cards");
                break;
            }

            System.out.println("Turn " + turns + ": " + card1.getRank() + " of " + card1.getSuit() + " vs " + card2.getRank() + " of " + card2.getSuit());

            if (card1.getRank().ordinal() > card2.getRank().ordinal()) {
                System.out.println("Player 1 wins this round!");
                deck_player1.addCard(card1);
                deck_player1.addCard(card2);
            } else if (card1.getRank().ordinal() < card2.getRank().ordinal()) {
                System.out.println("Player 2 wins this round!");
                deck_player2.addCard(card1);
                deck_player2.addCard(card2);
            } else {
                System.out.println("It's a tie! A war begins...");

                if (deck_player1.getCards().length < 4 || deck_player2.getCards().length < 4) {
                    System.out.println("Not enough cards for a war. Player " + (deck_player1.getCards().length < 4 ? "2" : "1") + " wins the game!");
                    break;
                }

                ArrayList<playingCard> warCardsPlayer1 = new ArrayList<>();
                ArrayList<playingCard> warCardsPlayer2 = new ArrayList<>();

                for (int i = 0; i < 3; i++) {
                    warCardsPlayer1.add(deck_player1.removeCard());
                    warCardsPlayer2.add(deck_player2.removeCard());
                }

                playingCard faceUpCard1 = deck_player1.removeCard();
                playingCard faceUpCard2 = deck_player2.removeCard();

                System.out.println("Player 1's face-up card: " + faceUpCard1.getRank() + " of " + faceUpCard1.getSuit());
                System.out.println("Player 2's face-up card: " + faceUpCard2.getRank() + " of " + faceUpCard2.getSuit());

                if (faceUpCard1.getRank().ordinal() > faceUpCard2.getRank().ordinal()) {
                    System.out.println("Player 1 wins the war!");
                    deck_player1.addCard(card1);
                    deck_player1.addCard(card2);
                    deck_player1.addAllCards(warCardsPlayer1);
                    deck_player1.addAllCards(warCardsPlayer2);
                } else if (faceUpCard1.getRank().ordinal() < faceUpCard2.getRank().ordinal()) {
                    System.out.println("Player 2 wins the war!");
                    deck_player2.addCard(card1);
                    deck_player2.addCard(card2);
                    deck_player2.addAllCards(warCardsPlayer1);
                    deck_player2.addAllCards(warCardsPlayer2);
                } else {
                    System.out.println("Another tie! A new war begins...");

                    warCardsPlayer1.add(card1);
                    warCardsPlayer1.add(faceUpCard1);
                    warCardsPlayer2.add(card2);
                    warCardsPlayer2.add(faceUpCard2);

                    recursiveWar(warCardsPlayer1, warCardsPlayer2);
                }
            }
        }
        if (deck_player1.getCards().length == 0) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }

    private void recursiveWar(ArrayList<playingCard> warCardsPlayer1, ArrayList<playingCard> warCardsPlayer2) {
        if (warCardsPlayer1.size() < 4 || warCardsPlayer2.size() < 4) {
            System.out.println("Not enough cards for a war. Player " + (warCardsPlayer1.size() < 4 ? "2" : "1") + " wins the game!");
            return;
        }

        for (int i = 0; i < 3; i++) {
            warCardsPlayer1.add(warCardsPlayer1.remove(0));
            warCardsPlayer2.add(warCardsPlayer2.remove(0));
        }

        playingCard faceUpCard1 = warCardsPlayer1.remove(0);
        playingCard faceUpCard2 = warCardsPlayer2.remove(0);

        if (faceUpCard1.getRank().ordinal() > faceUpCard2.getRank().ordinal()) {
            System.out.println("Player 1 wins the war!");
            deck_player1.addAllCards(warCardsPlayer1);
            deck_player1.addAllCards(warCardsPlayer2);
        } else if (faceUpCard1.getRank().ordinal() < faceUpCard2.getRank().ordinal()) {
            System.out.println("Player 2 wins the war!");
            deck_player2.addAllCards(warCardsPlayer1);
            deck_player2.addAllCards(warCardsPlayer2);
        } else {
            System.out.println("Another tie! A new war begins...");
            recursiveWar(warCardsPlayer1, warCardsPlayer2);
        }
    }

    public Deck getDeck_player1() {
        return deck_player1;
    }

    public void setDeck_player1(Deck deck_player1) {
        this.deck_player1 = deck_player1;
    }

    public Deck getDeck_player2() {
        return deck_player2;
    }

    public void setDeck_player2(Deck deck_player2) {
        this.deck_player2 = deck_player2;
    }
}
