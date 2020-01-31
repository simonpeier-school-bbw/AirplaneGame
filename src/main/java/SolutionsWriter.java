import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SolutionsWriter {
    public static void writeSolutions(List<Board> boards) throws IOException {
        FileWriter fileWriter = new FileWriter("solutions.txt");
        fileWriter.write("Solutions" + System.lineSeparator());
        fileWriter.write("=====================" + System.lineSeparator());
        fileWriter.write("" + System.lineSeparator());

        for (Board board : boards) {
            fileWriter.write(board.toString() + System.lineSeparator());
            fileWriter.write("=====================" + System.lineSeparator());
        }
        fileWriter.close();
    }
}
