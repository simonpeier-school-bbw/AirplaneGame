import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneGameApplication {
    public static void main(String[] args) throws IOException {
        CardReader cardReader = new CardReader();
        ArrayList<Card> remainingCards = cardReader.readCards();
        remainingCards.forEach(System.out::println);

        Solver solver = new Solver();
        System.out.println();
        System.out.println("Solutions");
        System.out.println("=====================");

        List<Board> solutions = solver.getSolutions(new Board(), remainingCards);
        System.out.println(solutions.size());
        for (Board board : solutions) {
            System.out.println("= " + board.toString());
        }
    }
}
