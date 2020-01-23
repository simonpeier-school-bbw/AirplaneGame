import java.io.IOException;
import java.util.ArrayList;

public class AirPlaneGameApplication {
    public static void main(String[] args) throws IOException {
        CardReader cardReader = new CardReader();

        ArrayList<Card> remainingCards = cardReader.readCards();

        remainingCards.forEach(System.out::println);
    }
}
