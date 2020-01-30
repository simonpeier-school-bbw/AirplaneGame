import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Coordinate, Card> cards;

    public Board(Map<Coordinate, Card> cards) {
        super();
        this.cards = cards;
    }

    public Board() {
        cards = new HashMap<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cards.put(new Coordinate(x, y), null);
            }
        }
    }

    public Board clone() {
        Board clonedBoard = new Board();

        for (Coordinate coord : cards.keySet()) {
            Card currentCard = cards.get(coord);

            if (currentCard != null) {
                currentCard = currentCard.clone();
            }

            clonedBoard.getCards().put(coord.clone(), currentCard);
        }

        return clonedBoard;

    }

    public boolean isSolution() {
        for (Map.Entry<Coordinate, Card> entry : this.cards.entrySet()) {
            Card currentCard = entry.getValue();

            // board can't be a solution
            if (currentCard == null) {
                return false;
            }
            // board may be a solution
            else {
                Card cardAbove = cards.get(new Coordinate(entry.getKey().getX(), entry.getKey().getY() + 1));
                Card cardToRight = cards.get(new Coordinate(entry.getKey().getX() + 1, entry.getKey().getY()));
                Card cardBelow = cards.get(new Coordinate(entry.getKey().getX(), entry.getKey().getY() - 1));
                Card cardToLeft = cards.get(new Coordinate(entry.getKey().getX() - 1, entry.getKey().getY()));

                // Surrounding Cards exist -> solution is possible
                if (cardAbove != null) {
                    if (currentCard.getTop().isBack() == cardAbove.getBottom().isBack() && currentCard.getTop().getColor().equals(cardAbove.getBottom().getColor())) {
                        return true;
                    }
                }
                if (cardToRight != null) {
                    if (currentCard.getRight().isBack() == cardToRight.getLeft().isBack() && currentCard.getRight().getColor().equals(cardToRight.getLeft().getColor())) {
                        return true;
                    }
                }
                if (cardBelow != null) {
                    if (currentCard.getBottom().isBack() == cardBelow.getTop().isBack() && currentCard.getBottom().getColor().equals(cardBelow.getTop().getColor())) {
                        return true;
                    }
                }
                if (cardToLeft != null) {
                    if (currentCard.getLeft().isBack() == cardToLeft.getRight().isBack() && currentCard.getLeft().getColor().equals(cardToLeft.getRight().getColor())) {
                        return true;
                    }
                }

            }

        }
        return false;
    }

    public Map<Coordinate, Card> getCards() {
        return cards;
    }

    public Card getCard(Coordinate coord) {
        return cards.get(coord);
    }

    public void setCards(Map<Coordinate, Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder("Board{cards=");

        System.out.println();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.append(cards.get(new Coordinate(x, y))).append(",");
            }
        }
        board.append("}");

        return board.toString();
    }
}