import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Coordinate, Card> cards;
    private Coordinate currentCoordinate;

    public Board(Map<Coordinate, Card> cards, Coordinate currentCoordinate) {
        super();
        this.cards = cards;
        this.currentCoordinate = currentCoordinate;
    }

    public Board() {
        cards = new HashMap<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cards.put(new Coordinate(x, y), null);
            }
        }
        currentCoordinate = new Coordinate(0, 0);
    }

    // Add card to board if it fits in between the other cards
    public Board addIfFits(Card card) {

        // Board may be a solution
        Card cardAbove = cards.get(new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1));
        Card cardToRight = cards.get(new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY()));
        Card cardBelow = cards.get(new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1));
        Card cardToLeft = cards.get(new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY()));

        // Surrounding Cards exist -> solution is possible
        if (cardAbove != null) {
            if (!(card.getTop().isBack() == cardAbove.getBottom().isBack() && card.getTop().getColor().equals(cardAbove.getBottom().getColor()))) {
                return null;
            }
        }
        if (cardToRight != null) {
            if (card.getRight().isBack() == cardToRight.getLeft().isBack() && card.getRight().getColor().equals(cardToRight.getLeft().getColor())) {
                return null;
            }
        }
        if (cardBelow != null) {
            if (card.getBottom().isBack() == cardBelow.getTop().isBack() && card.getBottom().getColor().equals(cardBelow.getTop().getColor())) {
                return null;
            }
        }
        if (cardToLeft != null) {
            if (card.getLeft().isBack() == cardToLeft.getRight().isBack() && card.getLeft().getColor().equals(cardToLeft.getRight().getColor())) {
                return null;
            }
        }

        Board board = new Board(cards, nextCoordinate());
        board.setCard(nextCoordinate(), card);
        return board;
    }

    public boolean isSolution() {
        return cards.get(new Coordinate(2, 2)) != null;
    }

    // returns next coordinate of board, if it is the last coordinate, null is returned
    private Coordinate nextCoordinate() {
        int x;
        int y = 0;

        if (currentCoordinate.getX() == 2) {
            x = 0;
            if (currentCoordinate.getY() == 2) {
                return null;
            }
            y = currentCoordinate.getY() + 1;
        } else {
            x = currentCoordinate.getX() + 1;
        }
        return new Coordinate(x, y);
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

    public void setCard(Coordinate coord, Card card) {
        cards.put(coord, card);
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder("Board{cards=");

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board.append(cards.get(new Coordinate(x, y)).toString());
                board.append(" ");
            }
            board.append(System.lineSeparator());
        }
        board.append("}");

        return board.toString();
    }
}