import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneGameApplication {
    public static void main(String[] args) throws IOException {
        CardReader cardReader = new CardReader();
        ArrayList<Card> remainingCards = cardReader.readCards();
        remainingCards.forEach(System.out::println);

        System.out.println();
        System.out.println("Solutions");
        System.out.println("=====================");

        // find all solutions
        List<Board> solutions = Solver.findAllSolutions(new Board(), remainingCards);
        // print solutions
        System.out.println(solutions.size());
        // write solutions to file
        printSolutions(solutions);

        SolutionsWriter.writeSolutions(solutions);
    }

    private static void printSolutions(List<Board> solutions){
        for (Board board : solutions) {
            System.out.println("= " + board.toString());
        }
    }
}
