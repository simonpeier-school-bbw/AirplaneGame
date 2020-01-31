import java.util.LinkedList;
import java.util.List;

public class Solver {
    public static List<Board> findAllSolutions(Board board, List<Card> cards) {

        List<Board> solutions = new LinkedList<>();

        List<Board> nextPossibleMoves = nextPossibleMoves(board, cards);
        for (Board currentMove : nextPossibleMoves) {
            if (currentMove.isSolution()) {
                solutions.add(currentMove);
            } else {
                Card lastCard = currentMove.getCard(currentMove.getCurrentCoordinate());
                List<Card> remaining = removed(lastCard, cards);
                solutions.addAll(findAllSolutions(currentMove, remaining));
            }
        }

        return solutions;
    }

    public static List<Board> nextPossibleMoves(Board board, List<Card> remainingCards) {

        List<Board> boardsWithOneMoreCard = new LinkedList<>();

        for (Card card : remainingCards) {
            Board addedUnturned = board.addIfFits(card);
            if (addedUnturned != null) {
                boardsWithOneMoreCard.add(addedUnturned);
            }
            for (int turn = 1; turn <= 3; turn++) {
                card = card.rotated90DegreesToRight();
                Board addedTurned = board.addIfFits(card);
                if (addedTurned != null) {
                    boardsWithOneMoreCard.add(addedTurned);
                }
            }
        }

        return boardsWithOneMoreCard;
    }

    private static List<Card> removed(Card lastcard, List<Card> cardsLeft) {
        cardsLeft.remove(lastcard);
        return cardsLeft;
    }
}
