import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CardReader {

    public static ArrayList<Card> readCards() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();

        try {
            // get file from resources
            BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(AirPlaneGameApplication.class.getClassLoader().getResource("cards.txt")).getFile()));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] lineParts = line.split("/");
                Airplane[] airplanes = new Airplane[4];

                // split line up into plane parts
                for (int i = 0; i < lineParts.length; i++) {
                    String[] planeInformation = lineParts[i].split(",");

                    airplanes[i] = new Airplane(planeInformation[0], planeInformation[1].toLowerCase().equals("back"));
                    airplanes[i].setColor(planeInformation[0]);
                }

                // add new Card to list with data from file
                cards.add(new Card(airplanes[0], airplanes[1], airplanes[2], airplanes[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, please enter a valid filepath");
            throw e;
        } catch (IOException e) {
            System.out.println("There was an error with reading a line");
            throw e;
        }
        return cards;
    }
}
