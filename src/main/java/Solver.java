import java.util.ArrayList;
import java.util.List;

public class Solver {
    public List<Board> getSolutions(Board partialBoard, List<Card> remainingCards) {
        List<Board> validSolutions = new ArrayList<>();

        if (partialBoard.isSolution()) {
            System.out.println(partialBoard.toString());
            validSolutions.add(partialBoard);
        } else {
            System.out.println(partialBoard.toString());

            List<Card> clonedCards = cloneRemainingCards(remainingCards);
            Card newCard = clonedCards.get(0);
            clonedCards.remove(newCard);

            List<Coordinate> coordsWithEmptyCard = getCoordsWithEmptyCard(partialBoard);

            for (Coordinate coord : coordsWithEmptyCard) {
                for (int i = 0; i < 4; i++) {
                    Board clonedBoard = partialBoard.clone();
                    clonedBoard.getCards().put(coord.clone(), newCard.clone());

                    if (clonedBoard.isSolution()) {
                        List<Board> solutions = getSolutions(clonedBoard, clonedCards);
                        for (Board solution : solutions) {
                            solutions.add(solution);
                        }
                    }
                    newCard = newCard.rotated90DegreesToRight();
                }
            }
        }
        return validSolutions;
    }

    private static List<Card> cloneRemainingCards(List<Card> remainingCards) {
        List<Card> clonedCards = new ArrayList<>();
        for (Card card : remainingCards) {
            clonedCards.add(card.clone());
        }
        return clonedCards;
    }

    private static List<Coordinate> getCoordsWithEmptyCard(Board partialBoard) {
        List<Coordinate> coordsWithEmptyCard = new ArrayList<>();

        for (Coordinate coord : partialBoard.getCards().keySet()) {
            if (partialBoard.getCard(coord) != null) {
                coordsWithEmptyCard.add(coord);
            }
        }
        return coordsWithEmptyCard;
    }
}
