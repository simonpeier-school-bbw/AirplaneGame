import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneGameApplication {
    public static void main(String[] args) throws IOException {
        // get cards from file
        ArrayList<Card> remainingCards = CardReader.readCards();

        // print out cards from file
        remainingCards.forEach(System.out::println);
        System.out.println();

        // find all solutions
        List<Board> solutions = Solver.findAllSolutions(new Board(), remainingCards);

        // print solutions
        printSolutions(solutions);
        // write solutions to file
        SolutionsWriter.writeSolutions(solutions);
    }

    private static void printSolutions(List<Board> solutions) {
        System.out.println("Solutions");
        System.out.println("=====================");
        for (Board board : solutions) {
            System.out.println("= " + board.toString());
        }
    }
}
