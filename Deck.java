import java.util.Random;
public class Deck extends Cards{

    Random random = new Random();

    public Deck() {
        super();
        shuffle();
    }

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public String draw() {
        shuffle();
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(random.nextInt(cards.size()));
    }


}
