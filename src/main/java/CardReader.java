import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CardReader {

    public ArrayList<Card> readCards() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(Objects.requireNonNull(AirPlaneGameApplication.class.getClassLoader().getResource("cards.txt")).getFile()));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] lineParts = line.split("/");
                Airplane[] airplanes = new Airplane[4];

                for (int i = 0; i < lineParts.length; i++) {
                    String[] planeInformation = lineParts[i].split(",");
                    airplanes[i].setColor(planeInformation[0]);

                    if (planeInformation[1].toLowerCase().equals("back")) {
                        airplanes[i].setBack(true);
                    } else {
                        airplanes[i].setBack(false);
                    }
                }

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
