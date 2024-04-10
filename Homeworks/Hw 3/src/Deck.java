import java.util.ArrayList;

public class Deck {
    private playingCard[] cards;

    public Deck() {
        cards = new playingCard[52];
    }
    public void addCard(playingCard card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                break;
            }
        }
    }

    public void addAllCards(ArrayList<playingCard> newCards) {
        for (playingCard card : newCards) {
            if (card != null) {
                addCard(card);
            }
        }
    }

    public playingCard removeCard() {
        playingCard card = null;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                card = cards[i];
                cards[i] = null;
                break;
            }
        }
        return card;
    }

    public void shuffle(){
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = (int) (Math.random() * cards.length);
            playingCard temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public void sort(){
        for (int i = 0; i < cards.length; i++) {
            int minIndex = i;
            for (int j = i; j < cards.length; j++) {
                if (cards[j] != null && cards[j].getRank().ordinal() < cards[minIndex].getRank().ordinal()) {
                    minIndex = j;
                }
            }
            playingCard temp = cards[i];
            cards[i] = cards[minIndex];
            cards[minIndex] = temp;
        }
    }

    public playingCard[] getCards() {
        return cards;
    }

    public void setCards(playingCard[] cards) {
        this.cards = cards;
    }
}
